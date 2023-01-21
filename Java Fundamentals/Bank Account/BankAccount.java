public class BankAccount{
    private String name;
    private double checkingBalance;
    private double savingBalance;
    private static int numOfAccounts = 0;
    private static double totalAmount = 0;

    // CONSTRUCTORS //
    public BankAccount(String name){
        this.name = name;
        checkingBalance = 0;
        savingBalance = 0;
        numOfAccounts++;
    }

    public BankAccount(String name, double /checkingBalance){
        this.name = name;
        this.checkingBalance = checkingBalance;
        savingBalance = 0;
        numOfAccounts++;
    }
    
    public BankAccount(String name, double checkingBalance, double savingBalance){
        this.name = name;
        this.checkingBalance = checkingBalance;
        this.savingBalance = savingBalance;
        numOfAccounts++;
    }


    // SETTERS //

    public void depositChecking(double deposit){
        checkingBalance += deposit;
        totalAmount += deposit;
        System.out.println("You've deposited $" + deposit + " into your checking.");
        System.out.println("Your checking balace is now $" + checkingBalance);
    }

    public void depositSaving(double deposit){
        savingBalance += deposit;
        totalAmount += deposit;
        System.out.println("You've deposited $" + deposit + " into your savings.");
        System.out.println("Your savings balace is now $" + savingBalance);
    }

    public void withdrawChecking(double withdraw){
        if(checkingBalance < withdraw){
            System.out.println("Insufficient funds.");
        }
        else{
            checkingBalance -= withdraw;
            totalAmount -=withdraw;
            System.out.println("You've withdrawn $" + withdraw + " from your checking account. Your new balance is: $" + checkingBalance);
        }
    }

    public void withdrawSaving(double withdraw){
        if(savingBalance < withdraw){
            System.out.println("Insufficient funds.");
        }
        else{
            savingBalance -= withdraw;
            totalAmount -= withdraw;
            System.out.println("You've withdrawn $" + withdraw + " from your savings account. Your new balance is: $" + savingBalance);
        }
    }

    // GETTERS //
    public String checkingBalance(){
        return String.format("Your checking balance is: $" + checkingBalance);
    }
    public String savingBalance(){
        return String.format("Your savings balance is: $" + savingBalance);
    }
    public String totalBalance(){
        return String.format("Your total balance across checking and savings is: $" + (checkingBalance + savingBalance));
    }

    // STATICS //

    public static String getAccountCount(){
        return String.format("Number of accounts: " + numOfAccounts);
    }

    public static String getTotalAmount(){
        return String.format("Total Amount across all accounts: " + totalAmount);
    }
}
