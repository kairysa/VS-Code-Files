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

class Shoe:
    # now our method has 4 parameters (including self)!
    def __init__(self, brand, shoe_type, price):
    	# we assign them accordingly
        self.brand = brand
        self.type = shoe_type
        self.price = price
        # the status is set to True by default
        self.in_stock = True
    
# Create two shoe instances
skater_shoe = Shoe("Vans", "Low-top Trainers", 59.99)
dress_shoe = Shoe("Jack & Jill Bootery", "Ballet Flats", 29.99)
        
# The skater shoes go on sale by 20% reduced price:
skater_shoe.price = skater_shoe.price * (1 - 0.2)
        
# The dress shoes go on sale by 10% reduction:
dress_shoe.price = dress_shoe.price * (1 - 0.1)
        
# The skater shoes go on sale AGAIN by another 10%:
skater_shoe.price = skater_shoe.price * (1 - 0.1)

