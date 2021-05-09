#include <stdio.h>
#include <string.h>

int main()
{
    char greeting[6] = {'h', 'e', 'l', 'l', 'o', '\0'};
    printf("greet msg: %s \n", greeting);

    char *str = "hello world!";
    printf("str: %s \n", str);

    char str2[20] = "joe:";

    strcat(str2, str);
    printf("strcat: %s \n", str2);

    return 0;
}