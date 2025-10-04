// Builder for Laptop
// price is fixed for custom products
// specs and name is handled with setAttribute function

import java.util.HashMap;
import java.util.Map;

public class LaptopBuilder implements ProductBuilder {
    private Product product;

    public LaptopBuilder() {
        product = new Laptop();
        product.setPrice(800); // fixed price for customized products
        if (product.getSpecs() == null) {
            product.setSpecs(new HashMap<>());
        }
    }

    @Override
    public ProductBuilder setAttribute(String key, String value) {
        if (key.equalsIgnoreCase("ProductName") || key.equalsIgnoreCase("Name")) {
            product.setName(value);
        } else {
            product.getSpecs().put(key, value);
        }
        return this;
    }

    @Override
    public Product build() {
        return product;
    }
}