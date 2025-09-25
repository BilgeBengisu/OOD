public class TraditionalWeddingPackage implements WeddingPackage {
    @Override
    public void setVenue() {
        System.out.println("Country Club");
    }

    @Override
    public void setCatering() {
        System.out.println("Classic Buffet");
    }

    @Override
    public void setDecoration() {
        System.out.println("Traditional Flowers");
    }

    @Override
    public void setPhotography() {
        System.out.println("Local Photographer");
    }
}
