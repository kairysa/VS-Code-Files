public class TestOrders {
    public static void main(String[] args){
        

        // Menu //
        Item dripCoffee = new Item();
        dripCoffee.setName("Drip Coffee");
        dripCoffee.setPrice(1.99);

        Item mocha = new Item();
        mocha.setName("Mocha");
        mocha.setPrice(2.99);

        Item capuccino = new Item();
        capuccino.setName("Capuccino");
        capuccino.setPrice(3.99);

        // Orders //

        // ORDER 1 //

        Order order1 = new Order("Jonathan");
        order1.addItems(dripCoffee);
        order1.addItems(mocha);
        order1.setReady(true);

        System.out.println("--- ORDER 1 ---");
        System.out.println("Customer Name: " + order1.getName());
        System.out.println("Total: " + order1.getTotal());
        System.out.println(order1.getReady());
        System.out.println("-- Items on Order: --");
        order1.getItems();

        // ORDER 2 // 

        Order order2 = new Order();
        order2.addItems(capuccino);
        order2.addItems(dripCoffee);
        order2.setReady(false);

        System.out.println("--- ORDER 2 ---");
        System.out.println("Customer Name: " + order2.getName());
        System.out.println("Total: " + order2.getTotal());
        System.out.println(order2.getReady());
        System.out.println("-- Items on Order: --");
        order1.getItems();


    }
}