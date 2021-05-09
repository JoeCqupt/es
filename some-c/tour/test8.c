#include <stdio.h>

void swap1(int, int);
void swap2(int *, int *);

int main()
{
    int a = 100;
    int b = 200;

    swap1(a, b);
    printf("值传递: a:%d  b:%d  \n", a, b);

    swap2(&a, &b);
    printf("引用传递: a:%d  b:%d  \n", a, b);
    return 0;
}

void swap1(int a, int b)
{
    int temp = a;
    a = b;
    b = temp;
}

void swap2(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}
