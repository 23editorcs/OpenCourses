#include <stdio.h>
#include <cs50.h>

int main(void)
{
    printf("Hello, \a world.\n");
    char c = get_char();
    switch (c){
        case 'y':
        case'Y':
            printf("It is a yes.\n");
        case 'N':
        case 'n':
            printf("It is a No.\n");
        default:
            printf("I have no idea");
    }
}
