public class WeddingPackageBuilder {
    public WeddingPackageBuilder setWeddingPackage(WeddingPackage weddingPackage) {
        this.weddingPackage = weddingPackage;
        return this;
    }

    public Builder buildVenue(venue) {
        weddingPackage.setVenue(venue);
        return this;
    }
    public Builder buildCatering(catering) {
        weddingPackage.setCatering();
        return this;
    }
    public Builder buildDecoration(decoration) {
        this.decoration = decoration;
        return this;   
    }
    public Builder buildPhotography(photography) {
        this.photography = photography;
        return this;
    }
    build() {
        return new WeddingPackage(this);
    }
    
}
