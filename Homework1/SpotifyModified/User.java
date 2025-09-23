import java.util.ArrayList;
import java.util.List;

/**
 * Methods:
    createPlaylist(String name, String type): Creates a playlist of a specified type (Pop, Rock, Jazz)
    deletePlaylist(Playlist playlist): Deletes a specified playlist
    addSongToPlaylist(Playlist playlist, Song song)
    removeSongFromPlaylist(Playlist playlist, Song song)
 */

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
    public Playlist createPlaylist(String type) {
        Playlist newPlaylist;
        switch (type.toLowerCase()) {
            case "rock":
                newPlaylist = new RockPlaylist();
                break;
            case "jazz":
                newPlaylist = new JazzPlaylist();
                break;
            case "pop":
                newPlaylist = new PopPlaylist();
                break;
            default:
                System.out.println("Unknown playlist type, couldn't create playlist.");
                return null;
        }
        playlists.add(newPlaylist);
        System.out.println("Playlist '" + newPlaylist.getName() + "' created.");
        return newPlaylist;
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
