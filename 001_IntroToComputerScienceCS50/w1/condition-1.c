#include <stdio.h>
#include <cs50.h>

int main (void)
{
    // Ask user for input
    printf("Give me an integer: ");
    int n = GetInt();
    // Analyze the input
    if (n > 0)
    {
        printf("You've picked a positive integer!\n");
    }
    else if (n == 0)
    {
        printf("You've picked a zero!\n");
    }
    else
    {
        printf("You've picked a negative integer!\n");
    }
}
