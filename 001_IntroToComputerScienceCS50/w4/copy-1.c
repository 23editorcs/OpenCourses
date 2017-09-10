/*
 * copy-1.c
 *
 * 23editorcs
 * 23editorcs@gmail.com
 *
 * copies two strings
 *
 * demonstrates the memory allocation
 */

#include <stdio.h>
#include <cs50.h>
#include <string.h>
#include <ctype.h>

int main(void)
{
    printf("Say something: ");
    char* s = GetString();
    
    // check s is not null
    if (s == NULL)
    {
        return 1;
    }
    
    // allocates memory block for t
    char* t = malloc((strlen(s) + 1) * sizeof(char));
    
    // copies s to t through loop include \0
    for(int i = 0, n = strlen(s); i <= n; i++)
    {
        t[i] = s[i];
    }
    
    // changes the copy
    if(t != NULL)
    {
        t[0] = toupper(t[0]);
    }
    
    // prints two strings
    printf("The origin: %s\n", s);
    printf("The copy: %s\n", t);
    
    // free memory
    free(s);
    free(t);
    return 0;
}

