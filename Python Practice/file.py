num1 = 42 #variable statement, number, int
num2 = 2.3 #variable statement, number, float
boolean = True #variable statement, boolean
string = 'Hello World' #variable statement, string
pizza_toppings = ['Pepperoni', 'Sausage', 'Jalepenos', 'Cheese', 'Olives'] #data type: list
person = {'name': 'John', 'location': 'Salt Lake', 'age': 37, 'is_balding': False} #data type: dictionary
fruit = ('blueberry', 'strawberry', 'banana') #data type: tuples
print(type(fruit)) #log, will output data type typle
print(pizza_toppings[1]) #log, will output Sausage
pizza_toppings.append('Mushrooms') #adds 'Mushrooms' to the end of the pizza_toppings list
print(person['name']) #log, will output John
person['name'] = 'George' #will change the value of the name key to George
person['eye_color'] = 'blue' #will add a key:value pair to the person dict as 'eye_color' : 'blue',
print(fruit[2]) #will output 'banana'

if num1 > 45: #if/else statement, will output It's lower since num1 is lower than 45
    print("It's greater")
else:
    print("It's lower")

if len(string) < 5: #length function, will count the number of letters and spaces in the string. will output "Just right!" since it is between 5 and 15
    print("It's a short word!")
elif len(string) > 15:
    print("It's a long word!")
else:
    print("Just right!")

for x in range(5):
    print(x)
for x in range(2,5):
    print(x)
for x in range(2,10,3):
    print(x)
x = 0
while(x < 5):
    print(x)
    x += 1
#for while loop. will print 0,1,2,3,4
pizza_toppings.pop() #will remove "Mushrooms" from pizza toppings
pizza_toppings.pop(1) #will remove "Sausage" from pizza toppings

print(person) #will print all the key value pairs in person
person.pop('eye_color') #will remove 'eye_color' from the person dict
print(person) #will print all the key value pairs in person, without the eye_color pair

for topping in pizza_toppings: #loop. will run through all the toppings in pizza_toppings list
    if topping == 'Pepperoni':
        continue
    print('After 1st if statement') #will output 'After 1st if statement' if topping = pepperoni
    if topping == 'Olives':
        break

def print_hello_ten_times():
    for num in range(10):
        print('Hello')

print_hello_ten_times() #won't output anything, no conditional set

def print_hello_x_times(x): 
    for num in range(x):
        print('Hello')

print_hello_x_times(4) #will output Hello 4 times

def print_hello_x_or_ten_times(x = 10):
    for num in range(x):
        print('Hello')

print_hello_x_or_ten_times()
print_hello_x_or_ten_times(4)


"""
Bonus section
"""

# print(num3)
# num3 = 72
# fruit[0] = 'cranberry'
# print(person['favorite_team'])
# print(pizza_toppings[7])
#   print(boolean)
# fruit.append('raspberry')
# fruit.pop(1)