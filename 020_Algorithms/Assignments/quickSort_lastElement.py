f = open("QuickSort.txt", "r")
array = [int(i) for i in f.readlines()]
f.close()

#array = [5, 3, 1, 7,8, 9]

def main():
    sortedArr, counts = quicksort(array)
    print("The total number of comparisons is : " + str(counts))

def quicksort(array):
    if len(array) < 2:
        counts = 0
        return array, counts
    else:
        n = len(array)
        counts = n - 1
        
        # swap the last element to the first
        temp = array[n-1]
        array[n-1] = array[0]
        array[0] = temp

        # set up i and j to quicksort
        i, j = 0, 1
        p = array[i]
        for k in range(n-1):
            if array[k+1] < p:
                temp = array[k+1]
                array[k+1] = array[j]
                array[j] = temp
                j += 1
   
        # swap p with (j - 1) element
        temp = array[i]
        array[i] = array[j - 1]
        array[j - 1] = temp

        la, lc = quicksort(array[:j-1])
        ra, rc = quicksort(array[j:])
        
        counts += lc + rc

    return array, counts

if __name__ == "__main__": main()
