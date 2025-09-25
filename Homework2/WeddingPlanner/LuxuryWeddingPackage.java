public class LuxuryWeddingPackage implements WeddingPackage {
    @Override
    public void setVenue() {
        System.out.println("Grand Palace");
    }

    @Override
    public void setCatering() {
        System.out.println("Gourmet Buffet");
    }

    @Override
    public void setDecoration() {
        System.out.println("Elegant Flowers");
    }

    @Override
    public void setPhotography() {
        System.out.println("Professional Videography");
    }
}
