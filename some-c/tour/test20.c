#include <stdio.h>

#ifndef MESSAGE
#define MESSAGE "message"
#endif

int main()
{
    printf("MESSAGE:%s \n", MESSAGE);


    // c 默认宏
    printf("File :%s\n", __FILE__);
    printf("Date :%s\n", __DATE__);
    printf("Time :%s\n", __TIME__);
    printf("Line :%d\n", __LINE__);
    printf("ANSI :%d\n", __STDC__);

    return 0;
}