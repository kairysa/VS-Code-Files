numList = []
def countdown(n):
    for x in range(n,-1,-1):
        numList.append(x)
    return numList
print(countdown(20))

def print_and_return(newList):
    print(newList[0])
    return newList[1]
print(print_and_return([1,2]))

sum = 0
def first_plus_length(lengthList):
    sum = lengthList[0] + len(lengthList)
    return sum
print(first_plus_length([1,2,3,4,5]))

secondList = []
def greater_than_second(greaterList):
    for i in greaterList:
        if len(greaterList) < 2:
            return False
        elif i > greaterList[1]:
            secondList.append(i)
    return secondList
print(greater_than_second([10,2,3,5,-2,1,0,25]))
print(greater_than_second([5]))

thirdList = []
def length_and_value(a,b):
    p = 0
    while p < a:
        thirdList.append(b)
        p += 1
    return thirdList

print(length_and_value(6,2))