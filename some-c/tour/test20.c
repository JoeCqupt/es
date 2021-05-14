#include <stdio.h>
// 可以看到字符串会自动连接
#define message "a" \
                "b" \
                "c" \
                "d"

#define message_for(a, b) \
    printf(#a " and " #b ": We love you! \n")

#define token_paster(n) \
    printf("token" #n " : %d \n", token##n);

// 可以判断是否有这个宏定义
#if defined(message)
#define message "update"
#endif

#define square(x) ((x) * (x))
#define MAX(a, b) ((a) > (b) ? (a) : (b))

int main()
{

        // c 默认宏
    printf("File :%s\n", __FILE__);
    printf("Date :%s\n", __DATE__);
    printf("Time :%s\n", __TIME__);
    printf("Line :%d\n", __LINE__);
    printf("ANSI :%d\n", __STDC__);

    printf("message:%s \n", message);
    message_for("joe", "yssss");

    int token34 = 40;
    token_paster(34);

    printf("message:%s \n", message);

    printf("square x : %d \n", square(4));

    printf("MAX of %d & %d is %d \n", 5, 7, MAX(5, 7));

    return 0;
}