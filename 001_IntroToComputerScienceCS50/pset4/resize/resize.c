/*
 * resize.c
 *
 * 23editorcs
 * 23editorcs@gmail.com
 *
 * resize a bmp image
 */
 
#include <stdio.h>
#include <stdlib.h>

#include "bmp.h"

int main(int argc, char *argv[])
{
    // check the number of argument
    if (argc != 4)
    {
        fprintf(stderr, "Usage: ./resize infile outfile \n");
        return 1;
    }
    
    // store the scale
    int n = atoi(argv[1]);
    
    // save the infile and outfile name
    char *infile = argv[2];
    char *outfile = argv[3];
    
    // open the infile 
    FILE *inptr = fopen(infile, "r");
    
    // check the open of inptr is success
    if (inptr == NULL)
    {
        fprintf(stderr, "Could not open the %s file.\n", infile);
        return 1;
    }
    
    // save bf & bi information
    BITMAPFILEHEADER bf;
    BITMAPINFOHEADER bi;
    
    // open the outfile
    FILE *outptr = fopen(outfile, "w");
    
    // check the open of outptr is success
    if (outptr == NULL)
    {
        fprintf(stderr, "Could not open the %s file.\n", outfile);
        
        // close the inptr
        fclose(inptr);
        return 1;
    }
    
    // read the infile's BITMAPFILEHEADER & BITMAPINFOHEADER
    fread(&bf, sizeof(BITMAPFILEHEADER), 1, inptr);
    fread(&bi, sizeof(BITMAPINFOHEADER), 1, inptr);
    
    // store width and height of infile 
    int widthIn = bi.biWidth;
    int heightIn = abs(bi.biHeight);
    
    // calculate infile's padding
    int paddingIn = (4 - widthIn * sizeof(RGBTRIPLE) % 4) % 4;
    
    // calculate outfile's padding
    int paddingOut = (4 - widthIn * n * sizeof(RGBTRIPLE) % 4) % 4;
    
    // update new width and height of outfile
    bi.biWidth = bi.biWidth * n;
    bi.biHeight = bi.biHeight * n;
    bi.biSizeImage = bi.biWidth * abs(bi.biHeight) * 3 + paddingOut * abs(bi.biHeight);
    bf.bfSize = 54 + bi.biSizeImage;

    
    // write bf to the outfile's BITMAPFILE HEADER & BITMAPINFOHEADER
    fwrite(&bf, sizeof(BITMAPFILEHEADER), 1, outptr);
    fwrite(&bi, sizeof(BITMAPINFOHEADER), 1, outptr);
    
    // check the infile is 24-bit uncompressed bmp file
    if (bf.bfType != 0x4d42 || bf.bfOffBits != 54 || bi.biSize != 40)
    {
        fprintf(stderr, "The infile is not 24-bit uncomressed bmp file.\n");
        fclose(inptr);
        fclose(outptr);
        return 1;
    }
    
    // iterate through the scanlines
    for (int i = 0; i < heightIn; i++)
    {
        // create an array to store all pixels value in a scanlines
        // int numbers = bi.biWidth * n;
        RGBTRIPLE scanline[bi.biWidth];
        
        // counting for array elements
        int p = 0;
        
        // temporary RGB variable
        RGBTRIPLE triple;
            
        // iterate through every pixel of a scanlines
        for (int j = 0; j < widthIn; j++)
        {

            
            // read the pixel value to triple variable
            fread(&triple, sizeof(RGBTRIPLE), 1, inptr);
            
            // scale the pixel to n times
            for (int k = 0; k < n; k++)
            {
                // store the pixel value to array scanline
                scanline[p] = triple;
                ++p;
            }
        }
        
        // skip padding infile
        fseek(inptr, paddingIn, SEEK_CUR);
        
        // write to outfile n times in vertical
        for (int v = 0; v < n; v++)
        {
            for (int x = 0; x < p; x++)
            {
                triple = scanline[x];
                fwrite(&scanline[x], sizeof(RGBTRIPLE), 1, outptr);
            }
            
            // add padding outfile
            for (int m = 0; m < paddingOut; m++)
            {
                fputc(0x00, outptr);
            }
        }
        
        // free(scanline);
        // I am superman.
        }
    
    fclose(inptr);
    fclose(outptr);
    return 0;
}
 