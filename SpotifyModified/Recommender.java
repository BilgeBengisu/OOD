import java.util.ArrayList;
import java.util.List;

public class Recommender {  

    public List<Song> recommendByGenre(List<Song> songs, String genre) {  
        List<Song> recommendations = new ArrayList<>();
        for (Song song : songs) {
            if (song.getGenre().equalsIgnoreCase(genre)) {
                recommendations.add(song);
            }
            if (recommendations.size() == 3) {
                break; // stop after 3 songs
            }
        }

        // Print recommended songs
        System.out.println("Recommended songs for genre '" + genre + "':");
        for (Song s : recommendations) {
            System.out.println("- " + s.getTitle() + " by " + s.getArtist());
        }

        return recommendations;
    }

    public List<Song> recommendByMood(List<Song> songs, String mood) {  
        List<Song> recommendations = new ArrayList<>();
        for (Song song : songs) {
            if (song.getMood().equalsIgnoreCase(mood)) {
                recommendations.add(song);
            }
            if (recommendations.size() == 3) {
                break; // stop after 3 songs
            }
        }

        // Print recommended songs
        System.out.println("Recommended songs for mood '" + mood + "':");
        for (Song s : recommendations) {
            System.out.println("- " + s.getTitle() + " by " + s.getArtist());
        }

        return recommendations;
    }
}