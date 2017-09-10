bool search(int value, int values[], int n)
{   int middle = n/2;
    if (n < 1) {
        return false;
    }
    else if (value == values[middle]) {
        return true;
    }
    else if (value < values[middle]) {
        return search_left(value, values, n);
    }
    else if (value > values[middle]) {
        return search_right(value, values, n);
    }
    else {
        return false;
    }
}

int search_left(int value, int values[], int n) {
    int haft_size = n / 2;
    if (haft_size < 1) {
        return false;
    }
    int left_values[haft_size];
    memcpy(left_values, values, haft_size * sizeof(int));
    int middle = haft_size / 2;
    if (value == left_values[middle]) {
        return true;
    }
    else if (value < left_values[middle]) {
        return search_left(value, left_values, haft_size);
    }
    else if (value > left_values[middle]) {
        return search_right(value, left_values, haft_size);
    }
    else {
        return false;
    }
} 

int search_right(int value, int values[], int n) {
    int half_size = n - n/2;
    if (n/2 < 1) {
        return false;
    }
    int right_values[half_size];
    memcpy(right_values, &values[n/2], half_size * sizeof(int));
    int middle = half_size / 2;
    if (value == right_values[middle]) {
        return true;
    }
    else if (value < right_values[middle]) {
        return search_left(value, right_values, half_size);
    }
    else if (value > right_values[middle]) {
        return search_right(value, right_values, half_size);
    }
    else {
        return false;
    }
}
