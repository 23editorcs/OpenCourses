/*
 * student-1.c
 *
 * 23editorcs
 * 23editorcs@gmail.com
 *
 * demonstrates use of file I/O
 */

#include <stdio.h>
#include <cs50.h>
#include <string.h>
#include <stdlib.h>

#include "structs.h"

#define STUDENTS 3

int main(void)
{
    // create student array
    student students[STUDENTS];

    // populate the students from user's input
    for(int i = 0; i < STUDENTS; i++)
    {
        printf("Student's name: ");
        students[i].name = GetString();

        printf("Student's dorm: ");
        students[i].dorm = GetString();

    }
    
    // save students to disk
    FILE* file = fopen("students.csv", "w");
    if (file != NULL);
    {
        for(int i = 0; i < STUDENTS; i++)
        {
            fprintf(file, "%s,%s\n", students[i].name, students[i].dorm);
        }
        fclose(file);
    }
    
    // free memory
    for(int i = 0; i < STUDENTS; i++)
    {
        free(students[i].name);
        free(students[i].dorm);
    }
}

