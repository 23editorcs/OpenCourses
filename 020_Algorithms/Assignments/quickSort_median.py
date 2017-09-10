f = open("QuickSort.txt", "r")
array = [int(i) for i in f.readlines()]
f.close()

def main():
    sortedArray, counts = quicksort(array)
    print(counts)

def quicksort(array):
    if len(array) < 2:
        counts = 0
        return array, counts
    else:
        n = len(array)
        counts = n - 1

        # find the median between 1st, median, and last elements
        x = 0
        y = (n - 1) // 2
        z = (n - 1)
        median = x
        if array[x] > array[y]:
            if array[x] < array[z]:
                median = x
            elif array[y] > array[z]:
                median = y
            else:
                median = z
        elif array[y] < array[z]:
            median = y
        else:
            if array[x] > array[z]:
                median = x
            else:
                median = z

        # swap median to the first element
        if median != x:
            temp = array[0]
            array[0] = array[median]
            array[median] = temp

        # do the quicksort
        i, j = 0, 1
        p = array[i]

        for k in range(n-1):
            if array[k+1] < p:
                temp = array[j]
                array[j] = array[k+1]
                array[k+1] = temp
                j += 1
        
        # swap the p and (j - 1) element
        temp = array[i]
        array[i] = array[j-1]
        array[j-1] = temp

        la, lc = quicksort(array[:j-1])
        ra, rc = quicksort(array[j:])

        counts += lc + rc

    return array, counts



if __name__ == "__main__": main()
