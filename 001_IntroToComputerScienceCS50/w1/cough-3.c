#include <stdio.h>
#include <cs50.h>

// Prototype
void cough(int n);

int main(void)
{
    printf("How many times to cough: ");
    int n = GetInt();

    cough(n);
}

void cough(int n)
{
    for(int i = 0; i < n; i++)
    {
        printf("Cough\n");
    }
}

