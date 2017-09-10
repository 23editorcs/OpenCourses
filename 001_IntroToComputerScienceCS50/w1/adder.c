#include <stdio.h>
#include <cs50.h>

int main (void)
{
    // Ask user for input
    printf("Give me an integer: ");
    int x = GetInt();
    printf("Give me an integer: ");
    int y = GetInt();

    // Do the math
    printf("The sum of %i and %i is %i!\n", x, y, x + y);
}
