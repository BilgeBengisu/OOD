import java.util.ArrayList;
import java.util.List;

public class Song {
    private String title;
    private String artist;
    private double duration;
    private String genre;
    private String mood;

    // to create a song database
    private static List<Song> allSongs = new ArrayList<>();

    // constructor
    public Song(String title, String artist, double duration, String genre, String mood) {
        this.title = title;
        this.artist = artist;
        this.duration = duration; 
        this.genre = genre;
        this.mood = mood; 
        allSongs.add(this);
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
    public String getGenre() {
        return genre;
    }
    public String getMood() {
        return mood;
    }

    public static List<Song> getAllSongs() {
        return allSongs;
    }

    // filtering by genre
    public static List<Song> getSongsByGenre(String genre) {
        List<Song> result = new ArrayList<>();
        for (Song s : allSongs) {
            if (s.getGenre().equalsIgnoreCase(genre)) {
                result.add(s);
            }
        }
        return result;
    }

    // filtering by mood
    public static List<Song> getSongsByMood(String mood) {
        List<Song> result = new ArrayList<>();
        for (Song s : allSongs) {
            if (s.getGenre().equalsIgnoreCase(mood)) {
                result.add(s);
            }
        }
        return result;
    }

    // Display Song Info
    public void displaySongInfo() {
        System.out.println( title + " by " + artist + " (" + duration + " mins)");
    }
}