// parent class for products
import java.util.Map;
import java.util.HashMap;
public class Product {
    private String name;
    private String type;
    private Map<String, String> specs;
    private double price;

    // getters
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