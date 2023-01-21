import java.util.ArrayList;
import java.util.Arrays;
public class CafeUtil {
    public int getStreakGoal(){
        int sum = 0;
        for (int i = 0; i<11; i++){
            sum += i;
        }
        return sum;
    }

    public int getStreakGoal(int numWeeks){
        int sum = 0;
        for (int i = 0; i <= numWeeks; i++){
            sum += i;
        }
        return sum;
    }

    public double getOrderTotal(double[] lineItems){
        double orderTotal = 0;
        for (int i=0; i<lineItems.length; i++){
            orderTotal += lineItems[i];
        }
        return orderTotal;
    }
    public void displayMenu(ArrayList<String> menuItems){
        for (int i = 0; i < menuItems.size(); i++){
            System.out.println(i + " " + menuItems.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customerList) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.printf("Hello, %s! ", userName);
        System.out.printf("There are %s people ahead of you.\n", customerList.size());
        customerList.add(userName);
        System.out.println(customerList);
    }
}