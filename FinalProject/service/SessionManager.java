package service;

import model.Deck;
import model.Flashcard;

/**
 * SessionManager.java
 * Singleton that manages the current flashcard learning session.
 *
 * Encapsulates session state (current deck, card index, front/back display)
 * This decouples UI logic from card management and allows the Deck class
 * to focus on being an Observer subject.
 *
 * @author Bilge Akyol
 */
public class SessionManager {
    private static SessionManager instance;
    private Deck currentDeck;
    private boolean showingAnswer = false;

    // private constructor for Singleton
    private SessionManager() {
    }

    // get the single instance of SessionManager
    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    // set the current deck for this session
    // resets index and answer state
    public void setCurrentDeck(Deck deck) {
        this.currentDeck = deck;
        if (this.currentDeck != null) {
            this.currentDeck.reset();
        }
        this.showingAnswer = false;
    }

    // get the current flashcard being displayed
    public Flashcard getCurrentCard() {
        if (currentDeck == null || currentDeck.getCards().isEmpty()) {
            return null;
        }
        return currentDeck.getCurrentCard();
    }

    // move to the next card
    // notifies observers via the deck
    public void nextCard() {
        if (currentDeck != null) {
            currentDeck.nextCard();
            this.showingAnswer = false;
        }
    }

    // shuffle the deck and reset index
    public void shuffleDeck() {
        if (currentDeck != null) {
            currentDeck.shuffle();
            this.showingAnswer = false;
        }
    }

    // toggle answer visibility
    public void toggleShowingAnswer(boolean show) {
        this.showingAnswer = show;
    }

    // query whether the answer is currently shown
    public boolean isShowingAnswer() {
        return showingAnswer;
    }

    // get the current deck
    public Deck getCurrentDeck() {
        return currentDeck;
    }

    // get current index
    public int getCurrentIndex() {
        return currentDeck == null ? 0 : currentDeck.getCurrentIndex();
    }

    // reset the session (for starting a new one)
    public void reset() {
        currentDeck = null;
        showingAnswer = false;
    }

    // get total cards in current deck
    public int getTotalCards() {
        return currentDeck == null ? 0 : currentDeck.getCards().size();
    }
}
