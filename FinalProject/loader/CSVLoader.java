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

public class CSVLoader {
    public static Deck loadDeck(String filePath, Language lang) {
        Deck deck = new Deck();
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

                // add new Flashcard to the deck with phrase and translation extracted from the CSV
                deck.addCard(new Flashcard(front, back, lang));
            }

            // log success
            System.out.println("Loaded " + deck.getCards().size() + " cards from " + filePath);
        } catch (Exception e) { // log error
            System.out.println("Error loading CSV: " + e.getMessage());
        }

        return deck;
    }

    // Simple CSV parser that handles quoted fields with commas
    private static String[] parseCsvLine(String line) {
        if (line == null) return new String[0];
        StringBuilder cur = new StringBuilder();
        java.util.List<String> parts = new java.util.ArrayList<>();
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