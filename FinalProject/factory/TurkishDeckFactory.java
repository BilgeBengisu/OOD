package factory;
import loader.CSVLoader;
import model.*;

public class TurkishDeckFactory implements DeckFactory {
    @Override
    public Deck createDeck() {
        return CSVLoader.loadDeck("phrases/turkish_phrases.csv", Language.TURKISH);
    }
}