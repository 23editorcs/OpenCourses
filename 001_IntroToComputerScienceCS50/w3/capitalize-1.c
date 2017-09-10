/**
 * capitalize-1.c
 *
 * 23editorcs
 * 23editorcs@gmail.com
 *
 * capitalize a given string with islower, toupper
 */

#include <stdio.h>
#include <cs50.h>
#include <string.h>
#include <ctype.h>

int main(void)
{
    // get a line of text
    string s = GetString();
    // loop through all letter and capitalize them
    for(int i = 0, n = strlen(s); i < n; i++)
    {
        if(islower(s[i]))
        {
            printf("%c", toupper(s[i]));
        }
        else
        {
            printf("%c", s[i]);
        }
    }
    printf("\n");
}

