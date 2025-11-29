package strategy;

import model.Deck;
import ui.ColorTheme;

/*
    @author: Bilge Akyol 
**/

public interface LanguageSelectionStrategy {
    Deck loadDeck();
    ColorTheme getColorTheme();
}