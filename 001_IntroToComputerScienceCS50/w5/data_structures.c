/* 
 * linkList.c
 *
 * new data structure - link list
 */
 
#include <stdio.h>

typedef struct node 
{
    int n;
    struct node *next;
}
node;

int bool search(int n, node *list)
{
    node *ptr = list;
    while (ptr != NULL)
    {
        if (ptr->n == n)
        {
            return true;
        }
        ptr = ptr->next;
    }
    return false;
}

// stack structure
typedef struct 
{
    int numbers[CAPACITY];
    int size;
}
stack;