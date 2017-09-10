#include <stdio.h>
#include <cs50.h>

int main(void) 
{
    int n;
    do 
    {
        printf("Give me an integer: ");
        n = GetInt();
    } 
    while (n < 0 );

    for (int i = sizeof(int) * 8 - 1; i >= 0; i--)
    {
        int mask = 1 << i;
        if (n & mask)
        {
            printf("1");
        } 
        else
        {
            printf("0");
        }
    }
    printf("\n");
}


