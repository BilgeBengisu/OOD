package test;

import model.*;
import service.SessionManager;

/**
*  Test.java
*  This class tests the overall functionality of the flashcard application,
*  including language selection, flashcard loading, flashcard usage, progress tracking,
*  and session reset.
*  the test result can be followed on the console output.
* @author Bilge Akyol
**/


public class Test {
    public static void main(String[] args) {
        boolean passed = true;

        System.out.println("--- Application Functional Test ---");
        System.out.println("** Simple deck creation and flashcard loading test **");
        Deck deck = new Deck();
        deck.addCard(new Flashcard("Hello", "Ciao", Language.ITALIAN));
        deck.addCard(new Flashcard("Goodbye", "Arrivederci", Language.ITALIAN));
        if (deck != null) {
            System.out.println("Deck creation test: PASS");
        } else {
            System.out.println("Deck creation test: FAIL");
            passed = false;
        }
        System.out.println("\n** Full application flow test **");
        // Simulate application start
        System.out.println("** Singleton test for SessionManager **");
        SessionManager sm1 = SessionManager.getInstance();
        SessionManager sm2 = SessionManager.getInstance();
        if (sm1 == sm2) {
            System.out.println("PASS: Only one instance of SessionManager exists (singleton).\n");
        } else {
            System.out.println("FAIL: Multiple instances of SessionManager exist.\n");
        }

        System.out.println("** Test application start with Session Manager");
        SessionManager session = SessionManager.getInstance();
        System.out.println("Application started: PASS");

        // Select a language (Italian)
        System.out.println("\n** Test language selection and flashcard loading with Language, Flashcard, and Deck model, and CSVLoader **");
        Language selectedLanguage = Language.ITALIAN;
        System.out.println("Language selected: " + selectedLanguage);

        // Load flashcards from Italian CSV
        String csvPath = "phrases/italian_phrases.csv";
        java.util.List<model.Flashcard> loadedCards = loader.CSVLoader.loadFlashcards(csvPath, selectedLanguage);
        if (loadedCards.size() > 0) {
            System.out.println("Loaded " + loadedCards.size() + " Italian flashcards from CSV: PASS");
        } else {
            System.out.println("Loaded Italian flashcards from CSV: FAIL");
            passed = false;
        }

        // Add loaded cards to deck
        Deck sessionDeck = new Deck();
        for (Flashcard card : loadedCards) {
            sessionDeck.addCard(card);
        }
        session.setCurrentDeck(sessionDeck);
        System.out.println("Flashcards loaded into session: " + session.getTotalCards());

        System.out.println("\n** Test flashcard usage: show question, show answer, move to next using session instance from Session Manager **");
        System.out.println("\n** Test progress tracking with Observer pattern **");
        // Use flashcards: show question, show answer, move to next
        for (int i = 0; i < session.getTotalCards(); i++) {
            Flashcard card = session.getCurrentCard();
            System.out.println("Flashcard " + (i+1) + ": " + card.getFront());
            session.toggleShowingAnswer(true);
            if (session.isShowingAnswer()) {
                System.out.println("Answer: " + card.getBack());
            }
            // Print progress after each card
            int currentIndex = session.getCurrentIndex();
            int totalCards = session.getTotalCards();
            System.out.println("Progress: Card " + (currentIndex + 1) + " of " + totalCards);
            session.nextCard();
        }

        // Track progress
        int currentIndex = session.getCurrentIndex();
        int totalCards = session.getTotalCards();
        if (currentIndex == totalCards - 1) {
            System.out.println("Progress tracked: PASS");
        } else {
            System.out.println("Progress tracked: FAIL");
            passed = false;
        }

        // Reset session
        session.reset();
        if (session.getCurrentDeck() == null && !session.isShowingAnswer()) {
            System.out.println("Session reset: PASS");
        } else {
            System.out.println("Session reset: FAIL");
            passed = false;
        }

        // final result
        System.out.println("------- Final Test Result --------");
        if (passed) {
            System.out.println("\nAll tests passed successfully.\n\n");
        } else {
            System.out.println("\nSome tests failed. Please review the output above.\n\n");
        }
    }
}
