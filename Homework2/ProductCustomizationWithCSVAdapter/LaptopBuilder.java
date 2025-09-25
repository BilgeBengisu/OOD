public class LaptopBuilder implements ProductBuilder {
    private String screenSize =null;
    private String processor = null;
    private String ram = null;
    private String storage = null;

    @Override
    public ProductBuilder setAttribute(String key, String value) {
        switch (key.toLowerCase()) {
            case "screensize":
                this.screenSize = value;
                break;
            case "processor":
                this.processor = value;
                break;
            case "ram":
                this.ram = value;
                break;
            case "storage":
                this.storage = value;
                break;
            default:
                throw new IllegalArgumentException("Unknown attribute: " + key);
        }
        return this;
    }

    @Override
    public Product build() {
        return new Laptop(screenSize, processor, ram, storage);
    }
}