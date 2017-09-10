#include <stdio.h>

int main(void)
{
    int counter[11], i, response;
    
    for (i = 0; i < 11; i++)
    {
        counter[i] = 0;
    }
    
    for (i = 0; i < 20; i++)
    {
        scanf("%i", &response);
        ++counter[response];
    }
}