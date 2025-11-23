package strategy;

import loader.CSVLoader;
import model.Deck;
import model.Language;

public class PortugueseStrategy implements LanguageSelectionStrategy {
    @Override
    public Deck loadDeck(){
        return CSVLoader.loadDeck("phrases/portuguese_phrases.csv", Language.PORTUGUESE);
    }
}