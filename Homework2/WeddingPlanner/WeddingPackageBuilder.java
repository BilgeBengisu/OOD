public class WeddingPackageBuilder {
    constructor() {
        this.venue = "";
        this.catering = "";
        this.decoration = "";
        this.photography = "";
    }

    setVenue(venue) {
        this.venue = venue;
        return this;
    }
    setCatering(catering) {
        this.catering = catering;
        return this;
    }
    setDecoration(decoration) {
        this.decoration = decoration;
        return this;   
    }
    setPhotography(photography) {
        this.photography = photography;
        return this;
    }
    build() {
        return new WeddingPackage(this.venue, this.catering, this.decoration, this.photography);
    }
    
}
