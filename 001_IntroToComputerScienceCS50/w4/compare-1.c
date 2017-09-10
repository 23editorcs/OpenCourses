/*
 * compare-1.c
 *
 * 23editorcs
 * 23editorcs@gmail.com
 *
 * compares two strings
 *
 * demonstrates strings as pointers to characters
 */

#include <stdio.h>
#include <cs50.h>
#include <string.h>

int main(void)
{
    // get line of text
    printf("Say something: ");
    char* s = GetString();

    printf("Say another thing: ");
    char* t = GetString();

    // compares two string
    if(s != NULL && t != NULL)
    {
        if(strcmp(s, t) == 0)
        {
            printf("You typed the same things!\n");
        }
        else 
        {
            printf("You typed diffrent things.\n");
        }
    }
}

