#include <stdio.h>
#include <string.h>

struct Book
{
    char name[50];
    char author[50];
    int book_id;
};

int main()
{

    struct Book book1;

    // 不能使用这种方式进行赋值，大意理解就是book1.name是个指针常量不能修改其指向地址
    // 可以理解声明一个数组就是声明了一个const的指针常量，不能修改其地址
    // book1.name = "book1 name";

    char name[50] = "book1 name";
    strcpy(book1.name, name); // 可以通过这种方式操作
    strcpy(book1.author, "book1 author");
    book1.book_id = 1;

    printf("name:%p \n", name);
    printf("book1 name:%p \n", book1.name);

    // 结构体指针
    struct Book book2;
    struct Book *book2p = &book2;
    book2p->book_id = 2;
    strcpy(book2p->name, "book2 name"); //注意查看如何取成员变量
    printf("book2 name:%s \n", book2p->name);
    printf("book2 id:%d \n", book2p->book_id);
    printf("book2 address: %p \n", &book2);

    return 0;
}