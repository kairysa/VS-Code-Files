from distutils.log import INFO


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


accountone = BankAccount(.03, 100)
accounttwo = BankAccount(.01, 50)

accountone.transactions(290).transactions(310).transactions(50).transactions(-100).yield_interest().display_account_info()
accounttwo.transactions(50).transactions(4839.2).transactions(-248).transactions(-143).transactions(-24.7).transactions(-198.5).yield_interest().display_account_info()

BankAccount.bank_account_data()