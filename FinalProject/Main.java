// import ui.ConsoleFlashcardUI;
import loader.CSVLoader;

public class Main {
    public static void main(String[] args) {
        // new ConsoleFlashcardUI().start();
        new CSVLoader().
        loadCSV("phrases/turkish_phrases.csv");
    }
}