#UPDATE VALUES
from unicodedata import name


x = [ [5,2,3], [10,8,9] ] 
students = [
    {'first_name':  'Michael', 'last_name' : 'Jordan'},
    {'first_name' : 'John', 'last_name' : 'Rosales'}
]
sports_directory = {
    'basketball' : ['Kobe', 'Jordan', 'James', 'Curry'],
    'soccer' : ['Messi', 'Ronaldo', 'Rooney']
}
z = [ {'x': 10, 'y': 20} ]

x[1][0] = 15
print(x)

students[0]['last_name'] = 'Bryant'
print(students)

sports_directory['soccer'][0] = 'Andres'
print(sports_directory)

z[0]['y'] = 30
print(z)

#ITERATE THROUGH A LIST OF DICTIONARIES

studentsList = [
        {'first_name':  'Michael', 'last_name' : 'Jordan'},
        {'first_name' : 'John', 'last_name' : 'Rosales'},
        {'first_name' : 'Mark', 'last_name' : 'Guillen'},
        {'first_name' : 'KB', 'last_name' : 'Tonel'}
    ]

def iterateDictionary(studentsList):
    for each_student in studentsList:
        for key in each_student:
            print(key, " - ", each_student[key])


print(iterateDictionary(studentsList))

#GET VALUES FROM A LIST OF DICTIONARIES

def iterateDictionary2(a,studentsList):
    if a == 'first_name':
        for each_student in studentsList:
            print(each_student['first_name'])
    elif a == 'last_name':
        for each_student in studentsList:
            print(each_student['last_name'])

print(iterateDictionary2('last_name',studentsList))

#ITERATE THROUGH A DICTIONARY WITH LIST VALUES

dojo = {
    'locations': ['San Jose', 'Seattle', 'Dallas', 'Chicago', 'Tulsa', 'DC', 'Burbank'],
    'instructors': ['Michael', 'Amy', 'Eduardo', 'Josh', 'Graham', 'Patrick', 'Minh', 'Devon']
}

def printInfo(dojo):
    for dojoList in dojo:
        if dojoList == 'locations':
            print(len(dojo['locations']), dojoList)
            for locations in dojo['locations']:
                print(locations)
        elif dojoList == 'instructors':
            print(len(dojo['instructors']), dojoList)
            for instructors in dojo['instructors']:
                print(instructors)

print(printInfo(dojo))
