/* 
 * whodunit.c
 * 
 * 23editorcs
 * 23editorcs@gmail.com
 *
 * copy and find the staff behind the red
 */
 
#include <stdio.h>
#include <stdlib.h>

#include "bmp.h"

int main(int argc, char *argv[])
{
    // check the argument array must be 3
    if (argc != 3)
    {
        fprintf(stderr, "Usage: ./whodunit infile outfile\n");
        return 1;
    }
    
    // remember the filenames
    char *infile = argv[1];
    char *outfile = argv[2];
    
    // open the infile
    FILE *inptr = fopen(infile, "r");
    
    if (inptr == NULL)
    {
        fprintf(stderr, "The infile can't be read.\n");
        return 2;
    }
    
    // open the outfile
    FILE *outptr = fopen(outfile, "w");
    
    // check the output file is not NULL
    if (outptr == NULL)
    {
        fclose(inptr); // remember to close the file
        fprintf(stderr, "The outfile can't be write.\n");
        return 3;
    }
    
    // read infile's BITMAPFILEHEADER
    BITMAPFILEHEADER bf;
    fread(&bf, sizeof(BITMAPFILEHEADER), 1, inptr);
    
    // read infile's BITMAPINFOHEADER
    BITMAPINFOHEADER bi;
    fread(&bi, sizeof(BITMAPINFOHEADER), 1, inptr);
    
    // check the input file is 24-bits uncompressed bmp file
    if (bf.bfType != 0x4d42 || bf.bfOffBits != 54 || bi.biSize != 40 ||
        bi.biBitCount != 24 || bi.biCompression != 0)
    {   
        fclose(inptr);
        fclose(outptr);
        fprintf(stderr, "The infile image is not 24-bit uncompressed bmp file.\n");
        return 4;
    }
    
    // write the bf and bi to outptr
    fwrite(&bf, sizeof(bf), 1, outptr);
    fwrite(&bi, sizeof(bi), 1, outptr);
    
    // calculate the padding
    int padding = (4 - bi.biWidth * sizeof(RGBTRIPLE) % 4) % 4;
    
    // iterate over infile's scanlines
    for (int i = 0, biHeight = abs(bi.biHeight); i < biHeight; i++)
    {
        // iterate over a scanline's pixes
        for (int j = 0, biWidth = bi.biWidth; j < biWidth; j++)
        {
            // create RGB to store the pixel value 
            RGBTRIPLE triple;
            
            // read a pixel value from infile
            fread(&triple, sizeof(RGBTRIPLE), 1, inptr);
            
            // The magic happens here.
            if (triple.rgbtBlue == 0x00 && triple.rgbtGreen == 0x00 && triple.rgbtRed == 0xff)
            {
                triple.rgbtGreen = 0xff;
                triple.rgbtBlue = 0xff;
            }
            
            if (triple.rgbtRed != 0xff)
            {
                triple.rgbtRed = 0x00;
            }
            
            // write a pixel value to outfile
            fwrite(&triple, sizeof(RGBTRIPLE), 1, outptr);
        }
        
        // skipping the padding
        fseek(inptr, padding, SEEK_CUR);
        
        // adding padding in the outptr
        for (int k = 0; k < padding; k++)
        {
            // fwrite still works well becaue the padding = 0
            // fwrite(0x00, 1, 1, outptr);
            fputc(0x00, outptr);
        }
    }
    // close all file
    fclose(inptr);
    fclose(outptr);
    
    // success
    return 0;
}
