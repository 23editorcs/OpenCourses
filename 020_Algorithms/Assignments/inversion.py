text = open("IntegerArray.txt", "r")
arrayInteger = [int(i) for i in text.readlines()]
text.close()


counted = []

def main():
    listLength = len(arrayInteger)
    sortedList = countInversion(arrayInteger, listLength)
    print(sum(counted))

def countInversion(listOfInteger, n ):
    sortedList = []
    if n < 2:
        return listOfInteger
    else:
        m = n // 2
        leftList = countInversion(listOfInteger[0:m], m)
        rightList = countInversion(listOfInteger[m:], (n - m))
        mergeAndCount(leftList, rightList, n, sortedList, counted)
    return sortedList
    
def mergeAndCount(left, right, n, sortedList, counted):
    i, j = 0, 0
    for k in range(n):
        if i < len(left) and j < len(right):
            if left[i] < right[j]:
                sortedList.append(left[i])
                i += 1
            else:
                sortedList.append(right[j])
                j += 1
                counted.append((len(left) - i))
        elif i < len(left):
            sortedList.append(left[i])
            i += 1
        else:
            sortedList.append(right[j])
            j += 1
     
    return sortedList
            
            

if __name__ == "__main__": main()