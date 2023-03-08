class User:
    def __init__(self, first_name, last_name, email, hobbies):
        self.first_name = first_name
        self.last_name = last_name
        self.email = email
        self.hobbies = hobbies
    
    def greeting(self):
        print("Hello, my name is", self.first_name)

kai = User("Kai", "Faelendari", "randomemail@email.com","gaming, coding, taking walks")

kai.greeting()
