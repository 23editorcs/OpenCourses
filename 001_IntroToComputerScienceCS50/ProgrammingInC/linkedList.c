#include <stdio.h>

int main(void) {
  struct entry {
    int value;
    struct entry *next;
  };
  
  struct entry n1, n2, n3;
  
  n1.value = 100;
  n2.value = 200;
  n3.value = 300;
  
  n1.next = &n2;
  n2.next = &n3;
  
  int i = (*n1.next).value; // n1.next->value = n2.value
  
  printf("%i", i);
  
  return 0;
}