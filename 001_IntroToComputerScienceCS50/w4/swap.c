/*
 * swap.c
 *
 * 23editorcs
 * 23editorcs@gmail.com
 *
 * swaps two variables' value
 *
 * demonstrates passing by reference
 */
 
#include <stdio.h>

// function prototype
void swap(int* a, int* b);

int main(void)
{
    int x = 1;
    int y = 2;
    
    printf("x is %i, y is %i\n", x, y);
    printf("Swapping...\n");
    swap(&x, &y);
    printf("Swapped!\n");
    printf("x is %i, y is %i\n", x, y);
}

void swap(int* a, int* b)
{
    int tmp = *a;
    *a = *b;
    *b = tmp;
}