/*
 * sigma-1.c
 *
 * 23editorcs
 * 23editorcs@gmail.com
 *
 * adds the numbers 1 through n
 *
 * demonstrates recursion
 */

#include <stdio.h>
#include <cs50.h>

int sigma(int n);

int main(void)
{
    // get a number n
    printf("Give a number: ");
    int n = GetInt();

    // invoke sigma to add
    int total = sigma(n);
    printf("Your total is %i.\n", total);
}

int sigma(int n)
{
    // base case
    if (n <= 0)
    {
        return 0;
    }
    // recursive case
    else 
    {
        return (n + sigma(n - 1));
    }
}
