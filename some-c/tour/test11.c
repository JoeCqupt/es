#include <stdio.h>

int main()
{

    int arr1[] = {1, 2, 3};
    int *p1 = arr1;

    printf("p1 : %p \n", p1);
    printf("arr1 address : %p \n", arr1);

    int arr2[2][3] = {
        1,
        2,
        3,
        4,
        5,
        6,
    };
    int **p2 = (int **)arr2;

    // int *p3 = arr2[0];
    int *p3 = &arr2[0][0];

    printf("p2 : %p \n", p2);
    printf("p3 : %p \n", p3);
    printf("arr2 address : %p \n", arr2);

    // 可以看出数组 arr[] 中 arr 就是一个指向 arr[0]地址的 指针

    return 0;
}