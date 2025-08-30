import java.util.ArrayList;
import java.util.List;

public class RockPlaylist implements Playlist {
    private String name;
    private List<Song> songs = new ArrayList<>();

    public RockPlaylist(String name) {
        this.name = name;
    }

    // methods
    @Override
    public void addSong(Song song) {
        songs.add(song);
        System.out.println(song.getTitle() + " added to " + name + ".");
    }

    @Override
    public void removeSong(Song song) {
        if (songs.remove(song)) {
            System.out.println(song.getTitle() + " removed from " + name + ".");
        } else {
            System.out.println("Song not found in " + name + ".");
        }
    }

    // overriding addSong method to print out tailored playAllSongs message
    @Override
    public void playAllSongs() {
        System.out.println("🎸 Rock playlist: " + name);
        for (Song s : songs) {
            s.displaySongInfo();
        }
    }

    @Override
    public String getName() {
        return name;
    }
}