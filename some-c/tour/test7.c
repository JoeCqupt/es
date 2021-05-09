#include <stdio.h>
// 声明函数
int max(int, int);

int main()
{
    printf("max:%d \n", max(5, 6));

    return 0;
}

int max(int a, int b){
    if(a>b){
        return a;
    }else{
        return b;
    }
}