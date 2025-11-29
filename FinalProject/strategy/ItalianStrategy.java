package strategy;

import loader.CSVLoader;
import model.Deck;
import model.Language;
import ui.ColorTheme;

/*
    @author: Bilge Akyol 
**/

public class ItalianStrategy implements LanguageSelectionStrategy {
    
    @Override
    public Deck loadDeck() {
        return CSVLoader.loadDeck("phrases/italian_phrases.csv", Language.ITALIAN);
    }

    @Override
    public void getColorTheme(){
        
    }
}