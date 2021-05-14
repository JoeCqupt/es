#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{

    char *p;
    p = malloc(200 * sizeof(char));
    if (p == NULL)
    {
        perror("error:");
        return EXIT_FAILURE;
    }
    strcpy(p, "Zara ali a DPS student in class 10th");
    printf("str:%s \n", p);

    // 缩小内存
    p = realloc(p, 50 * sizeof(char));
    if (p == NULL)
    {
        perror("error:");
        return EXIT_FAILURE;
    }

    strcpy(p, "resize memory!");
    printf("str:%s \n", p);

    free(p);

    // 扩展学习一下 无类型指针； 可以看到malloc方法返回的是void *类型
    // 资料：https://www.runoob.com/w3cnote/c-void-intro.html

    void *v = p; // 可以直接转换
    printf("v:%s \n", v);

    int *i = malloc(1 * sizeof(int));
    printf("size of i: %lu \n", sizeof(i));

    *i = 0;
    // 越界
    i[1] = 123;
    *(i + 2) = 234;
    *(i + 3) = 1000;

    int *j = malloc(1 * sizeof(int));
    j[0] = 41324;

    printf("%d %d %d %d\n", *i, i[1], *(i + 2), *(i + 3));
    printf("%p %p %p %p\n", i, &i[1], (i + 2), (i + 3));

    printf("%p \n", j);

    int arr[1];
    // 越界
    *(arr + 10) = 100;
    return EXIT_SUCCESS;
}