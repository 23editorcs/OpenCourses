f = open("QuickSort.txt", "r")
array = [int(i) for i in f.readlines()]
f.close()

def main():
    sortedArray = []
    sortedArray, counts = quicksort(array)
    print(counts)

def quicksort(array):
    if len(array) < 2:
        counts = 0
        return array, counts
    else:
        i, j = 0, 1 # j is the most left element of > p subarray
        n = len(array)
        counts = n - 1
        p = array[i]
        for k in range(n-1):
            if array[k+1] < p:
                temp = array[k+1]
                array[k+1] = array[j]
                array[j] = temp
                j += 1
        temp = array[j-1]
        array[j-1] = array[i]
        array[i] = temp
    la, lc = quicksort(array[:j-1])
    ra, rc = quicksort(array[j:])
    counts += lc + rc
    return array, counts

if __name__ == "__main__": main()
