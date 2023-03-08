import java.util.ArrayList;
public class CoffeeKiosk {
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

    public CoffeeKiosk(){
        menu = new ArrayList<Item>();
        orders = new ArrayList<Order>();
    }

    public void addMenuItem(String name, double price, int index){
        Item menuItem = new Item();
        menuItem.setName(name);
        menuItem.setPrice(price);
        menuItem.setIndex(index);
        menu.add(menuItem);
    }
    
    public String displayMenu(){
        for(int i = 0; i < menu.size(); i++){
            System.out.println(menu.get(i).getIndex() + " " + menu.get(i).getName() + " -- " + menu.get(i).getPrice());
        }
        return String.format("Full menu");
    }

    public void newOrder() {
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
        Order newOrder = new Order(name);
        System.out.println("Please enter a menu item index or q to quit:");
        System.out.println(displayMenu());
        String itemNumber = System.console().readLine();
        while(!itemNumber.equals("q")) {
            try{
                newOrder.addItems(menu.get(Integer.parseInt(itemNumber)));
            }catch(IndexOutOfBoundsException i){
                System.out.println("Invalid selection");
            }catch(NumberFormatException n){
                System.out.println("Invalid selection");
            }
            System.out.println("Please enter another item index or q to quit:");
            itemNumber = System.console().readLine();
            }
            
            newOrder.display();
        }
    }

