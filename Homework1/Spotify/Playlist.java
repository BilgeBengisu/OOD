import java.util.ArrayList;
import java.util.List;

public class Playlist {
    // using protected instead of private to allow access in subclasses
    protected String name;
    private List<Song>  songs;

    // constructor
    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    // getter
    public String getName() {
        return name;
    }

    // methods
    public void addSong(Song song) {
        songs.add(song);
        System.out.println(song.getTitle() + " added to " + name + " playlist.");
    }
    public void removeSong(Song song) {
        // extra step: checking if the song is in the playlist
        if (songs.remove(song)) {
            System.out.println(song.getTitle() + " removed from " + name + " playlist.");
        } else {
            System.out.println(song.getTitle() + " not found in " + name + " playlist.");
        }
    }

    public void playAllSongs() {
        System.out.println("Playing playlist: " + name);
        for (Song song : songs) {
            song.displaySongInfo();
        }
    }
}