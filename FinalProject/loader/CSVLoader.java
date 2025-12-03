package loader;

import model.Deck;
import model.Flashcard;
import model.Language;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * CSVLoader.java
 * CSVLoader class has two methods:
 * loadDeck(String filePath, Language lang): Loads the csv file that was passed and return a Deck object
 * that has multiple flashcards extracted from the CSV file
 * parseCsvLine(String line): returns an array 
 * @author: Bilge Akyol 
**/

import java.util.List;
import java.util.ArrayList;

public class CSVLoader {
    /**
     * Loads flashcards from a CSV file and returns a list of Flashcard objects.
     * This method does NOT create a Deck; it only loads data. The responsiblity for creating deck is on Factory pattern
     */
    public static List<Flashcard> loadFlashcards(String filePath, Language lang) {
        List<Flashcard> flashcards = new ArrayList<>();
        System.out.println("Loading CSV from: " + filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                // skip header if present
                if (firstLine && line.toLowerCase().contains("difficulty")) {
                    firstLine = false;
                    continue;
                }
                firstLine = false;

                String[] parts = parseCsvLine(line);

                // try to map columns: if 3+ columns, assume [difficulty, phrase, translation]
                String front = null;
                String back = null;

                // get front and back from parts array
                if (parts.length >= 3) {
                    front = parts[0].trim();
                    back = parts[1].trim();
                } else if (parts.length == 2) {
                    front = parts[0].trim();
                    back = parts[1].trim();
                } else {
                    // skip malformed lines
                    System.out.println("Skipping malformed CSV line: " + line);
                    continue;
                }

                // add new Flashcard to the list
                flashcards.add(new Flashcard(front, back, lang));
            }

            // log success
            System.out.println("Loaded " + flashcards.size() + " cards from " + filePath);
        } catch (Exception e) { // log error
            System.out.println("Error loading CSV: " + e.getMessage());
        }

        return flashcards;
    }

    // Simple CSV parser that handles quoted fields with commas
    private static String[] parseCsvLine(String line) {
        if (line == null) return new String[0];
        StringBuilder cur = new StringBuilder();
        List<String> parts = new ArrayList<>();
        boolean inQuotes = false;

        // iterate char by char
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '"') {
                // handle double quote escaping by looking ahead
                if (inQuotes && i + 1 < line.length() && line.charAt(i + 1) == '"') {
                    // escaped quote -> append one quote and skip next
                    cur.append('"');
                    i++;
                } else {
                    inQuotes = !inQuotes;
                }
            } else if (c == ',' && !inQuotes) {
                parts.add(cur.toString().trim());
                cur.setLength(0);
            } else {
                cur.append(c);
            }
        }
        // add current string
        parts.add(cur.toString().trim());
        return parts.toArray(new String[0]);
    }
}