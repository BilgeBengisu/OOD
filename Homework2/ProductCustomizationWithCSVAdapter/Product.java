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

    // setters and convenience constructor used by other classes
    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSpecs(Map<String, String> specs) {
        this.specs = specs;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // convenience constructor for CSV adapter (e.g. laptop rows)
    public Product(String name, String processor, int ram, int storage, String integrated, String operatingSystem, double price) {
        this.name = name;
        this.type = "Custom";
        this.price = price;
        this.specs = new HashMap<>();
        this.specs.put("Processor", processor);
        this.specs.put("Ram", Integer.toString(ram));
        this.specs.put("Storage", Integer.toString(storage));
        this.specs.put("Integrated", integrated);
        this.specs.put("OS", operatingSystem);
    }

    // default no-arg constructor
    public Product() {
        // leave fields null/zero until set
    }
}