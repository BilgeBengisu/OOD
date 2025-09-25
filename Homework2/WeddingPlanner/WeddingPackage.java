public abstract WeddingPackage {
    private String venue;
    private String catering;
    private String decoration;
    private String photography;

    void setVenue();
    void setCatering();
    void setDecoration();
    void setPhotography();

    public String displayInfo() {
        return "Venue: " + venue + ", Catering: " + catering + ", Decoration: " + decoration + ", Photography: " + photography;
    }
}