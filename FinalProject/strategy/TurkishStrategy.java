package strategy;

import loader.CSVLoader;
import model.Deck;
import model.Language;
import ui.ColorTheme;
import java.awt.Color;

/**
 * TurkishStrategy.java
 * Concrete strategy for Turkish language flashcards.
 * 
 * Implements the LanguageSelectionStrategy for Turkish language learning.
 * Loads Turkish phrases and applies flag-inspired color theme
 * (white, red, black).
 * 
 * @author Bilge Akyol
 */
public class TurkishStrategy implements LanguageSelectionStrategy {
    // loads a deck of Turkish flashcards with the Simple Factory pattern.
    @Override
    public Deck loadDeck() {
        return loader.DeckFactory.createDeck(Language.TURKISH);

    // returns the Turkish flag-inspired color theme.
    @Override
    public ColorTheme getColorTheme(){
        return new ColorTheme(
            Color.WHITE, // background
            Color.RED, // button
            Color.BLACK // text
        );
    }
}