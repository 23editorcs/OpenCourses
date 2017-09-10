#include <stdio.h>
#include <cs50.h>

int main(void)
{
    printf("Give me an integer between 1 to 10: ");
    int x = GetInt();

    // jugde the user's input
    switch (x)
    {
        case 1:
        case 2:
        case 3:
            printf("You've picked small number.\n");
            break;
        case 4:
        case 5:
        case 6:
            printf("You've picked medium number.\n");
            break;
        case 7:
        case 8:
        case 9:
            printf("You've picked large number.\n");
            break;
        default:
            printf("You've picked invalid number.\n");
            break;
    }
}
