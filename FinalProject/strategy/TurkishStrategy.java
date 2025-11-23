package strategy;

import loader.CSVLoader;
import model.Deck;
import model.Language;

public class TurkishStrategy implements LanguageSelectionStrategy {
    @Override
    public Deck loadDeck() {
        return CSVLoader.loadDeck("phrases/turkish_phrases.csv", Language.TURKISH);
    }
}