// to simulate user interactions with the system
import java.util.*;
public class Main {
    public static void main(String[] args) {
        CreateSongs.createSampleSongs();

        List<Song> allSongs = Song.getAllSongs();

        // scanner
        Scanner scanner = new Scanner(System.in);
        // create the best bts fan
        User user = new User("Prof. Roy");

        // create BTS playlists (the best group ever)
        Playlist pop = user.createPlaylist("pop");
        Playlist rock = user.createPlaylist("rock");
        Playlist jazz = user.createPlaylist("jazz");

        for (Song song : allSongs) {
            if (song.getGenre().equalsIgnoreCase("pop")) {
                user.addSongToPlaylist(pop, song);
            } else if (song.getGenre().equalsIgnoreCase("rock")) {
                user.addSongToPlaylist(rock, song);
            } else if (song.getGenre().equalsIgnoreCase("jazz")) {
                user.addSongToPlaylist(jazz, song);
            }
        }
        
        System.out.println("Welcome to BTS Spotify, " + user.getUsername() + "!");
        System.out.print("Would you like to see all songs(1), songs by genre(2), or songs by mood(3)? Enter the number: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline after user input

        // giving responses based on the user's input
        if (choice == 1) {
            System.out.println("Here are all the songs:");
            for (Song song : allSongs) {
                song.displaySongInfo();
            }
        } else if (choice == 2) {
            Recommender recommender = new Recommender();
            System.out.print("Enter a genre (pop, rock, jazz): ");
            String genre = scanner.nextLine().toLowerCase();
            switch (genre) {
                case "pop":
                case "rock":
                case "jazz":
                    recommender.recommendByGenre(allSongs, genre);
                    break;
                default:
                    System.out.println("Invalid choice. No BTS for you");
                    scanner.close();
                    return;
            }
        } else if (choice == 3) {
            Recommender recommender = new Recommender();
            System.out.println("Which mood are you in? (Enter happy, sad, energetic, villain)");
            String mood = scanner.nextLine().toLowerCase();
            switch (mood) {
                // adding songs based on mood
                case "happy":
                case "sad":
                case "energetic":
                case "villain":
                    recommender.recommendByMood(allSongs, mood);
                    break;
                default:
                    // if invalid input, exit
                    System.out.println("Invalid mood. No BTS for you");
                    scanner.close();
                    return;
            }
        }       
    }
}