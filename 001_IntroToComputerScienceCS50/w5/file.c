#include <stdio.h>

int main(void) {
  // creates variables 
  char inName[64], outName[64];
  FILE *in, *out;
  char c;
  
  // get the inName and outName from user
  printf("Enter the name of file to be copied: ");
  scanf("%63s", inName); 
  printf("Enter the name of output file: ");
  scanf("%63s", outName);
  
  // open inName and outName files
  if ((in = fopen(inName, "r")) == NULL) {
    printf("The %s file cannot open.\n", inName);
    return 1;
  }
  
  if ((out = fopen(outName, "w")) == NULL) {
    printf("The %s file cannot open.\n", outName);
    return 2;
  }
  
  // copy from *in file to *out file
  while ((c = getc(in)) != EOF) {
    putc(c, out);
  }
  
  // close both file
  fclose(in);
  fclose(out);
  
  printf("File has been copied.\n");
  
  return 0;
}