package strategy;

import loader.CSVLoader;
import model.Deck;
import model.Language;
import ui.ColorTheme;
import java.awt.Color;


/*
    @author: Bilge Akyol 
**/

public class ItalianStrategy implements LanguageSelectionStrategy {
    
    @Override
    public Deck loadDeck() {
        return CSVLoader.loadDeck("phrases/italian_phrases.csv", Language.ITALIAN);
    }

    @Override
    public ColorTheme getColorTheme(){
        return new ColorTheme(
            new Color(0, 146, 70), // background green
            Color.RED, // button
            Color.WHITE // text
        );
    }
}