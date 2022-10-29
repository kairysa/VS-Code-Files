for a in range(151):
    print(a)

for b in range(5,1001):
    if b % 5 == 0:
        print(b)

for c in range(1,101):
    if c % 10 == 0:
        print("Coding Dojo")
    elif c % 5 == 0:
        print("Coding")
    else:
        print(c)

sum = 0
for d in range(0,500000):
    if d % 2 != 0:
        sum += d
print(sum)

for e in range(2018,0,-4):
    print(e)

lowNum = 0
highNum = 30
mult = 2

for f in range(lowNum,highNum):
    if f % mult == 0:
        print(f)