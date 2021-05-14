#include <stdio.h>

int main()
{

    FILE *fp;

    char fileName[50] = "/Users/jiangyuan/Desktop/test.txt";
    // 打开文件
    fp = fopen(fileName, "w+");

    // 向文件写入字符
    fputs("this is a test file.\n", fp);
    fprintf(fp, "this is a test line.\n");

    // 关闭文件
    fclose(fp);

    FILE *fp2;
    char buf[266];
    int buf_size = sizeof buf;
    fp2 = fopen(fileName, "r");
    fgets(buf, buf_size, fp2); // 读取文件遇到EOF/换行符就会终止
    printf("line1: %s", buf);

    fscanf(fp2, "%s", buf); // 将读取连续字符，直到遇到一个空格字符（空格字符可以是空白、换行和制表符）。
    printf("some of line2: %s \n", buf);

    fclose(fp2);

    printf("=====================\n");
    FILE *fp3;
    fp3 = fopen(fileName, "r");
    while (1)
    {
        if (feof(fp3))
        {
            break;
        }
        char *line = fgets(buf, buf_size, fp3); // 读取文件遇到EOF/换行符就会终止,同时返回NULL空指针； 读取成功会返回不为空的指针（指向buf）
        if (line == NULL)
        {
            break;
        }
        printf("l: %s", line);
    }
    fclose(fp3);

    return 0;
}