/*
 * compare-0.c
 *
 * 23editorcs
 * 23editorcs@gmail.com
 *
 * tries (and fails) to compare two strings
 *
 * demonstrates strings as pointers to arrays.
 */

#include <stdio.h>
#include <cs50.h>

int main(void)
{
    // get line of text
    printf("Say something: ");
    string s = GetString();

    // get another line of text
    printf("Say something else: ");
    string t = GetString();

    // tries (and fails) to compare two strings
    if (s == t)
    {
        printf("Two string are the same.\n");
    }
    else
    {
        printf("Two string are diffrent.\n");
    }
}

