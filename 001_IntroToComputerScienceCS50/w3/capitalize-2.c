/**
 * capitalize-2.c
 *
 * 23editorcs
 * 23editorcs@gmail.com
 *
 * capitalize a given text
 *
 * demonstrates futher simplification of code with toupper 
 */

#include <stdio.h>
#include <cs50.h>
#include <string.h>
#include <ctype.h>

int main(void)
{
    // get line of text
   string s = GetString(); 
    // capitalize text
    for(int i = 0, n = strlen(s); i < n; i++)
    {
        printf("%c", toupper(s[i]));
    }
    printf("\n");
}

