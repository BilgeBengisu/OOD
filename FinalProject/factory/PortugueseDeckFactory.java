package factory;
import loader.CSVLoader;
import model.*;

public class PortugueseDeckFactory implements DeckFactory {
    @Override
    public Deck createDeck() {
        return CSVLoader.loadDeck("phrases/portuguese_phrases.csv", Language.PORTUGUESE);
    }
}