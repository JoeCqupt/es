#include <stdio.h>
#include <float.h>

int main(){
    printf(
        "size of int:%lu \n", sizeof(int)
    );

    printf("=======float===============\n");
    
    printf("size of float:%lu \n", sizeof(float));
    printf("max of float: %f \n", FLT_MAX);
    printf("dig of float: %d \n", FLT_DIG);
    return 0;
}