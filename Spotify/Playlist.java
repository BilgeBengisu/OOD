public interface Playlist {
    void addSong(Song song);
    void removeSong(Song song);
    void playAllSongs();
    String getName();
}
