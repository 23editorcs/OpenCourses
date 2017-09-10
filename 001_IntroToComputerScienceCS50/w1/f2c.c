#include <stdio.h>
#include <cs50.h>

int main(void)
{
    printf("The temperature in Fahrenheit is: ");
    float f = GetFloat();

    // Convert it to Cencius
    float c = 5.0 / 9.0 * (f - 32.0);

    printf("The temperature in C is: %.1f\n", c);
}
