#include <stdio.h>

struct entry {
  int value;
  struct entry *next;
};

struct entry *findEntry(struct entry *listPtr, int match) {
  while(listPtr != (struct entry *) 0) {
    if (listPtr->value == match) {
      return listPtr;
    }
    else listPtr = listPtr->next;
  };
  return (struct entry *) 0;
}

int main(void) {
  struct entry n1, n2, n3;
  struct entry *listPtr, *listStr = &n1;
  
  n1.value = 100;
  n2.value = 200;
  n3.value = 300;
  
  n1.next = &n2;
  n2.next = &n3;
  n3.next = (struct entry *) 0;
  
  int search;
  
  printf("Enter a value to search: ");
  scanf("%i", &search);
  
  printf("\nSearching...");
  
  listPtr = findEntry(listStr, search);
  
  if (listPtr != (struct entry *) 0)
    printf("Found it.\n");
  else
    printf("Not in here, babe.\n");
  
  return 0;
  
}

