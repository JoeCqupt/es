#include <stdio.h>

int main()
{

    int *p = NULL; //空指针

    // 指针计算
    int arr[] = {1, 2, 3};
    int *p2 = arr;
    for (int i = 0; i < 3; i++)
    {
        printf("idx:%d val:%d \n", i, *p2);
        p2++;
    }

    //指针比较
    int *p3 = arr + 3;
    if (p3 == p2)
    {
        printf("p2 == p3 \n");
    }

    //指针数组

    int *pa[3];
    for (int i = 0; i < 3; i++)
    {
        pa[i] = &arr[i];
        printf("pa idx:%d value %p \n", i, pa[i]);
    }

    return 0;
}