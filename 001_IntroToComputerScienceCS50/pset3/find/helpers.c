/**
 * helpers.c
 *
 * Computer Science 50
 * Problem Set 3
 *
 * Helper functions for Problem Set 3.
 */
       
#include <cs50.h>
#include <stdio.h>

#include "helpers.h"

/**
 * Returns true if value is in array of n values, else false.
 */
bool search(int value, int values[], int n)
{
    // TODO: implement a searching algorithm
    if (n < 1)
    {
        return false;
    }
    else
    {
        bool result; 
        int average = 0;
        int min = 0;
        int max = n - 1;
        while ((max - min) > 1)
        {
            result = false;
            average = (min + max) / 2;
            if (values[average] == value)
            {
                result = true;
                break;
            }
            else if (values[average] > value)
            {
                max = average;
            }
            else
            {
                min = average;
            }
        }
        return result;
   }
}

/**
 * Sorts array of n values.
 */
void sort(int values[], int n)
{
    int valmin = 0;
    for (int i = 0; i < n-1; i++)
    {
        for (int j = i + 1; j < n-1; j++)
        {
            if (values[j] < values[i])
            {
                valmin = values[j];
                values[j] = values[i];
                values[i] = valmin;
            }
        }
    }
    return;
}