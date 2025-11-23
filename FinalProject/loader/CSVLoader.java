package loader;

import model.Deck;
import model.Flashcard;
import model.Language;

import java.io.BufferedReader;
import java.io.FileReader;

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

                deck.addCard(new Flashcard(front, back, lang));
            }
        } catch (Exception e) {
            System.out.println("Error loading CSV: " + e.getMessage());
        }

        System.out.println("Loaded " + deck.getCards().size() + " cards from " + filePath);
        return deck;
    }

    // Simple CSV parser that handles quoted fields with commas
    private static String[] parseCsvLine(String line) {
        if (line == null) return new String[0];
        StringBuilder cur = new StringBuilder();
        java.util.List<String> parts = new java.util.ArrayList<>();
        boolean inQuotes = false;

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
        parts.add(cur.toString().trim());
        return parts.toArray(new String[0]);
    }
}