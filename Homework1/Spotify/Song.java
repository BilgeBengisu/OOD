public class Song {
    private String title;
    private String artist;
    private double duration;

    // constructor
    public Song(String title, String artist, double duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;  
    }

    // getters
    public String getTitle() {
        return title;
    }
    public String getArtist() {
        return artist;
    }
    public double getDuration() {
        return duration;
    }

    // Display Song Info
    public void displaySongInfo() {
        System.out.println( title + " by " + artist + " (" + duration + " mins)");
    }
}