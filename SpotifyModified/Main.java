// to simulate user interactions with the system
import java.util.*;
public class Main {
    public static void main(String[] args) {
        // scanner
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

        System.out.println("Welcome to BTS Spotify, " + user.getUsername() + "!");
        System.out.print("Would you like to see all songs(1), songs by genre(2), or songs by mood(3)? Enter the number: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline after user input
        List<Song> allSongs = new ArrayList<>();
        allSongs.addAll(popSongs);
        allSongs.addAll(rockSongs);
        allSongs.addAll(jazzSongs);
        // giving responses based on the user's input
        if (choice == 1) {
            System.out.println("Here are all the songs:");
            for (Song song : allSongs) {
                song.displaySongInfo();
            }
        } else if (choice == 2) {
            System.out.print("Enter a genre (pop, rock, jazz): ");
            String genre = scanner.nextLine().toLowerCase();
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
                    System.out.println("Invalid genre. Showing all songs.");
                    recommendations = allSongs;
            }

            // if user entered valid genre, show recommendations
            if (!recommendations.isEmpty()) {
                System.out.println("Here are some recommended " + genre + " songs:");
                for (Song song : recommendations) {
                    System.out.println("- " + song.getTitle() + " by " + song.getArtist());
                }
            }
            else{
                System.out.println("Invalid choice. No BTS for you");
                scanner.close();
                return;
            }
        } else if (choice == 3) {
            System.out.println("Which mood are you in? (Enter happy, sad, energetic, calm)");
            String mood = scanner.nextLine().toLowerCase();
            List<Song> moodSongs = new ArrayList<>();
            switch (mood) {
                // adding songs based on mood
                case "happy":
                    moodSongs.addAll(Arrays.asList(
                        new Song("Dynamite", "BTS", 3.0),
                        new Song("Butter", "BTS", 2.8)));
                    break;
                case "sad":
                    moodSongs.addAll(Arrays.asList(
                        new Song("Spring Day", "BTS", 2.9),
                        new Song("Blue & Grey (Jazz Mix)", "BTS", 4.5)));
                    break;
                case "energetic":
                    moodSongs.addAll(Arrays.asList(
                        new Song("Fake Love Rock Version", "BTS", 5.9),
                        new Song("War of Hormone Rock Remix", "BTS", 4.2)));
                    break;
                case "calm":
                    moodSongs.addAll(Arrays.asList(
                        new Song("Singularity", "BTS", 7.0),
                        new Song("Serendipity Jazz Version", "BTS", 5.0)));
                    break;
                default:
                // if invalid input, exit
                    System.out.println("Invalid mood. No BTS for you");
                    scanner.close();
                    return;
            }
            System.out.println("Here are some " + mood + " songs:");
            for (Song song : moodSongs) {
                song.displaySongInfo();
            }       
        } else {
            System.out.println("Invalid choice. No BTS for you");
            scanner.close();
            return;
        }
    }

}