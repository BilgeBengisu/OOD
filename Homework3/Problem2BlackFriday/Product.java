public class Product {
    private String name;
    private double price;

    public String getName() {
        return this.name;
    }

    public String getPrice() {
        return this.price;
    }

    public void display() {
        System.out.println("Product " + name + " has price " + price)
    }
}