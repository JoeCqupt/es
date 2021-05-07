#include <stdio.h>
void printArray(int[], int);
void printArray2(int (*arr)[4], int, int);

int main()
{

    int a1[5] = {1};
    printArray(a1, 5);

    //注意看这里的初始化方式
    int m1[3][4] = {0, 1, 2, 3, 4, 5, 6, 7};
    printArray2(m1, 3, 4);

    return 0;
}

//void printArray(int *array, int length) 这种声明方式也是ok的
void printArray(int array[], int length)
{
    for (int i = 0; i < length; i++)
    {
        printf("array idx %d value: %d \n", i, array[i]);
    }
}

// void printArray2(int (*arr)[4], int rows, int cols)  这种声明方式也是OK的 为什么需要括号是因为[]的优先级比*号高
void printArray2(int arr[][4], int rows, int cols)
{
    for (int i = 0; i < rows; i++)
    {
        printf("row : %d \n", i);
        printArray(arr[i], cols);
    }
}
