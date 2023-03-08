import java.util.ArrayList;
public class Order{
    private String name;
    private boolean ready;
    private ArrayList<Item> items;

    public Order(){
        name = "Guest";
        items = new ArrayList<Item>();
        ready = false;
    }
    public Order(String name){
        this.name = name;
        items = new ArrayList<Item>();
        ready = false;
    }

    // SETTERS //
    public void setName(String name){
        this.name = name;
    }

    public void setReady(boolean ready){
        this.ready = ready;
    }

    public void addItems(Item drinks){
        items.add(drinks);
    }

    // GETTERS //

    public String getName(){
        return name;
    }

    public double getTotal(){
        double total = 0;
        for (int i=0; i<items.size();i++){
            total += items.get(i).getPrice();
        }
        return total;
    }

    public String getReady(){
        if(ready){
            return String.format("Your order is ready!");
        }
        else{
            return String.format("Your order is being prepared, thank you for your patience.");
        }
    }

    public String getItems(){
        for (int i=0; i<items.size();i++){
            System.out.println(items.get(i).getName());
        }
        return items.get(0).getName();
    }
}