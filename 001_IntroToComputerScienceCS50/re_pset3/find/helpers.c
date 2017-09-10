/**
 * helpers.c
 *
 * Helper functions for Problem Set 3.
 */
 
#include <cs50.h>
#include <stdio.h>
#include "helpers.h" 
#include <string.h>

int search_left(int value, int values[], int n);
int search_right(int value, int values[], int n);
/**
 * Returns true if value is in array of n values, else false.
 */
bool search(int value, int values[], int n)
{
    int start, end, middle;
    start = 0;
    end = n-1;
    middle = (start + end) / 2;
    while (start != end || value == values[middle]) {
        if (value == values[middle]) {
            return true;
        }
        else if (value < values[middle]) {
            end = middle - 1;
            middle = (start + end) / 2;
        }
        else {
            start = middle + 1;
            middle = (start + end) / 2;
        }
    }
    return false;
}
/**
 * Sorts array of n values.
 */
void sort(int values[], int n)
{
    // TODO: implement an O(n^2) sorting algorit
    for (int i = 0; i < n; i++){
        for (int j = 0; j < n-1; j++){
            printf("%i", values[j]);
            if (values[j] > values[j+1]){
                int swap_value = values[j];
                values[j] = values[j+1];
                values[j+1] = swap_value;
            }
        }
    }

}
