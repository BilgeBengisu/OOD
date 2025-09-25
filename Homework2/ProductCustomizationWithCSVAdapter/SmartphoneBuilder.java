public class SmartphoneBuilder implements ProductBuilder {
    private String screenSize =null;
    private String battery = null;
    private String camera = null;
    private String storage = null;

    @Override
    public ProductBuilder setAttribute(String key, String value) {
        switch (key.toLowerCase()) {
            case "screensize":
                this.screenSize = value;
                break;
            case "battery":
                this.battery = value;
                break;
            case "camera":
                this.camera = value;
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
        return new Smartphone(screenSize, battery, camera, storage);
    }
}