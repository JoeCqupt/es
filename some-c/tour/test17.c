#include <stdio.h>
#include <string.h>

union Area
{
    int i;
    float f;
    char chars[20];
};

int main()
{
    union Area area;
    printf("size of Area: %lu \n", sizeof(area)); //可以看到共用体的大小是最大的数据类型

    area.i = 12;
    printf("area i:%d \n", area.i);

    area.f = 12.3f;
    printf("area f:%f \n", area.f);

    strcpy(area.chars, "area good");
    printf("area chars:%s \n", area.chars);
    printf("area i:%d \n", area.i); // 可以看到同一时间只使用一个变量，其他变量就被覆盖
    printf("area f:%f \n", area.f);

    return 0;
}