/*
 * pointer.c
 *
 * 23editorcs
 * 23editorcs@gmail.com
 *
 * prints a given string one character per line
 *
 * demonstrates pointer arithmetic
 */
 
#include <stdio.h>
#include <cs50.h>
#include <string.h>
#include <ctype.h>

int main(void)
{
    // get line of text 
    printf("Say something: ");
    char* s = GetString();
    
    // check s is not null
    if(s == NULL)
    {
        return 1;
    }
    
    // print one character per line by pointer arithmetic
    for(int i = 0, n = strlen(s); i <= n; i++)
    {
        printf("%c\n", *(s + i));
    }
}
