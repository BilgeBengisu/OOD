package factory;
import loader.CSVLoader;
import model.*;

public class TurkishDeckFactory implements DeckFactory {
    @Override
    public Deck createDeck() {
        Deck deck = new Deck();
        for (Flashcard card : CSVLoader.loadFlashcards("phrases/turkish_phrases.csv", Language.TURKISH)) {
            deck.addCard(card);
        }
        return deck;
    }
}