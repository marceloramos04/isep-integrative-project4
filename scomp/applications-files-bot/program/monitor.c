#include <stdio.h>
#include <stdlib.h>
#include <semaphore.h>
#include <dirent.h>
#include <sys/types.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>

#define DIR_HAS_FILES 1
#define DIR_IS_EMPTY 0

int dir_has_files(const char *path)
{

    int return_value = DIR_IS_EMPTY;
    DIR *dir = opendir(path);
    if (dir == NULL)
    {
        printf("\nERROR: opendir() failed at dir_has_files()\n");
        return -1;
    }

    struct dirent *entry;
    while ((entry = readdir(dir)) != NULL)
    {
        if (strcmp(entry->d_name, ".") != 0 && strcmp(entry->d_name, "..") != 0)
        {
            return_value = DIR_HAS_FILES;
        }
    }

    closedir(dir);
    return return_value;
}

void start_monitor(const char *input_dir, sem_t *sem_monitor, int check_interval)
{

    printf("\nMonitor process started...\n");

    int has_files;

    while (1)
    {
        has_files = dir_has_files(input_dir);
        if (has_files == -1)
        {
            printf("\nERROR: dir_has_files() failed\n");
            exit(EXIT_FAILURE);
        }

        if (has_files == 1)
        {
            int ok = 0;
            int sem_value;

            do
            {
                sem_getvalue(sem_monitor, &sem_value);

                if (sem_value == 0)
                { // check if parent already received previous signal

                    sem_post(sem_monitor); // set semaphore up to warn parent for new files
                    sem_getvalue(sem_monitor, &sem_value);
                    printf("\nMonitor switched semaphore up - SEM_VALUE = %d\n", sem_value);
                    ok = 1;
                }
                else
                {
                    sleep(5);
                }

            } while (ok == 0);
        }

        sleep(check_interval); // sleep for while until new check on new files
    }
}