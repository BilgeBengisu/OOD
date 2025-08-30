// to simulate user interactions with the system
import java.util.*;
public class Main {
    public static void main(String[] args) {
        // to get user input
        Scanner scanner = new Scanner(System.in);

        // create the best bts fan
        User user = new User("Prof. Roy");

        // create BTS playlists (the best group ever)
        Playlist pop = user.createPlaylist("BTS pop hits", "pop");
        Playlist rock = user.createPlaylist("BTS Rock hits", "rock");
        Playlist jazz = user.createPlaylist("BTS Jazz hits", "jazz");

        // create songs (more BTS)
        // 5 per genre
        // had to search bunch of BTS songs
        List<Song> popSongs = Arrays.asList(
            new Song("7", "BTS", 3.2),
            new Song("Spring Day", "BTS", 2.9),
            new Song("Dynamite", "BTS", 3.0),
            new Song("Butter", "BTS", 2.8),
            new Song("Boy With Luv", "BTS", 3.5)
        );

        List<Song> rockSongs = Arrays.asList(
            new Song("Fake Love Rock Version", "BTS", 5.9),
            new Song("Rock Anthem", "BTS", 4.0),
            new Song("Louder than Bombs ", "BTS", 3.6),
            new Song("War of Hormone Rock Remix", "BTS", 4.2),
            new Song("Burning Up", "BTS", 3.9)
        );

        List<Song> jazzSongs = Arrays.asList(
            new Song("Singularity", "BTS", 7.0),
            new Song("Blue & Grey (Jazz Mix)", "BTS", 4.5),
            new Song("Serendipity Jazz Version", "BTS", 5.0),
            new Song("Whalien 52 Jazz Version", "BTS", 6.2),
            new Song("Butterfly Jazz Version", "BTS", 4.7)
        );

        System.out.println("Welcome to BTS Spotify!");
        System.out.print("Enter a genre: pop, rock, or jazz: ");
        String genre = scanner.nextLine().toLowerCase();

        // to add recommendations
        List<Song> recommendations = new ArrayList<>();

        switch (genre) {
            case "pop":
                recommendations = popSongs;
                break;
            case "rock":
                recommendations = rockSongs;
                break;
            case "jazz":
                recommendations = jazzSongs;
                break;
            default:
                System.out.println("No BTS for you");
        }

        // if user entered valid genre, show recommendations
        if (!recommendations.isEmpty()) {
            System.out.println("Here are some recommended " + genre + " songs:");
            for (Song song : recommendations) {
                System.out.println("- " + song.getTitle() + " by " + song.getArtist());
            }
        }

        

        scanner.close();
    }

}
