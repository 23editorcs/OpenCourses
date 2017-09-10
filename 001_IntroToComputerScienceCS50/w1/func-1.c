#include <stdio.h>
#include <cs50.h>

// Prototype
int GetPositiveInt(void);

int main(void)
{
    int n = GetPositiveInt();
    printf("Your first positive number is: %i\n", n);
}

int GetPositiveInt(void)
{
    int n;
    do 
    {
        printf("Give me a positive integer: ");
        n = GetInt();
    }
    while (n < 1);
    return n;
}

