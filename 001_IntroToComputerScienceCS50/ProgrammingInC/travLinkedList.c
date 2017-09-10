#include <stdio.h>

int main(void) {
  struct entry {
    int value;
    struct entry *next;
  };
  
  struct entry n1, n2, n3;
  struct entry *listPointer = &n1; // set a traverse, a pointer to the first node
  
  n1.value = 100;
  n2.value = 200;
  n3.value = 300;
  
  n1.next = &n2;
  n2.next = &n3;
  n3.next = (struct entry *) 0;
  
  while (listPointer->next != (struct entry *) 0 ) {
    printf("%i\n", listPointer->value);
    listPointer = listPointer->next;
  };
  
  return 0;
}