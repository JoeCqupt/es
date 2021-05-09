#include <stdio.h>
struct Bits
{
    int a : 4;
    int : 4; //表示填充后4个bit不给b用
    int b : 2;
    int c : 4;
};

int main()
{
    struct Bits bits;
    bits.a = 0b0111; // 第一位是符号位

    printf("bits a: %d \n", bits.a);

    bits.c = 0b0110;
    printf("bits c: %d \n", bits.c & 0b0011);

    return 0;
}