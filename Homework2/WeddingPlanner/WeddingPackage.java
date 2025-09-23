public interface WeddingPackage {
    private String venue;
    private String catering;
    private String decoration;
    private String photography;

    public WeddingPackage(String venue, String catering, String decoration, String photography) {
        this.venue = venue;
        this.catering = catering;
        this.decoration = decoration;
        this.photography = photography;
    }

    public String getDetails() {
        return "Venue: " + venue + ", Catering: " + catering + ", Decoration: " + decoration + ", Photography: " + photography;
    }
}
