public class WeddingPackageBuilder {
    private WeddingPackage weddingPackage;

    public WeddingPackageBuilder() {
    }

    public WeddingPackageBuilder setWeddingPackage(WeddingPackage weddingPackage) {
        this.weddingPackage = weddingPackage;
        return this;
    }

    public WeddingPackageBuilder buildVenue(String venue) {
        weddingPackage.setVenue(venue);
        return this;
    }

    public WeddingPackageBuilder buildCatering(String catering) {
        weddingPackage.setCatering(catering);
        return this;
    }

    public WeddingPackageBuilder buildDecoration(String decoration) {
        weddingPackage.setDecoration(decoration);
        return this;
    }

    public WeddingPackageBuilder buildPhotography(String photography) {
        weddingPackage.setPhotography(photography);
        return this;
    }

    public WeddingPackage build() {
        return this.weddingPackage;
    }

}
