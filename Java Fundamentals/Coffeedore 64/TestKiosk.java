public class TestKiosk {
    public static void main(String[] args){
        CoffeeKiosk coffeeKiosk = new CoffeeKiosk();

        coffeeKiosk.addMenuItem("mocha", 2.50, 0);
        coffeeKiosk.addMenuItem("coffee", 1.00, 1);
        coffeeKiosk.addMenuItem("cappucino", 3.00, 2);
        coffeeKiosk.addMenuItem("muffin", 4.00, 3);
        coffeeKiosk.addMenuItem("donut", 1.50, 4);

        coffeeKiosk.newOrder();
    }
}
