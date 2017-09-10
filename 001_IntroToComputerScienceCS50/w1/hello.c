#include <stdio.h>
#include <cs50.h>

int main (void)
{
    // Ask user for the name
    printf("Give miaae your name: ");
    string n = GetString();

    // Print hello with the name
    printf("Helloo, %s\n", n);
}
