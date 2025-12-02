package strategy;

import loader.CSVLoader;
import model.Deck;
import factory.DeckFactory;
import model.Language;
import ui.ColorTheme;
import java.awt.Color;

/**
 * ItalianStrategy.java
 * Concrete strategy for Italian language flashcards.
 * 
 * Implements the LanguageSelectionStrategy for Italian language learning.
 * Loads Italian phrases and applies flag-inspired color theme
 * (green, red, white).
 * 
 * @author Bilge Akyol
 */
public class ItalianStrategy implements LanguageSelectionStrategy {
    
    // loads a deck of Italian flashcards with the Simple Factory pattern.
    @Override
    public Deck loadDeck() {
        return DeckFactory.createDeck(Language.ITALIAN);
    }

    // returns the Italian flag-inspired color theme. Background: green, Buttons: red, Text: white
    @Override
    public ColorTheme getColorTheme(){
        return new ColorTheme(
            new Color(0, 146, 70), // background green
            Color.RED, // button
            Color.WHITE // text
        );
    }
}