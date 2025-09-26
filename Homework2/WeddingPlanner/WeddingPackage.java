public abstract class WeddingPackage {
    private String venue;
    private String catering;
    private String decoration;
    private String photography;

    protected WeddingPackage() {
    }

    public void setVenue(String venue){
        this.venue = venue;
    }

    public void setCatering(String catering){
        this.catering = catering;
    }

    public void setDecoration(String decoration){
        this.decoration = decoration;
    }

    public void setPhotography(String photography){
        this.photography = photography;
    }

    public String displayInfo() {
        return "Venue: " + venue + ", Catering: " + catering + ", Decoration: " + decoration + ", Photography: " + photography;
    }
}