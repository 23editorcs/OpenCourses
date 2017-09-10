#include <stdio.h>
#include <cs50.h>

// Prototype
int cube(int n);

int main(void)
{
    int x = 2;
    printf("X is now: %i\n", x);
    printf("Cubing....\n");
    x = cube(x);
    printf("Cubed!\n");
    printf("X is now: %i\n", x);
}

int cube(int n)
{
    return n * n * n;
}

