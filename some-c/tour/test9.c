#include <stdio.h>

// 全局变量
int a = 10;
int b;

int main(){

    int a =20;
    // value is 20 表示局部变量会覆盖全局变量 
    printf("a value:%d \n", a);

    // value is  0  表示全局变量是有默认值
    printf("b value:%d \n", b);

    return 0;
}