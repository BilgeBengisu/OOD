package ui;

import strategy.*;
import service.SessionController;
import ui.helpers.*;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * FlashcardUI.java
 * Swing-based graphical user interface for the flashcard learning application.
 * 
 * It provides:
 * - Language selection menu
 * - Flashcard display and navigation
 * - Theme customization based on selected language
 * - Interactive show/hide answer functionality
 * - Progress display (card index / total cards)
 * 
 * The UI uses the Strategy pattern for language-specific themes, SessionManager (Singleton Pattern) for flashcard states and DeckObserver for progress changes.
 * 
 * @author Bilge Akyol
 */
/**
 * FlashcardUI - main UI runner
 * Slimmed down to compose the UI pieces (ScreenManager, ThemeManager, SessionController)
 * and expose the language menu. The heavy lifting (views, themes, session flow)
 * the views, theme, and session flow is delegated to the helper classes in helpers folder and is connected to the rest by SessionController
 *
 * The complete UI experience provides:
 * - Language selection menu
 * - Flashcard display and navigation
 * - Theme customization based on selected language
 * - Interactive show/hide answer functionality
 * - Progress display (card index / total cards)
 * 
 * @author Bilge Akyol
*/
public class FlashcardUI {
    private JFrame frame;
    private ScreenManager screenManager;
    private ThemeManager themeManager;
    private SessionController sessionController;

    public void start() {
        frame = new JFrame("Language Phrases Flashcards");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);

        // create managers
        screenManager = new ScreenManager(frame);
        themeManager = new ThemeManager();
        
        // map of language labels -> strategies (keeps addition centralized here)
        Map<String, LanguageSelectionStrategy> languages = new LinkedHashMap<>();
        languages.put("Türkçe 🇹🇷", new TurkishStrategy());
        languages.put("Português 🇧🇷", new PortugueseStrategy());
        languages.put("Italiano 🇮🇹", new ItalianStrategy());

        // callback to show the language menu again (used by SessionController when returning from a session)
        Runnable showMenu = () -> screenManager.showLanguageMenu(languages, strategy -> {
            sessionController.startSession(strategy);
        });

        // create session controller with the callback
        sessionController = new SessionController(themeManager, screenManager, showMenu);

        // show the menu; when a language is picked start the session
        showMenu.run();

        frame.setVisible(true);
    }
}