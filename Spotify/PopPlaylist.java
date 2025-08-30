public class PopPlaylist extends Playlist {
    // constructor
    public PopPlaylist(String name) {
        super(name);
    }

    // overriding addSong method to print out tailored playAllSongs message
    @Override
    public void playAllSongs() {
        System.out.println("🎶 Pop vibes in playlist: " + name);
        super.playAllSongs();
    }
}