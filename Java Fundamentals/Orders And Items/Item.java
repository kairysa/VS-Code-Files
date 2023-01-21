public class Item{
    private String name;
    private double price;

    public Item(){
    }

    // SETTERS // 

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(double price){
        this.price = price;
    }

    // GETTERS //

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }
}