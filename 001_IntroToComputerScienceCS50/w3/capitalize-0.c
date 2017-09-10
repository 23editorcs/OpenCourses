/**
 * capitalize-0.c
 * 
 * 23editorcs
 * 23editorcs@gmail.com
 *
 * capitalize a given string
 */

#include <stdio.h>
#include <cs50.h>
#include <string.h>

int main(void)
{
    // get a line of text
    string s = GetString();
    
    // loop through all letter and capitalize them
    for(int i = 0, n = strlen(s); i < n; i++)
    {
        if(s[i] >= 'a' && s[i] <= 'z')
        {
            printf("%c", s[i] - ('a' - 'A'));
        }
        else
        {
            printf("%c", s[i]);
        }
    }
    printf("\n");
}
