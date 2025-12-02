package model;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import observer.DeckObserver;

/**
* Deck.java
* Represents a deck of flashcards. The deck gets constructed by the CSV Loader class when a language csv file is loaded in.
*
* Deck class is also the subject of the Observer pattern to keep progress of the flashcards practiced.
* 
* @author: Bilge Akyol 
**/

public class Deck {
    // flashcard deck to display multiple flashcards to practice phrases
    private List<Flashcard> cards = new ArrayList<>();
    private List<DeckObserver> observers = new ArrayList<>();

    private int currentIndex = 0;

    public void addCard(Flashcard card) {
        cards.add(card);
    }

    /*
    *
    * Observer Functionality
    *
    **/
    // add observer to the deck
    public void addObserver(DeckObserver obs) {
        observers.add(obs);
    }

    // remove observer from deck
    public void removeObserver(DeckObserver obs) {
        observers.remove(obs);
    }

    // notify observers of the flashcard progress
    private void notifyObservers() {
        for (DeckObserver obs : observers) {
            // current index should start at 1 for the observer
            obs.onProgressChanged(currentIndex + 1, cards.size());
        }
    }


    // shuffle cards and set the current index to 0
    // then notify observers
    public void shuffle() {
        Collections.shuffle(cards);
        currentIndex = 0;
        notifyObservers();
    }

    // move to the next card, notify observers of the updated current index
    public void nextCard() {
        if (currentIndex < cards.size() - 1) {
            currentIndex++;
            notifyObservers();
        }
    }

    // getters
    public Flashcard getCurrentCard() {
        return cards.get(currentIndex);
    }

    // returns the current 0-based index within the deck
    public int getCurrentIndex() {
        return currentIndex;
    }

    // reset current index to start of deck and notify observers
    public void reset() {
        currentIndex = 0;
        notifyObservers();
    }

    public List<Flashcard> getCards() {
        return cards;
    }
}