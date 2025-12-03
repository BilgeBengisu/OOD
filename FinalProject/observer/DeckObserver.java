package observer;

/**
 * DeckObserver.java
 * Observer interface for tracking flashcard progress for displaying.
 * Important point: The observer interface defines what observers get notified about, not how notifications happen
 * 
 * Observer
 * Subject: Deck
 * Subscriber: SessionController
 *
 * Implementing observers are notified when the user navigates through flashcards
 * in a session (e.g., moves to the next card or shuffles the deck).
 *
 * @author Bilge Akyol
 */
public interface DeckObserver {
    /**
     * called when the deck's progress changes (user moves to next card)
     *
     * currentIndex the index of the current card (1 to totalCards)
     * totalCards the total number of cards in the deck
     */
    void onProgressChanged(int currentIndex, int totalCards);
}
