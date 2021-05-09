#include <stdio.h>

// 预先声明函数
int add(int a, int b);

int main()
{

    int a = 1;
    int b = 1;

    printf("result: %d \n", add(a, b));

    return 0;
}

int add(int a, int b)
{
    return a + b;
}