#include <stdio.h>
#include <cs50.h>

int main(void)
{
    int n;
    do 
    {
        printf("How many people in the room: ");
        n = GetInt();
    } while (n < 1);

    int age[n];

    for(int i = 0; i < n; i++)
    {
        printf("Age of person #%i: ", i+1);
        age[i] = GetInt();
    }

    printf("Time passes...10 years later.\n");
    for(int i = 0; i < n; i++)
    {
        printf("The person #%i is %i years old now.\n", i+1, age[i] + 10);
    }
}
