CC = gcc
CFLAGS = -Wall -Wextra

SRC = parent.c monitor.c worker.c
OBJ = $(SRC:.c=.o)
EXEC = app_file_bot.exe
DEPS = files_bot.h

all: $(EXEC)

$(EXEC): $(OBJ)
	$(CC) $(CFLAGS) $(OBJ) -o $(EXEC) 

%.o: %.c $(DEPS)
	$(CC) -D_DEFAULT_SOURCE $(CFLAGS) -c $< -o $@

clean:
	rm -f $(OBJ) $(EXEC)
