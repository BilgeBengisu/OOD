// to simulate user interactions with the system

public class Main {
    public static void main(String[] args) {
        // create the best bts fan
        User user = new User("Prof. Roy");

        // create BTS playlists (the best group ever)
        Playlist pop = user.createPlaylist("BTS pop hits", "pop");
        Playlist rock = user.createPlaylist("BTS Rock hits", "rock");
        Playlist jazz = user.createPlaylist("BTS Jazz hits", "jazz");

        // create songs
        Song s1 = new Song("7", "BTS", 3.2);
        Song s2 = new Song("Fake Love Rock Version", "BTS", 5.9);
        Song s3 = new Song("Singularity", "BTS", 7.0);
        Song s4 = new Song("Spring Day", "BTS", 2.9);

        // add songs to playlists
        user.addSongToPlaylist(pop, s1);
        user.addSongToPlaylist(rock, s2);
        user.addSongToPlaylist(jazz, s3);
        user.addSongToPlaylist(pop, s4);

        // show playlists
        user.displayPlaylists();

        // play songs
        pop.playAllSongs();
        rock.playAllSongs();
        jazz.playAllSongs();

        // remove song
        user.removeSongFromPlaylist(pop, s4);

        // play songs
        pop.playAllSongs();
    }
}
