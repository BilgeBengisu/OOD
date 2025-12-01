import ui.FlashcardUI;
import loader.CSVLoader;

/**
 * Main.java
 * Entry point for the Language Phrases Flashcard Application.
 * 
 * initializes and starts the JavaSwing user interface for the flashcard learning application.
 * 
 * @author Bilge Akyol
 */
public class Main {
    public static void main(String[] args) {
        new FlashcardUI().start();
        // new CSVLoader().
        // loadCSV("phrases/turkish_phrases.csv");
    }
}