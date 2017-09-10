#include <stdio.h>
#include <cs50.h>

int main(void)
{
    int height;
    while (true) {
        printf("Height: ");
        height = get_int();
        if (height <= 23 && height >= 3) {
            break;
        }
    }
    int numbers = 1;
    for (int i = 0; i < height; i++){
        for (int j = 0; j < height - numbers; j++){
            printf(" ");
        }
        for (int n = 0; n < numbers; n++){
            printf("#");
        }
        printf("  ");
        for (int n = 0; n < numbers; n++){
            printf("#");
        }
        printf("\n");
        numbers += 1;
    }
}