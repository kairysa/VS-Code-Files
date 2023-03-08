class User:
    population = 0
    def __init__(self,first_name, last_name, email, age):
        self.first_name = first_name
        self.last_name = last_name
        self.email = email
        self.age = age
        self.is_rewards_member = False
        self.gold_card_points = 0
        User.population += 1

    def display_info(self):
        print(self.first_name)
        print(self.last_name)
        print(self.email)
        print(self.age)
        print(self.is_rewards_member)
        print(self.gold_card_points)
        return self

    def enroll(self):
        if self.is_rewards_member == True:
            print("User already a member")
        elif self.is_rewards_member == False:
            self.is_rewards_member = True
            self.gold_card_points = 200
            print("You are now a member with 200 points")
        return self

    def spend_points(self, amount):
        if amount <= self.gold_card_points:
            self.gold_card_points = self.gold_card_points - amount
        else:
            print("Not enough points")
        return self

    @classmethod
    def user_population(cls):
        print(f"{cls.population} users in the program.")

noah = User("Noah","Gardner","randomemail@email.com", 22)
akira = User("Akira", "Cole", "newemail@email.com", 23)

noah.display_info().enroll().display_info().spend_points(50).display_info()

User.user_population()