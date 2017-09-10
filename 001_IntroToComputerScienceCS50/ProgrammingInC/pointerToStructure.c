#include <stdio.h>

int main(void) {
	struct date {
		int month;
		int day;
		int year;
	};
	struct date today, *datePtr;
	
	datePtr = &today;
	
	datePtr->month = 3;
	datePtr->day = 23;
	datePtr->year = 1990;
	
	printf("My birthday is %i %i, %i. \n", datePtr->day, datePtr->month, datePtr->year);
	
	return 0;
}

