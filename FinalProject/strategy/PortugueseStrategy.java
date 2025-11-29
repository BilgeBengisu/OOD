package strategy;

import loader.CSVLoader;
import model.Deck;
import model.Language;
import ui.ColorTheme;
import java.awt.Color;


/*
    @author: Bilge Akyol 
**/

public class PortugueseStrategy implements LanguageSelectionStrategy {
    @Override
    public Deck loadDeck(){
        return CSVLoader.loadDeck("phrases/portuguese_phrases.csv", Language.PORTUGUESE);
    }

    @Override
    public ColorTheme getColorTheme(){
        return new ColorTheme(
            new Color(255, 223, 0),  // background yellow
            new Color(0, 155, 58), // button green
            Color.WHITE // text
        );
    }
}