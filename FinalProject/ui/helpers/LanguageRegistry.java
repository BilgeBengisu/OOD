package ui.helpers;

import strategy.*;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Responsible for managing available languages and registering them for the application's use
 * Open/Closed: Add new languages without modifying this class
 * @author Bilge Akyol
 */
public class LanguageRegistry {
    private static final Map<String, LanguageSelectionStrategy> strategies = new LinkedHashMap<>();

    static {
        strategies.put("Türkçe 🇹🇷", new TurkishStrategy());
        strategies.put("Português 🇧🇷", new PortugueseStrategy());
        strategies.put("Italiano 🇮🇹", new ItalianStrategy());
        // NEW LANGUAGES CAN BE ADDED HERE - Open/Closed Principle
    }

    public Map<String, LanguageSelectionStrategy> getAvailableLanguages() {
        return strategies;
    }
}
