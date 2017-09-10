/*
 * typewriter.c
 * 
 * 23editorcs
 * 23editorcs@gmail.com
 *
 * writes strings and lines to a file
 *
 * demonstrates use of file IO
 */
 
#include <stdio.h>
#include <cs50.h>
#include <string.h>

int main(int argc, char* argv[])
{
    // check the arguments input
    if(argc != 2)
    {
        printf("usage: %s filename\n", argv[0]);
        return 1;
    }
   
    // open the file
    FILE* fp = fopen(argv[1], "w");
   
    // check if the file is not NULL
    if(fp == NULL)
    {
        return 2;
    }
    
    // while loop to write to file
    while(true)
    {
        printf("Type something to write to file or type \"quit\" to quit: ");
        char* input = GetString();
        
        // check if the input is not NULL and quit
        if(input != NULL && strcmp(input, "quit") == 0)
        {
            free(input);
            break;
        }
        else if(input != NULL)
        {
            fputs(input, fp);
            fputs("\n", fp);
            free(input);
        }
    }
    fclose(fp);
}