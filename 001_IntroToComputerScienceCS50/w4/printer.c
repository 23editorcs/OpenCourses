/* 
 * printer.c
 * 
 * 23editorcs
 * 23editorcs@gmail.com
 *
 * prints a file to terminal
 *
 * demonstrates use of file IO
 */
 
#include <stdio.h>
#include <cs50.h>
#include <string.h>

int main(int argc, char* argv[])
{
    // check if the arguments is right
    if(argc != 2)
    {
        printf("usage: %s filename\n", argv[0]);
        return 2;
    }
    
    // open the file
    FILE* fp = fopen(argv[1], "r");
    
    // check the file opens successful
    if(fp == NULL)
    {
        return 1;
    }
    
    // save the output variable
    char output[256];
    
    // loop through the file and print line by line
    for(int i = 1; fgets(output, sizeof(output), fp) != NULL; i++)
    {
        printf("Line %02d: %s", i, output);
    }
    
    // close the file
    fclose(fp);
    return 0;
}