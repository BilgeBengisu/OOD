package factory;
import loader.CSVLoader;
import model.*;

public class PortugueseDeckFactory implements DeckFactory {
    @Override
    public Deck createDeck() {
        Deck deck = new Deck();
        for (Flashcard card : CSVLoader.loadFlashcards("phrases/portuguese_phrases.csv", Language.PORTUGUESE)) {
            deck.addCard(card);
        }
        return deck;
    }
}