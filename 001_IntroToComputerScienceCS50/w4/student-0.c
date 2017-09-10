/*
 * student-0.c
 *
 * 23editorcs
 * 23editorcs@gmail.com
 *
 * demonstrates use of structs
 */

#include <stdio.h>
#include <cs50.h>
#include <string.h>

#include "structs.h"

// number of students
#define STUDENTS 3

int main(void)
{
    // declare student array
    student students[STUDENTS];

    // populate students with user's input
    for(int i = 0; i < STUDENTS; i++)
    {
        printf("Student's name: ");
        students[i].name = GetString();

        printf("Student's dorm: ");
        students[i].dorm = GetString();
    }

    // print the students
    for(int i = 0; i < STUDENTS; i++)
    {
        printf("%s is in %s\n", students[i].name, students[i].dorm);
    }

    // free memory
    for(int i = 0; i < STUDENTS; i++)
    {
        free(students[i].name);
        free(students[i].dorm);
    }
}

