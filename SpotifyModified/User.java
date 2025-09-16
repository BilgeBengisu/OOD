import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private List<Playlist> playlists;

    public User(String username) {
        this.username = username;
        this.playlists = new ArrayList<>();
    }
    // to print username in main.java
    public String getUsername() {
        return username;
    }
    // Create playlist by type
    public Playlist createPlaylist(String name, String type) {
        Playlist playlist = null;
        switch (type.toLowerCase()) {
            case "pop":
                playlist = new PopPlaylist(name);
                break;
            case "rock":
                playlist = new RockPlaylist(name);
                break;
            case "jazz":
                playlist = new JazzPlaylist(name);
                break;
            default:
                System.out.println("Unknown playlist type!");
        }

        if (playlist != null) {
            playlists.add(playlist);
            System.out.println(type + " playlist '" + name + "' created.");
        }
        return playlist;
    }

    // delete playlist
    public void deletePlaylist(Playlist playlist) {
        playlists.remove(playlist);
        System.out.println("Playlist '" + playlist.getName() + "' deleted.");
    }

    // add song to playlist
    public void addSongToPlaylist(Playlist playlist, Song song) {
        playlist.addSong(song);
    }

    // remove song from playlist
    public void removeSongFromPlaylist(Playlist playlist, Song song) {
        playlist.removeSong(song);
    }

    // display all playlists
    public void displayPlaylists() {
        System.out.println(username + "'s Playlists:");
        for (Playlist p : playlists) {
            System.out.println("- " + p.getName());
        }
    }
}
