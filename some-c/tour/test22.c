#include <stdio.h>

int main()
{

    int sum = 17;
    int cnt = 5;
    double mean;

    mean = (double)sum / 5;
    printf("mean: %f\n", mean);

    // 整数提升
    int i = 17;
    char c = 'c'; /* ascii 值是 99 */
    int sum2;

    sum2 = i + c;
    printf("Value of sum : %d\n", sum2);

    //常用的算术转换
    // 1. c3 先整数转换
    // 2. 算术转换 c3 i3 为float
    int i3 = 17;
    char c3 = 'c'; /* ascii 值是 99 */
    float sum3;

    sum3 = i3 + c3;
    printf("Value of sum : %f\n", sum3);
    // ps :算术转换不适用于赋值运算符、逻辑运算符 && 和 ||


    return 0;
}