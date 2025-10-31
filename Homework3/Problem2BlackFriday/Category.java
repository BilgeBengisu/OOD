import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<ProductComponent> components = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

    public void addProduct(Product product) {
        components.add(product);
    }

    public void removeProduct(Product product) {
        components.remove(product);
    }

    public void display() {
        System.out.println("Category: " + name);
        for (ProductComponent component : components) {
            component.display();
        }
    }
}