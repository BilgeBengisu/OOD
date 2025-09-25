public class DestinationWeddingPackage implements WeddingPackage {
    @Override
    public void setVenue() {
        System.out.println("Beach Resort");
    }

    @Override
    public void setCatering() {
        System.out.println("Seafood Buffet");
    }

    @Override
    public void setDecoration() {
        System.out.println("Tropical Flowers");
    }

    @Override
    public void setPhotography() {
        System.out.println("Drone Photography");
    }
}
