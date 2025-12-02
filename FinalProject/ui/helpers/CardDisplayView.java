package ui.helpers;

import model.Flashcard;
import javax.swing.*;
import java.awt.*;

/**
 * CardDisplayView
 * Moved the card display logic from FlashcardUI to here to follow Open/Closed principle.
 * Responsible for creating the card panel and exposing components to controllers.
 */
public class CardDisplayView {
    private final JPanel cardPanel;
    private final JPanel buttonPanel;
    private final JLabel phraseLabel;
    private final JLabel progressLabel;
    private final JButton showAnswerButton;
    private final JButton nextButton;
    private final JButton languageMenuButton;

    public CardDisplayView() {
        cardPanel = new JPanel(new BorderLayout(20, 20));

        phraseLabel = new JLabel("", SwingConstants.CENTER);
        phraseLabel.setFont(new Font("Arial", Font.BOLD, 22));

        progressLabel = new JLabel("Card 1 / 0", SwingConstants.CENTER);
        progressLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        showAnswerButton = new JButton("Show Answer");
        nextButton = new JButton("Next");
        languageMenuButton = new JButton("Return to Language Menu");

        buttonPanel = new JPanel();
        buttonPanel.add(showAnswerButton);
        buttonPanel.add(nextButton);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(languageMenuButton, BorderLayout.WEST);
        topPanel.add(progressLabel, BorderLayout.CENTER);

        cardPanel.add(phraseLabel, BorderLayout.CENTER);
        cardPanel.add(buttonPanel, BorderLayout.SOUTH);
        cardPanel.add(topPanel, BorderLayout.PAGE_START);
    }

    public JPanel getPanel() { return cardPanel; }
    public JButton getShowAnswerButton() { return showAnswerButton; }
    public JButton getNextButton() { return nextButton; }
    public JButton getLanguageMenuButton() { return languageMenuButton; }
    public JLabel getPhraseLabel() { return phraseLabel; }
    public JLabel getProgressLabel() { return progressLabel; }
    public JPanel getButtonPanel() { return buttonPanel; }

    /* display helpers */
    public void displayFront(Flashcard card) {
        phraseLabel.setText("<html><center>" + card.getFront() + "</center></html>");
    }

    public void displayBack(Flashcard card) {
        phraseLabel.setText("<html><center>" + card.getBack() + "</center></html>");
    }

    public void updateProgress(int current, int total) {
        progressLabel.setText("Card " + current + " / " + total);
    }
}