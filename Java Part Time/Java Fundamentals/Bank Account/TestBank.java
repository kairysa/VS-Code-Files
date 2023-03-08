public class TestBank {
    public static void main(String[] args){
        BankAccount person1 = new BankAccount("Noah");
        BankAccount person2 = new BankAccount("Jake");
        BankAccount person3 = new BankAccount("Chase");


        System.out.println("--- NOAH'S TRANSACTIONS ---");
        person1.depositChecking(9006.32);
        person1.depositSaving(245.32);
        person1.withdrawSaving(400);
        person1.withdrawSaving(200);

        System.out.println(person1.checkingBalance());
        System.out.println(person1.savingBalance());
        System.out.println(person1.totalBalance());



        System.out.println("--- JAKE'S TRANSACTIONS ---");
        person2.depositChecking(501.44);
        person2.depositChecking(1004.03);

        System.out.println("--- CHASE'S TRANSACTIONS ---");
        person3.depositChecking(870.54);
        person3.depositChecking(201.44);


        // STATICS //
        System.out.println(BankAccount.getAccountCount());
        System.out.println(BankAccount.getTotalAmount());
    }
}
