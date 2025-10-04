/*
 * Wedding Factory class to create different Wedding Packages
 */

public class WeddingFactory {
    public static WeddingPackage createWeddingPackage(String type) {
        switch (type.toLowerCase()) {
            case "traditional":
                return new TraditionalWeddingPackage();
            case "destination":
                return new DestinationWeddingPackage();
            case "luxury":
                return new LuxuryWeddingPackage();
            default:
                throw new IllegalArgumentException("Unknown wedding package type: " + type);
        }
    }

    public WeddingPackage getWeddingPackage(String type) {
        return createWeddingPackage(type);
    }
}
