package factory;

import loader.CSVLoader;
import model.*;

public class ItalianDeckFactory implements DeckFactory {
    @Override
    public Deck createDeck() {
        return CSVLoader.loadDeck("phrases/italian_phrases.csv", Language.ITALIAN);
    }
}