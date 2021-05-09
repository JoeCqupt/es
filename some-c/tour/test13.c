#include <stdio.h>
#include <time.h>
#include <stdlib.h>
int *genArray();

int main()
{
    int i = 2;
    int *p = &i;
    int **p2 = &p;

    printf("p2 : %p \n", p2);
    printf("p2 value : %d \n", **p2);

    printf("=======================\n");

    long l = 0l;
    long *p3; //该指针指向未知
    printf("p3: %p  \n", p3);

    p3 = &l;
    *p3 = time(NULL);
    printf("time: %ld  \n", *p3);

    printf("=======================\n");

    int length = 10;
    int *arr = genArray();
    for (int i = 0; i < length; i++)
    {
        printf("idx:%d val:%d \n", i, arr[i]);
    }

    return 0;
}

int *genArray()
{   
    int length = 10;
    static int arr[10];
    srand((unsigned)time(NULL)); //设置种子
    for (int i = 0; i < length; i++)
    {
        arr[i] = rand();
    }
    return arr;
}