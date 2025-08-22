#include <semaphore.h>

#ifndef APPLICATIONS_FILE_BOT_H
#define APPLICATIONS_FILE_BOT_H

#define CONFIG_FILE "config"
#define MAX_PATH_LENGTH 256
#define MAX_FILENAME_LENGTH 50

void start_monitor(const char *input_dir, const sem_t *sem_monitor, const int check_interval);

void start_worker(const char *input_dir, const char *output_dir, int check_interval, int report_fd, long* workers_shm, sem_t* sem_report);

#endif
