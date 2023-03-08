import java.util.ArrayList;
public class Order {
    private String name;
    private boolean ready;
    private ArrayList<Item> items;

    public Order(){
    }

    public Order(String name){
        this.name = name;
        ready = false;
        items = new ArrayList<Item>();
    }
    
    // SETTERS //
    public void addItems(Item items){
        this.items.add(items);
    }
    public void setName(String name){
        this.name = name;
    }
    public void setReady(boolean ready){
        this.ready = ready;
    }

    // GETTERS //
    public String getName(){
        return name;
    }
    public boolean getReady(){
        return ready;
    }
    public ArrayList<Item> getItems(){
        return items;
    }
    public double getOrderTotal(){
        double total = 0;
        for(Item item : items){
            total += item.getPrice();
        }
        return total;
    }
    
    public void display(){
        System.out.println("Customer Name: "+ name);
        for(Item item : items){
            System.out.println(item.getName()+" - $"+item.getPrice());
        }
        System.out.println("Total: $"+getOrderTotal());
    }
}
