#include <stdio.h>

int main(void)
{
    // Print A-Z from 65 to 65 + 26 in ASC
    for(int i = 65; i < 65 + 26; i++)
    {
        printf("%c: %i\n", (char)i, i);
    }

    // Separate uppercase
    for(int i = 97; i < 97 + 26; i++)
    {
        printf("%c: %i\n", (char) i, i);
    }
}

