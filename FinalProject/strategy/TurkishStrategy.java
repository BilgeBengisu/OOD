package strategy;

import loader.CSVLoader;
import model.Deck;
import model.Language;
import ui.ColorTheme;
import java.awt.Color;


/*
    @author: Bilge Akyol 
**/

public class TurkishStrategy implements LanguageSelectionStrategy {
    @Override
    public Deck loadDeck() {
        return CSVLoader.loadDeck("phrases/turkish_phrases.csv", Language.TURKISH);
    }

    @Override
    public ColorTheme getColorTheme(){
        return new ColorTheme(
            Color.WHITE, // background
            Color.RED, // button
            Color.BLACK // text
        );
    }
}