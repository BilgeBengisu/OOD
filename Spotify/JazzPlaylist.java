public class JazzPlaylist extends Playlist {
    public JazzPlaylist(String name) {
        super(name);
    }

    // overriding addSong method to print out tailored playAllSongs message
    @Override
    public void playAllSongs() {
        System.out.println("🎷 Smooth jazz in playlist (Careless Whisper coming up): " + name);
        super.playAllSongs();
    }
}