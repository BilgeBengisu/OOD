public class Main {
    public static void main(String[] args) {
        // testing composite pattern with category and product
        Category electronics = new Category("Electronics");
        Category clothing = new Category("Clothing");

        Product smartphone = new Product("Smartphone", 700);
        Product laptop = new Product("Laptop", 1200);
        Product shirt = new Product("Shirt", 35);

        electronics.addProduct(smartphone);
        electronics.addProduct(laptop);
        clothing.addProduct(shirt);

        electronics.display();
        clothing.display();

        // creating black friday deals

        BlackFridayDeals deals = new BlackFridayDeals();

        // creating customers
        Customer jim = new Customer("jim", true);
        Customer jimin = new Customer("jimin", false);
        Customer jungkook = new Customer("jungkook", true);

        // adding customers as observers - only jim and jungkook are subscribed for notifications
        deals.addObserver(jim);
        deals.addObserver(jimin);
        deals.addObserver(jungkook);

        // the notification for hte below deals will only go to jim and jungkook
        // set a new deal
        deals.setDeal("50% off all electronics! don't miss it!!");

        // deal later
        deals.setDeal("Buy 1 Get 1 Free on Clothing!");
    }
}