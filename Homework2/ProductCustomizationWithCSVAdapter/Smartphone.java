public class Smartphone implements Product {
    private double screenSize;
    private double battery;
    private String camera;
    private double storage;

    public Smartphone(String screenSize, String battery, String camera, String storage) {
        this.screenSize = screenSize;
        this.battery = battery;
        this.camera = camera;
        this.storage = storage;
    }
}