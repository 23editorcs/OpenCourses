/*
 * copy-0.c
 *
 * 23editorcs
 * 23editorcs@gmail.com
 *
 * tries and fails to copy two string
 *
 * demonstrates strings as pointers to arrays
 */

#include <stdio.h>
#include <cs50.h>
#include <string.h>
#include <ctype.h>

int main(void)
{
    printf("Say something: ");
    string s = GetString();

    // check s is not null
    if(s == NULL)
    {
        return 1;
    }

    // tries and fails to copy string
    string t = s;

    printf("Capitalizing...\n");
    if(strlen(t) > 0)
    {
        t[0] = toupper(t[0]);
    }

    printf("Done!\n");
    printf("The origin: %s\n", s);
    printf("The copy: %s\n", t);
}

