nums = [1 ,2 ,3 ,4 ,5 ,6 ,7 ,8 ,9 ,10]
for x in nums:
    if x <= 5:
        print("smaller than or equal to 5")
    elif x < 10:
        print("less than 10")
    elif x == 10:
        print("equals 10")
    else:
        break
for i in range(2,20,2):
    print(i)