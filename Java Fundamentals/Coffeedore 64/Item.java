public class Item {
    private int index;
    private String name;
    private double price;

    // CONSTRUCTOR //

    public Item(){
    }
    public Item(String name, double price, int index){
        this.name = name;
        this.price = price;
        this.index = index;
    }

    // SETTERS //

    public void setName(String name){
        this.name = name;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setIndex(int index){
        this.index = index;
    }

    // GETTERS //

    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public int getIndex(){
        return index;
    }
}
