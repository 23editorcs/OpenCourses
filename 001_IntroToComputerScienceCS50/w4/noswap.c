#include <stdio.h>

void swap(int a, int b);

int main(void)
{
    int x = 1;
    int y = 2;

    printf("Swapping...\n");
    printf("Swapped!\n");
    swap(x, y);
    printf("Your x is: %i\n", x);
    printf("Your y is: %i\n", y);
}

void swap(int a, int b)
{
    int tmp = a;
    a = b;
    b = tmp;
}

