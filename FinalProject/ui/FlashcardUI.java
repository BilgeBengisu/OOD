package ui;

import model.Deck;
import model.Flashcard;
import strategy.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

/*
    @author: Bilge Akyol 
**/

public class FlashcardUI {
    private JFrame frame;
    private JPanel mainPanel;
    private JLabel phraseLabel;
    private JButton showAnswerButton;
    private JButton nextButton;
    private JButton languageMenuButton;

    private List<Flashcard> cards;
    private int currentIndex = 0;
    private boolean showingAnswer = false;

    public void start() {
        frame = new JFrame("Language Phrases Flashcards");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        frame.setLocationRelativeTo(null);

        showLanguageMenu();

        frame.setVisible(true);
    }

    // show language to practice
    private void showLanguageMenu() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 1));

        JLabel title = new JLabel("Choose a language to practice: ", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        mainPanel.add(title);

        JButton turkishBtn = new JButton("Turkish");
        JButton portugueseBtn = new JButton("Portuguese");
        JButton italianBtn = new JButton("Italian");

        // add action listeners to initiate the corresponding language strategy
        turkishBtn.addActionListener(e -> startSession(new TurkishStrategy()));
        portugueseBtn.addActionListener(e -> startSession(new PortugueseStrategy()));
        italianBtn.addActionListener(e -> startSession(new ItalianStrategy()));

        mainPanel.add(turkishBtn);
        mainPanel.add(portugueseBtn);
        mainPanel.add(italianBtn);

        frame.setContentPane(mainPanel);
        frame.revalidate();
    }

    // start session for practice after a language is selected
    private void startSession(LanguageSelectionStrategy strategy) {
        Deck deck = strategy.loadDeck();
        this.cards = deck.getCards();

        // error catching
        if(cards.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No cards found for this language");
            showLanguageMenu();
            return;
        }

        currentIndex = 0;
        showingAnswer = false;

        showFlashcardScreen();
    }

    // show flashcard
    private void showFlashcardScreen() {
        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(new BorderLayout(20,20));

        phraseLabel = new JLabel("", SwingConstants.CENTER);
        phraseLabel.setFont(new Font("Arial", Font.BOLD, 22));

        showAnswerButton = new JButton("Show Answer");
        nextButton = new JButton("Next");
        // return to language menu
        languageMenuButton = new JButton("Return to Language Menu");

        // show answer if the user clicks the button
        showAnswerButton.addActionListener(this::handleShowAnswer);
        nextButton.addActionListener(this::handleNextCard);
        languageMenuButton.addActionListener(e -> showLanguageMenu());

        // add buttons to a panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(showAnswerButton);
        buttonPanel.add(nextButton);

        // add phrase and buttons to the interface
        cardPanel.add(phraseLabel, BorderLayout.CENTER);
        cardPanel.add(buttonPanel, BorderLayout.SOUTH);
        cardPanel.add(languageMenuButton, BorderLayout.PAGE_START);

        frame.setContentPane(cardPanel);
        frame.revalidate();

        loadCard();
    }

    // load flashcard
    private void loadCard() {
        Flashcard card = cards.get(currentIndex);
        showingAnswer = false;

        phraseLabel.setText("<html><center>" + card.getFront() + "</center></html>");
        showAnswerButton.setEnabled(true);
    }

    private void handleShowAnswer(ActionEvent event) {
        Flashcard card = cards.get(currentIndex);
        phraseLabel.setText("<html><center>" + card.getBack() + "</center></html>");
        showingAnswer = true;
    }

    // next card logic
    private void handleNextCard(ActionEvent event) {
        if (currentIndex < cards.size() - 1) {
            currentIndex++;
            loadCard();
        } else {
            showEndScreen();
        }
    }

    private void showEndScreen() {
        JPanel endPanel = new JPanel(new BorderLayout());
        JLabel endLabel = new JLabel("End of deck! Great job!", SwingConstants.CENTER);
        endLabel.setFont(new Font("Arial", Font.BOLD, 22));

        JButton restartBtn = new JButton("Back to Menu");
        restartBtn.addActionListener(e -> showLanguageMenu());

        endPanel.add(endLabel, BorderLayout.CENTER);
        endPanel.add(restartBtn, BorderLayout.SOUTH);

        frame.setContentPane(endPanel);
        frame.revalidate();
    }
}