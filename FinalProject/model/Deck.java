package model;

import java.util.List;
import java.util.ArrayList;

/**
* Deck.java
* Represents a deck of flashcards. The deck gets constructed by the CSV Loader class when a language csv file is loaded in.
* @author: Bilge Akyol 
**/

public class Deck {
    // flashcard deck to display multiple flashcards to practice phrases
    private List<Flashcard> cards = new ArrayList<>();

    public void addCard(Flashcard card) {
        cards.add(card);
    }

    // getter
    public List<Flashcard> getCards() {
        return cards;
    }
}