// Builder for Smartphone
// price is fixed for custom products
// specs and name is handled with setAttribute function

import java.util.HashMap;
import java.util.Map;

public class SmartphoneBuilder implements ProductBuilder {
    private Product product;

    public SmartPhoneBuilder() {
        product = new Smartphone();
        product.setPrice(800); // fixed price for customized products
        if (this.smartphone.getSpecs() == null) {
            this.smartphone.setSpecs(new HashMap<>());
        }
    }

    @Override
    public ProductBuilder setAttribute(String key, String value) {
        if (key.equalsIgnoreCase("ProductName")) {
            smartphone.setName(value);
        }
        else {
            product.getSpecs().put(key, value);
        }
        return this;
    }

    @Override
    public Product build() {
        return product;
    }
}