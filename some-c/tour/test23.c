#include <stdio.h>
#include <errno.h>
#include <string.h>
#include <stdlib.h>

extern int errno;

int main()
{

    // 错误处理
    FILE *pf;
    pf = fopen("noexit.txt", "r");
    if (pf == NULL)
    {
        fprintf(stderr, "Value of errno: %d\n", errno);
        perror("Error printed by perror");
        fprintf(stderr, "Error opening file: %s\n", strerror(errno));
    }
    else
    {

        fclose(pf);
    }
    // EXIT_FAILURE -1 / EXIT_SUCCESS 0
    return EXIT_SUCCESS;
}