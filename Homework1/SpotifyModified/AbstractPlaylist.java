// shared functions between different playlist types are implemented here

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPlaylist implements Playlist {
    protected String name;
    protected List<Song> songs = new ArrayList<>();

    public AbstractPlaylist(String name) { // base constructor
        this.name = name;
    }

    public String getName() {
        return name;
    }

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

    @Override
    public void playAllSongs() {
        System.out.println(name + " playlist playing:");
        for (Song s : songs) {
            s.displaySongInfo();
        }
    }
    
}
