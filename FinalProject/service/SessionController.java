package service;

import model.Deck;
import model.Flashcard;
import observer.DeckObserver;
import strategy.LanguageSelectionStrategy;
import ui.helpers.*;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * SessionController.java
 * Implemented to better follow Single Responsibility
 * UI controller handling session actions
 * Wires UI events to session manager and deck
 * Updates UI views using deckObserver
 */
public class SessionController implements DeckObserver {
    private final SessionManager sessionManager = SessionManager.getInstance();
    private final ThemeManager themeManager;
    private final ScreenManager screenManager;
    private final Runnable onReturnToMenu;

    // active view for the current session
    private CardDisplayView cardView;

    public SessionController(ThemeManager themeManager, ScreenManager screenManager, Runnable onReturnToMenu) {
        this.themeManager = themeManager;
        this.screenManager = screenManager;
        this.onReturnToMenu = onReturnToMenu;
    }

    public void startSession(LanguageSelectionStrategy strategy) {
        // load deck via strategy
        Deck deck = strategy.loadDeck();
        if (deck.getCards().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No cards found for this language");
            return;
        }

        sessionManager.setCurrentDeck(deck);
        deck.addObserver(this);

        // create and wire view
        cardView = new CardDisplayView();
        themeManager.applyTheme(cardView, strategy.getColorTheme());

        // wire buttons
        cardView.getShowAnswerButton().addActionListener(this::handleShowAnswer);
        cardView.getNextButton().addActionListener(this::handleNextCard);
        cardView.getLanguageMenuButton().addActionListener(e -> showLanguageMenu());

        // show the card screen
        screenManager.showPanel(cardView.getPanel());

        // load first card
        loadCard();
    }

    private void showLanguageMenu() {
        // invoke the callback to re-show the language menu in FlashcardUI
        if (onReturnToMenu != null) {
            onReturnToMenu.run();
        }
    }

    private void loadCard() {
        Flashcard card = sessionManager.getCurrentCard();
        if (card == null) return;
        sessionManager.toggleShowingAnswer(false);
        cardView.displayFront(card);
        cardView.getShowAnswerButton().setEnabled(true);
        cardView.updateProgress(sessionManager.getCurrentIndex() + 1, sessionManager.getTotalCards());
    }

    private void handleShowAnswer(ActionEvent event) {
        Flashcard card = sessionManager.getCurrentCard();
        if (card == null) return;
        cardView.displayBack(card);
        sessionManager.toggleShowingAnswer(true);
    }

    private void handleNextCard(ActionEvent event) {
        if (sessionManager.getCurrentIndex() < sessionManager.getTotalCards() - 1) {
            sessionManager.nextCard();
            loadCard();
        } else {
            screenManager.showEndScreen(() -> showLanguageMenu());
        }
    }

    // Observer
    @Override
    public void onProgressChanged(int currentIndex, int totalCards) {
        // update view progress
        if (cardView != null) {
            SwingUtilities.invokeLater(() -> cardView.updateProgress(currentIndex, totalCards));
        }
    }
}
