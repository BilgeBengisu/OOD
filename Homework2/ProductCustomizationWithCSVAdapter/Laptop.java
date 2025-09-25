public class Laptop implements Product {
    private double screenSize;
    private String processor;
    private double ram;
    private double storage;

    public Laptop(String screenSize, String processor, String ram, String storage) {
        this.screenSize = screenSize;
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
    }

}