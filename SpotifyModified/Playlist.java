// in the modified version, Playlist is an interface

import java.util.ArrayList;
import java.util.List;

interface Playlist {
    void addSong(Song song);
    void removeSong(Song song);
    void playAllSongs();
    String getName();
}