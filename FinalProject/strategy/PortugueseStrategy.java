package strategy;

import loader.CSVLoader;
import model.Deck;
import model.Language;
import ui.ColorTheme;

/*
    @author: Bilge Akyol 
**/

public class PortugueseStrategy implements LanguageSelectionStrategy {
    @Override
    public Deck loadDeck(){
        return CSVLoader.loadDeck("phrases/portuguese_phrases.csv", Language.PORTUGUESE);
    }

    @Override
    public void getColorTheme(){
        
    }
}