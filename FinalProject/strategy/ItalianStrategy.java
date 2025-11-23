package strategy;

import loader.CSVLoader;
import model.Deck;
import model.Language;

public class ItalianStrategy implements LanguageSelectionStrategy {
    
    @Override
    public Deck loadDeck() {
        return CSVLoader.loadDeck("phrases/italian_phrases.csv", Language.ITALIAN);
    }
}