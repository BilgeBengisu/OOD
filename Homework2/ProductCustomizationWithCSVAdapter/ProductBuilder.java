// Product Builder serves as the interface for SmartphoneBuilder nad LaptopBuilder 
// which implements the interface to build custom products

public interface ProductBuilder {
    ProductBuilder setAttribute(String key, String value);
    Product build();
}