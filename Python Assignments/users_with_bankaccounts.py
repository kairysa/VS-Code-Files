class BankAccount:
    all_accounts = []
    def __init__(self, int_rate, balance):
        self.int_rate = int_rate
        self.balance = balance
        self.all_accounts.append(self)
    
    def transactions(self, amount):
        if amount >=  0:
            self.balance += amount
            print(f"New balance: {self.balance}")
        elif amount < 0:
            if self.balance < abs(amount):
                print("Insufficient Funds: Charging a $5 fee")
                self.balance += amount - 5
                print(f"New balance: {self.balance}")
            elif self.balance >= amount:
                self.balance += amount
                print(f"New balance: {self.balance}")
        return self
    
    def display_account_info(self):
        print(f"Balance: {self.balance}")
        return self
    
    def yield_interest(self):
        if self.balance > 0:
            self.balance += self.balance * self.int_rate
        return self

    @classmethod
    def bank_account_data(cls):
        for info in cls.all_accounts:
            print(f"Balance: {info.balance}, Interest Rate: {info.int_rate}")

class User:
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.account = BankAccount(int_rate=0.02, balance=0)
    
    def make_transaction(self, amount):
        self.account.transactions(amount)
        return self

    def display_user_balance(self):
        print(f"Your current balance is: {self.account.balance}")
        return self

noah = User("Noah","randomemail@email.com")

noah.make_transaction(20).make_transaction(-40).make_transaction(100)

noah.display_user_balance()

