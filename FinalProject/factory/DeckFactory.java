package factory;

import model.Deck;
import model.Language;
import loader.CSVLoader;

/**
 * Purpose of the Simple Factory pattern is to map languages to file paths
 * in order to create Deck instances
 * 
 * This is the interface for specific language factories
 * 
 * @author Bilge Akyol
 */

public interface DeckFactory {
    Deck createDeck();
} 