package model;

import java.util.List;
import java.util.ArrayList;

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