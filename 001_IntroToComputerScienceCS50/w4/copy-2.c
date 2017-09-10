/*
 * copy-2.c
 * 
 * 23editorcs
 * 23editorcs@gmail.com
 *
 * copies a string
 *
 * demonstrates pointer arithmetic
 */
 
#include <stdio.h>
#include <cs50.h>
#include <string.h>
#include <ctype.h>

int main(void)
{
    // get a line of text
    printf("Say something: ");
    char* s = GetString();
    
    // check s is not NULL
    if(s == NULL)
    {
        return 1;
    }
    
    // allocates enough memory for copy
    char* t = malloc((strlen(s) + 1) * sizeof(char));
    
    // copies through a loop
    for(int i = 0, n = strlen(s); i <= n; i++)
    {
        *(t + i) = *(s + i);
    }
    
    // check t is not null and capitalizes the first
    if(t != NULL)
    {
        *t = toupper(*t);
    }
    
    // print the result
    printf("The origin: %s\n", s);
    printf("The copy: %s\n", t);
    
    // free memory
    free(s);
    free(t);
    
    // success
    return 0;
}