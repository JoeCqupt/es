#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{

    printf("argc: %d \n", argc);
    printf("argv[0]:%s \n", *argv); // 程序名
    printf("argv[1]:%s \n", *(argv + 1));

    return EXIT_SUCCESS;
}