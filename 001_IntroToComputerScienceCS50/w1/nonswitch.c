#include <stdio.h>
#include <cs50.h>

int main (void)
{
    // Ask user for input
    printf("Give me an integer: ");
    int x = GetInt();

    // Assess and judge it
    if (x >= 1 && x <= 3)
    {
        printf("Your number is Superman!\n");
    }
    else if (x > 3 && x <= 10)
    {
        printf("Your number is Deadpool!\n");
    }
    else if (x > 10)
    {
        printf("Your number is Sheldon.\n");
    }
    else 
    {
        printf("Your number is Penny.\n");
    }
}

