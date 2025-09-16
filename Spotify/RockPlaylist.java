public class RockPlaylist extends Playlist {
    public RockPlaylist(String name) {
        super(name);
    }

    // Polymorphism
    // overriding addSong method to print out tailored playAllSongs message
    @Override
    public void playAllSongs() {
        System.out.println("🎸 Rocking out with playlist: " + name);
        super.playAllSongs();
    }
}