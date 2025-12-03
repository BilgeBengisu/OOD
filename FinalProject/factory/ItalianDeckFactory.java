package factory;

import loader.CSVLoader;
import model.*;

public class ItalianDeckFactory implements DeckFactory {
    @Override
    public Deck createDeck() {
        Deck deck = new Deck();
        for (Flashcard card : CSVLoader.loadFlashcards("phrases/italian_phrases.csv", Language.ITALIAN)) {
            deck.addCard(card);
        }
        return deck;
    }
}