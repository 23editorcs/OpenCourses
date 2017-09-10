#include <stdio.h>

int main(void) {
  struct intPtrs {
    int *point1;
    int *point2;
  };
  
  struct intPtrs pointer;
  
  int p1 = 100, p2;
  
  pointer.point1 = &p1;
  pointer.point2 = &p2;
  *pointer.point2 = -97;
  
  printf("%i and %i \n", p2, *pointer.point2);
  return 0;
}