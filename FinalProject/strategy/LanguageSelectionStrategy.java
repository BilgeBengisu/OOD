package strategy;

import model.Deck;
import ui.ColorTheme;

/**
 * LanguageSelectionStrategy.java
 * Interface for language-specific strategy pattern implementation.
 * 
 * Follows the Strategy design pattern.
 * 
 * @author Bilge Akyol
 */
public interface LanguageSelectionStrategy {
    // Loads and returns a deck of flashcards for the language strategy. 
    // @return A Deck object populated with language-specific flashcards
    Deck loadDeck();

    // Returns the color theme appropriate for the implemented language.
    // @return A ColorTheme object with background, button, and text colors
    ColorTheme getColorTheme();
}