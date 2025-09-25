// parent class for products

public class Product {
    private String name;
    private String type;
    private Map<String, String> specs;
    private double price = 800;

    public Product(String name, String type, Map<String, String> specs, double price) {
        this.name = name;
        this.type = type;
        this.specs = specs;
        this.price = price;
    }

    // getters and setters
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public Map<String, String> getSpecs() {
        return specs;
    }
    public double getPrice() {
        return price;
    }

    public String displaySpecs() {
        return "Product Name: " + name + ", Type: " + type + ", Specs: " + specs.toString() + ", Price: $" + price;
    }
}