integer = open("IntegerArray.txt", "r")
array = [int(i) for i in integer.readlines()]
integer.close()

def main():
    arrayLength = len(array)
    numInversion = 0
    numInversion = countInversion(array, arrayLength, numInversion)
    print(numInversion)

def countInversion(array, n, numInversion):
    sortedList = []
    if n < 2:
        return array
    else:
        m = n // 2
        halfLeft = countInversion(array[:m], m, numInversion)
        halfRight = countInversion(array[m:], (n - m), numInversion)
        sortedList, numInversion = mergeAndCount(halfLeft, halfRight, n, sortedList, numInversion)
    return sortedList, i

def mergeAndCount(l, r, n, sortedList, counting):
    i, j = 0, 0
    for k in range(n):
        if i < len(l) and j < len(r):
            if l[i] < r[j]:
                sortedList.append(l[i])
                i += 1
            else:
                sortedList.append(r[j])
                j += 1
                counting += len(l) - 1
        elif i < len(l):
            sortedList.append(l[i])
            i += 1
        else:
            sortedList.append(r[j])
            j += 1
    return sortedList, counting


if __name__ == "__main__": main()
