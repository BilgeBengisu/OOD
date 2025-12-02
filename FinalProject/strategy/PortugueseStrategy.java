package strategy;

import loader.CSVLoader;
import model.Deck;
import factory.*;
import model.Language;
import ui.ColorTheme;
import java.awt.Color;

/**
 * PortugueseStrategy.java
 * Concrete strategy for Portuguese language flashcards.
 * 
 * Implements the LanguageSelectionStrategy for Portuguese language learning.
 * Loads Portuguese phrases and applies flag-inspired color theme
 * (yellow, green, white).
 * 
 * @author Bilge Akyol
 */
public class PortugueseStrategy implements LanguageSelectionStrategy {
    // loads a deck of Portuguese flashcards with the Simple Factory pattern.
    @Override
    public DeckFactory getDeckFactory() {
        return new PortugueseDeckFactory();
    }

    // returns the Brazilian flag-inspired color theme.
    @Override
    public ColorTheme getColorTheme(){
        return new ColorTheme(
            new Color(255, 223, 0),  // background yellow
            new Color(0, 155, 58), // button green
            Color.WHITE // text
        );
    }
}