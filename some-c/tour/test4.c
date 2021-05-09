#include <stdio.h>

//声明常量1
#define NAME "joe"

int main(){

    printf("name: %s \n", NAME);

    //声明常量2
    const int age = 26;
    printf("age: %d \n", age);

    return 0;
}