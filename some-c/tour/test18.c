#include <stdio.h>
// 定义新的数据类型名称
typedef char byte;

typedef struct ItemStruct
{
    int id;
    char name[20];
    char desc[50];
} Item;

int main()
{

    byte b = 0;
    printf("byte size:%lu \n", sizeof(byte));
    printf("b: %d \n", b);

    printf("================================\n");
    Item item1;
    printf("size of item:%lu \n", sizeof(Item));

    return 0;
}

// typedef  #define的区别 
// 1. typedef 仅限于为类型定义符号名称，#define 不仅可以为类型定义别名，也能为数值定义别名，比如您可以定义 1 为 ONE。
// typedef 是由编译器执行解释的，#define 语句是由预编译器进行处理的。