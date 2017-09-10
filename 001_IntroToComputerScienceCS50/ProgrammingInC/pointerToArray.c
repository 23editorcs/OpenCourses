#include <stdio.h>
#include <stdlib.h>

/***
int sumByPointer(int array[], const int n) {
  int *ptr = array;
  int * const arrayEnd = array + n;
  int sum = 0;
  
  while (ptr < arrayEnd) {
    sum += *ptr;
    ++ptr;
  }
  
  return sum;
}
***/

int main(void) {
  
  int *result = malloc(sizeof(int));
  *result = 5;
  
  printf("%i", *result);
  
  return 0;
}