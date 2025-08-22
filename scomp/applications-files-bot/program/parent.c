#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <dirent.h>
#include <signal.h>
#include <errno.h>
#include <string.h>
#include "files-bot.h"
#include <ctype.h>
#include <semaphore.h>
#include <fcntl.h>
#include <sys/mman.h>
#include <signal.h>

char input_dir[MAX_PATH_LENGTH];
char output_dir[MAX_PATH_LENGTH];
int num_workers;
int check_interval;

pid_t monitor_pid;
pid_t *worker_pids;

int num_assigned_ids = 0;
long *assigned_ids;
int report_fd;

void end(int sig)
{
    kill(monitor_pid, SIGKILL);
    for (int i = 0; i < num_workers; i++)
    {
        kill(worker_pids[i], SIGKILL);
    }
    close(report_fd);
    sem_unlink("sem_monitor");
    printf("\nProgram finished.\n");
    exit(EXIT_SUCCESS);
}

int read_config(const char *filename, char *input_dir, char *output_dir, int *num_workers, int *check_interval)
{
    printf("\nReading configuration file...\n");

    FILE *file = fopen(filename, "r");
    if (file == NULL)
    {
        perror("\nERROR: fopen() failed for config file\n");
        return -1;
    }

    int file_scan = fscanf(file, "input_dir: '%[^']'\noutput_dir: '%[^']'\nnum_workers: %d\ncheck_interval: %d", input_dir, output_dir, num_workers, check_interval);
    printf("\nConfiguration file read with output: %d \ninput_dir: %s\noutput_dir: %s\nnum_workers: %d\ncheck_interval: %d\n", file_scan, input_dir, output_dir, *num_workers, *check_interval);

    // Ler configurações do arquivo
    if (file_scan != 4)
    {
        perror("\nERROR: fscanf() failed for configuration file.\n");
        fclose(file);
        return -1;
    }

    fclose(file);
    return 0;
}

int create_monitor(sem_t *sem_monitor)
{
    printf("\nCreating monitor process...\n");

    monitor_pid = fork();

    if (monitor_pid == -1)
    {
        perror("\nERROR: fork() failed at create_monitor()\n");
        return -1;
    }

    if (monitor_pid == 0)
    {
        start_monitor(input_dir, sem_monitor, check_interval);
    }

    return 0;
}

int create_and_store_workers(long *workers_shm, int report_fd)
{

    printf("\nCreating worker processes...\n");

    worker_pids = malloc(num_workers * sizeof(pid_t));
    if (worker_pids == NULL)
    {
        perror("\nERROR: malloc() failed at create_and_store_workers()\n");
        return -1;
    }

    if (workers_shm == MAP_FAILED)
    {
        perror("\nERROR: mmap() failed at create_and_store_workers()\n");
        return -1;
    }

    sem_t* sem_report=sem_open("sem_report", O_CREAT | O_TRUNC, 0644, 1);
    pid_t pid;

    for (int i = 0; i < num_workers; i++)
    {
        pid = fork();
        if (pid == -1)
        {
            perror("\nERROR: fork() failed at create_and_store_workers()\n");
            return -1;
        }

        if (pid == 0)
        {
            start_worker(input_dir, output_dir, check_interval, report_fd, &workers_shm[i], sem_report); // A memória partilhada está dividida em secções segundo a quantidade de filhos operadores, mas passa-se apenas a secção do filho respetivo
            break;
        }
        else if (pid > 0)
        {
            worker_pids[i] = pid;
        }
    }
    return 0;
}

long get_app_id_from_filename(const char *filename)
{
    char *end;
    long app_id = strtol(filename, &end, 10);

    if (end == filename || *end != '-')
    {
        // A conversão falhou ou o próximo caractere não é um '-'
        return -1;
    }

    return app_id;
}

int is_app_assigned(long app_id)
{

    for (int i = 0; i < num_assigned_ids; i++)
    {
        if (assigned_ids[i] == app_id)
        {
            return 1;
        }
    }

    return 0;
}

int assign_files(long *workers_shm)
{

    DIR *dir = opendir(input_dir);
    if (dir == NULL)
    {
        perror("\nERROR: opendir() failed at assign_files()\n");
        return -1;
    }

    struct dirent *entry;

    while ((entry = readdir(dir)) != NULL)
    {
        long app_id = get_app_id_from_filename(entry->d_name);

        if (is_app_assigned(app_id) == 0 && app_id > 0)
        {

            if (assigned_ids == NULL)
            {
                assigned_ids = malloc(sizeof(long));
            }
            else
            {
                assigned_ids = realloc(assigned_ids, (num_assigned_ids + 1) * sizeof(long));
            }

            if (assigned_ids == NULL)
            {
                perror("\nERROR: malloc()/realloc() failed at assign_files()\n");
                closedir(dir);
                return -1;
            }

            for (int i = 0; i < num_workers; i++)
            {
                if (workers_shm[i] == 0)
                {
                    workers_shm[i] = app_id;
                    num_assigned_ids++;
                    assigned_ids[num_assigned_ids - 1] = app_id;
                    printf("\nApplication with id %ld assigned to worker%d\n", app_id, i + 1);
                    break;
                }
            }
        }
    }

    closedir(dir);
    return 0;
}

int main()
{
    struct sigaction act;
    memset(&act, 0, sizeof(struct sigaction));
    act.sa_handler = end;
    sigaction(SIGINT, &act, NULL);

    // Leitura das configurações do arquivo de configuração
    if (read_config(CONFIG_FILE, input_dir, output_dir, &num_workers, &check_interval) == -1)
    {
        perror("\nError reading configuration file.\n");
        exit(EXIT_FAILURE);
    }

    // Criação do processo monitor
    sem_unlink("sem_monitor");
    sem_t *sem_monitor = sem_open("sem_monitor", O_CREAT | O_EXCL, 0644, 1);

    if (create_monitor(sem_monitor) == -1)
    {
        perror("\nError creating monitor process.\n");
        exit(EXIT_FAILURE);
    }

    
    int fd = shm_open("workers", O_CREAT | O_RDWR | O_TRUNC, S_IRUSR | S_IWUSR);
    if (ftruncate(fd, sizeof(long) * num_workers) == -1)
    {
        perror("\nERROR: ftruncate() failed at create_and_store_workers()\n");
        return -1;
    }
    long *workers_shm = (long *)mmap(NULL, sizeof(long) * num_workers, PROT_READ | PROT_WRITE, MAP_SHARED, fd, 0);
    
    // Criação dos processos workers
    char report_path[MAX_PATH_LENGTH];
    sprintf(report_path, "%s/report.txt", output_dir);
    report_fd=open(report_path, O_RDWR | O_CREAT);
    if (create_and_store_workers(workers_shm, report_fd) == -1)
    {
        perror("\nError creating worker processes.\n");
        exit(EXIT_FAILURE);
    }

    int sem_monitor_value;

    while (1)
    {

        sem_getvalue(sem_monitor, &sem_monitor_value);

        if (sem_monitor_value == 1)
        {
            assign_files(workers_shm);

            sem_wait(sem_monitor);
            sem_getvalue(sem_monitor, &sem_monitor_value);
            printf("\nParent switched semaphore down - SEM_VALUE = %d\n", sem_monitor_value);
        }

        sleep(check_interval);
    }
}
