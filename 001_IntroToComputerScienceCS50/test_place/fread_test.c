#include <stdio.h>
#include <string.h>

int main(void)
{
    // create a file 
    FILE *fp;
    
    // create an array of characters
    char c[] = "this is test of fread";
    
    // open a file for reading and writing
    fp = fopen("file.txt", "w+");

    // write data into file
    fwrite(c, strlen(c) + 1, 1, fp);
    
    // seek to beginning of the file
    fseek(fp, SEEK_SET, 0);
    
    int numbers;
    int n = 0;
    do
    {
        char buffer[3];
        numbers = fread(buffer, 1, 3, fp);
        ++n;
    }
    while (numbers == 3);
    
    fprintf(stdout, "%i and %i", numbers, n);
    
    fclose(fp);
    return 0;
    
    
}