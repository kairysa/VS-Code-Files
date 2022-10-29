#1
def number_of_food_groups():
    return 5
print(number_of_food_groups())
#ouput 5

#2
def number_of_military_branches():
    return 5
print(number_of_days_in_a_week_silicon_or_triangle_sides() + number_of_military_branches())
#output Error, first function not defined

#3
def number_of_books_on_hold():
    return 5
    return 10
print(number_of_books_on_hold())
#output 5, function ends after first return

#4
def number_of_fingers():
    return 5
    print(10)
print(number_of_fingers())
#output 5, function ends after first return

#5
def number_of_great_lakes():
    print(5)
x = number_of_great_lakes()
print(x)
    #output 5

#6
def add(b,c):
    print(b+c)
print(add(1,2) + add(2,3))
    #output 8


#7
def concatenate(b,c):
    return str(b)+str(c)
print(concatenate(2,5))
    #output 25

#8
def number_of_oceans_or_fingers_or_continents():
    b = 100
    print(b)
    if b < 10:
        return 5
    else:
        return 10
    return 7
print(number_of_oceans_or_fingers_or_continents())
    #will print 100 first, then print 10


#9
def number_of_days_in_a_week_silicon_or_triangle_sides(b,c):
    if b<c:
        return 7
    else:
        return 14
    return 3
print(number_of_days_in_a_week_silicon_or_triangle_sides(2,3)) #output 7
print(number_of_days_in_a_week_silicon_or_triangle_sides(5,3)) #output 14
print(number_of_days_in_a_week_silicon_or_triangle_sides(2,3) + number_of_days_in_a_week_silicon_or_triangle_sides(5,3)) #output 21


#10
def addition(b,c):
    return b+c
    return 10
print(addition(3,5))
    #output 8


#11
b = 500
print(b)
def foobar():
    b = 300
    print(b)
print(b)
foobar()
print(b)
#outputs 500, then 300, then 500, then 300, and lastly 500 all on different lines

#12
b = 500
print(b)
def foobar():
    b = 300
    print(b)
    return b
print(b)
foobar()
print(b)
#outputs 500 3 times, then 300 once, then 500 again

#13
b = 500
print(b)
def foobar():
    b = 300
    print(b)
    return b
print(b)
b=foobar()
print(b)
#outputs 500 twice, then 300 twice


#14
def foo():
    print(1)
    bar()
    print(2)
def bar():
    print(3)
foo()
#outputs 1,3,2 on different lines


#15
def foo():
    print(1)
    x = bar()
    print(x)
    return 10
def bar():
    print(3)
    return 5
y = foo()
print(y)
#outputs 1, 3, 5, 10 on different lines