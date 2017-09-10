/* 
 * recover.c
 * 
 * 23editorcs
 * 23editorcs@gmail.com
 *
 * recover the jpeg from a draw set of bits
 */
 
#include <stdio.h>
#include <stdlib.h>
#include <stdint.h> // for use unint8_t

int main(int argc, char *argv[])
{
    // create a data type  8 bits unsiged integer
    typedef uint8_t BYTE; 
    
    // check the number of arguments
    if (argc != 2)
    {
        fprintf(stderr, "Usage: ./recover filename\n");
        return 1;
    }
    
    // store the infile name
    char *infile = argv[1];
    
    // open the infile
    FILE *inptr = fopen(infile, "r");
    
    // always check the open file is not NULL
    if (inptr == NULL)
    {
        fprintf(stderr, "Cannot open the input file.\n");
        return 2;
    }
    
    // store the pointer for output file 
    FILE *outptr;
    
    // store the counting of per block to check eof
    int notEof = 0;
        
    // counting for file name 
    int numberFile = 0;
    
    // create a buffer with an array of 512 bytes
    BYTE buffer[512];
    
    // store the status of in-jpeg-file
    int inJpg = 0;
    
    // repeat until the end of file
    do
    {
        // fread returns a number of elements with 1 byte each; bytesOfBlock 
        notEof = fread(&buffer, 512, 1, inptr);
        
        // check 3 first bytes, and fourth byte with binary mask
        if (buffer[0] == 0xff && buffer[1] == 0xd8 && buffer[2] == 0xff && (buffer[3] & 0xf0) == 0xe0)
        {
            // create an array to save the file name
            char outfile[8];
            
            // return the file name with the right name; snprintf for using placeholder in string
            snprintf(outfile, 8, "%0.3d.jpg", numberFile);
            
            // increase the numberFile
            ++numberFile;
            
            // open the file to write
            outptr = fopen(outfile, "w");
            if (outptr == NULL)
            {
                fprintf(stderr, "Cannot open the output file.\n");
                return 3;
            }
            
            // copy all buffer to the new file
            fwrite(&buffer, 512, 1, outptr);
            
            // set inAJpeg to True
            inJpg = 1;
        }
        
        // if not, and already have 1 file open 
        // copy all buffer to jpeg file
        else if (inJpg == 1 && notEof == 1)
        {
            // copy all buffer to the existent file 
            fwrite(&buffer, 512, 1, outptr);
        }
    }
    while (notEof == 1);
    // close any remaining files
    fclose(inptr);
    fclose(outptr);
}