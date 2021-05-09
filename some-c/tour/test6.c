#include <stdio.h>

int main(){

    int a=4;
    int* ptr = &a; //取地址

    printf("a value %d \n", a);
    printf("ptr value %p \n", ptr); // 指针使用%p 
    printf("value of ptr %d \n", *ptr); // 获取地址内的值

    

    return 0;
}