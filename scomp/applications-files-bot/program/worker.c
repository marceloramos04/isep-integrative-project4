#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <dirent.h>
#include <string.h>
#include <errno.h>
#include <signal.h>
#include <fcntl.h>
#include "files-bot.h"

#define CANDIDATE_DATA_FILE "candidate-data.txt"

// Função para criar um diretório se ele não existir
int create_directory(const char *path)
{
    printf("\nCreating directory '%s'\n", path);
    struct stat st = {0};
    if (stat(path, &st) == -1)
    {
        if (mkdir(path, 0777) == -1)
        {
            perror("\nERROR: mkdir() failed\n");
            return -1;
        }
    }

    printf("\nDirectory created: '%s'\n", path);
    return 0;
}

int get_app_files(const char *input_dir, long app_id, char ***files_names, int *num_files)
{
    DIR *dir = opendir(input_dir);
    if (dir == NULL)
    {
        perror("\nERROR: opendir() failed at get_app_files()\n");
        return -1;
    }

    struct dirent *entry;
    printf("\n");
    while ((entry = readdir(dir)) != NULL)
    {
        if (strtol(entry->d_name, NULL, 10) == app_id)
        {
            if (*num_files > 0)
            {
                *files_names = realloc(*files_names, (*num_files + 1) * sizeof(char *));
                if (*files_names == NULL)
                {
                    perror("\nERROR: realloc() failed at get_app_files()\n");
                    closedir(dir);
                    return -1;
                }
            }

            (*num_files)++;

            (*files_names)[*num_files - 1] = malloc(sizeof(char) * MAX_FILENAME_LENGTH);
            if ((*files_names)[*num_files - 1] == NULL)
            {
                perror("\nERROR: malloc() failed at get_app_files()\n");
                closedir(dir);
                return -1;
            }

            if (strcpy((*files_names)[*num_files - 1], entry->d_name) == NULL)
            {
                perror("\nERROR: strcpy() failed at get_app_files()\n");
                closedir(dir);
                return -1;
            }

            printf("File '%s' added to files_names[%d] array for application %ld\n", (*files_names)[*num_files - 1], *num_files - 1, app_id);
        }
    }

    closedir(dir);
    return 0;
}

int get_job_offer(const char *in_dir, long app_id, char *job_offer)
{
    char data_file_name[MAX_FILENAME_LENGTH];
    sprintf(data_file_name, "%ld-%s", app_id, CANDIDATE_DATA_FILE);
    printf("\nData file name for app%ld: '%s'\n", app_id, data_file_name);

    DIR *dir = opendir(in_dir);
    if (dir == NULL)
    {
        perror("\nERROR: opendir() failed at get_job_offer()\n");
        return -1;
    }

    struct dirent *entry;

    while ((entry = readdir(dir)) != NULL)
    {

        if (strcmp(entry->d_name, data_file_name))
        {
            char data_file_path[MAX_PATH_LENGTH];
            sprintf(data_file_path, "%s/%s", in_dir, data_file_name);
            printf("\nData file found for app%ld: '%s'\n", app_id, data_file_path);

            FILE *data_file = fopen(data_file_path, "r");
            if (data_file == NULL)
            {
                perror("\nERROR: fopen() failed at process_app_files()\n");
                closedir(dir);
                return -1;
            }

            if (fscanf(data_file, "%s\n", job_offer) != 1)
            {
                perror("\nERROR: fscanf() failed at process_app_files()\n");
                fclose(data_file);
                closedir(dir);
                return -1;
            }

            printf("\nJob offer for application %ld: %s\n", app_id, job_offer);
            fclose(data_file);
            closedir(dir);
            return 0;
        }
    }

    printf("\nData file not found for app%ld\n", app_id);
    closedir(dir);
    return -1;
}

// Função para copiar um arquivo
int move_files(const char *source, const char *destination)
{
    printf("\nCopying file '%s' to '%s'\n", source, destination);

    int fd_in, fd_out;
    ssize_t bytes_read;
    char buffer[BUFSIZ];

    fd_in = open(source, O_RDONLY);
    if (fd_in == -1)
    {
        perror("\nERROR: open() failed for input file descriptor\n");
        return -1;
    }

    fd_out = open(destination, O_WRONLY | O_CREAT | O_TRUNC, 0644);
    if (fd_out == -1)
    {
        perror("\nERROR: open() failed for output file descriptor\n");
        close(fd_in);
        return -1;
    }

    while ((bytes_read = read(fd_in, buffer, BUFSIZ)) > 0)
    {
        if (write(fd_out, buffer, bytes_read) != bytes_read)
        {
            perror("\nERROR: write() failed at move_files()\n");
            close(fd_in);
            close(fd_out);
            return -1;
        }
    }

    if (bytes_read == -1)
    {
        perror("\nERROR: read() failed\n");
        close(fd_in);
        close(fd_out);
        return -1;
    }

    close(fd_in);
    close(fd_out);
    if (remove(source) == -1)
    {
        perror("\nERROR: remove(source) failed at move_files()\n");
        return -1;
    }

    printf("\nFile copied from '%s' to '%s'\n", source, destination);
    return 0;
}

int create_job_offer_dir(const char *in_dir, char *job_offer)
{
    char job_offer_dir[MAX_PATH_LENGTH];
    sprintf(job_offer_dir, "%s/%s", in_dir, job_offer);

    if (create_directory(job_offer_dir) == -1)
    {
        printf("\nWARNING: couldn't create directory or it already exists: '%s'\n", job_offer_dir);
        return -1;
    }

    return 0;
}

int process_app_files(const char *input_dir, const char *output_dir, int report_fd, sem_t* sem_report, char *job_offer, long app_id, char **files_names, int *num_files)
{
    create_job_offer_dir(output_dir, job_offer);

    char app_out_dir[MAX_PATH_LENGTH];
    sprintf(app_out_dir, "%s/%s/%ld", output_dir, job_offer, app_id);

    if (create_directory(app_out_dir) == -1)
    {
        perror("\nERROR: create_directory() failed at process_app_files()\n");
        return -1;
    }

    //sem_wait(sem_report);
    for (int i = 0; i < *num_files; i++)
    {
        char source[MAX_PATH_LENGTH];
        sprintf(source, "%s/%s", input_dir, files_names[i]);

        char destination[MAX_PATH_LENGTH];
        if ((strlen(app_out_dir) + strlen(files_names[i]) + sizeof("/")) > sizeof(destination))
        {
            printf("\nERROR: destination is too long for its container\n");
            return -1;
        }
        else
        {
            sprintf(destination, "%s/%s", app_out_dir, files_names[i]);
        }

        if (move_files(source, destination) == -1)
        {
            perror("\nERROR: move_files() failed at process_app_files()\n");
            return -1;
        }

        char app_file_entry[MAX_PATH_LENGTH];
        sprintf(app_file_entry, "%s\n", destination);
        if (write(report_fd, app_file_entry, strlen(app_file_entry)) == -1)
        {
            perror("\nERROR: write() failed at process_app_files()\n");
            return -1;
        }
    }

    //write(report_fd, "\n", 1);
    //sem_post(sem_report);

    return 0;
}

void start_worker(const char *input_dir, const char *output_dir, int check_interval, int report_fd, long *workers_shm, sem_t* sem_report)
{
    printf("\nWorker process started...\n");

    while (1)
    {
        if (*workers_shm > 0)
        {
            long app_id = *workers_shm;
            int num_files = 0;
            char **files_names = malloc(sizeof(char *));
            if (files_names == NULL)
            {
                perror("\nERROR: malloc() failed at start_worker()\n");
                exit(EXIT_FAILURE);
            }

            if (get_app_files(input_dir, app_id, &files_names, &num_files) == -1)
            {
                perror("\nERROR: get_app_files() failed\n");
                exit(EXIT_FAILURE);
            }

            char job_offer[MAX_FILENAME_LENGTH];
            if (get_job_offer(input_dir, app_id, job_offer) == -1)
            {
                perror("\nERROR: get_job_offer() failed\n");
                exit(EXIT_FAILURE);
            }

            if (process_app_files(input_dir, output_dir, report_fd, sem_report, job_offer, app_id, files_names, &num_files) == -1)
            {
                perror("\nERROR: process_app_files() failed\n");
                exit(EXIT_FAILURE);
            }

            free(files_names);
            *workers_shm = 0;
        }

        sleep(check_interval);
    }
}
