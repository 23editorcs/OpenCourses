#include <stdio.h>

int main(void)
{
    for(char c = 'A'; c <= 'Z'; c++)
    {
        printf("%c: %i\n", c, (int) c);
    }

    // Seperate uppercase
    printf("\n");

    for(char c = 'a'; c <= 'z'; c++)
    {
        printf("%c: %i\n", c, (int) c);
    }
}


