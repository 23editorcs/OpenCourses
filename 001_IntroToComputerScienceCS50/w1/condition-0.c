#include <stdio.h>
#include <cs50.h>

int main (void)
{
    // Ask user for input
    printf("Give me an integer: ");
    int x = GetInt();
    // Check if the input is positive or negative
    if (x > 0)
    {
        printf("You've picked a positive integer!\n");
    }
    else
    {
        printf("You've pick a negative integer!\n");
    }
}
