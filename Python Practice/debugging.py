def multiply(num_list, num):
    for x in num_list:
        num_list[x] *= num
    return x
a = [2,4,10,16]
b = multiply(a,5)
print(b)