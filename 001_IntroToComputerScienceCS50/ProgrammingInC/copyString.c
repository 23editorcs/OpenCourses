#include <stdio.h>
#include <stdlib.h>

void copyStr(char *to, char *from) {
  for ( ; *from != '\0'; ++to, ++from) {
    *to = *from;
  };
  
  *to = '\0';
}

int main(void) {
  char *str1, str2[45];
  
  str1 = "How happy I am!";
  
  copyStr(str2, str1);
  
  printf("%s", str2);
  
  return 0;
}