package ui;

import model.*;
import strategy.*;
import service.SessionManager;
import observer.DeckObserver;
import ui.ColorTheme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

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
public class FlashcardUI implements DeckObserver {
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel cardPanel;
    private JPanel buttonPanel;
    private JLabel phraseLabel;
    private JLabel progressLabel;  // shows current card index / total
    private JButton showAnswerButton;
    private JButton nextButton;
    private JButton languageMenuButton;
    private LanguageSelectionStrategy currentStrategy; // To apply color theme

    private SessionManager sessionManager = SessionManager.getInstance();

    // starts Java Swing session
    // creates the main frame and displays the language selection menu.
    public void start() {
        frame = new JFrame("Language Phrases Flashcards");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the application
        frame.setSize(500, 400);

        frame.setLocationRelativeTo(null);

        // show initial view for the user which is to choose language to practice
        showLanguageMenu();

        frame.setVisible(true);
    }

    /**
     * Observer trigger: called when deck progress changes
     * Updates the progress label to reflect the current card index.
     */
    @Override
    public void onProgressChanged(int currentIndex, int totalCards) {
        SwingUtilities.invokeLater(() -> {
            if (progressLabel != null) {
                progressLabel.setText("Card " + currentIndex + " / " + totalCards);
            }
        });
    }

    // shows languages to practice for the user to choose
    // adds action listeners to start session based on user's choice
    // shows buttons for Turkish, Portuguese, and Italian languages.
    private void showLanguageMenu() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 1));

        JLabel title = new JLabel("Choose a language to practice: ", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        mainPanel.add(title);

        // Language Choice Buttons
        JButton turkishBtn = new JButton("<html><center>Türkçe 🇹🇷</center></html>");
        JButton portugueseBtn = new JButton("<html><center>Português 🇧🇷</center></html>");
        JButton italianBtn = new JButton("<html><center>Italiano 🇮🇹</center></html>");

        // Set larger font for better emoji rendering
        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        turkishBtn.setFont(buttonFont);
        portugueseBtn.setFont(buttonFont);
        italianBtn.setFont(buttonFont);

        // add action listeners to initiate the corresponding language strategy
        turkishBtn.addActionListener(e -> startSession(new TurkishStrategy()));
        portugueseBtn.addActionListener(e -> startSession(new PortugueseStrategy()));
        italianBtn.addActionListener(e -> startSession(new ItalianStrategy()));

        // add buttons to the panel
        mainPanel.add(turkishBtn);
        mainPanel.add(portugueseBtn);
        mainPanel.add(italianBtn);

        // add main panel to the frame
        frame.setContentPane(mainPanel);
        // update frame display
        frame.revalidate();
    }

    // start session for practice after a language is selected
    // loads the deck, validates it, and displays the first flashcard.
    // selected strategy gets stored for theme customization throughout the session
    private void startSession(LanguageSelectionStrategy strategy) {
        Deck deck = strategy.loadDeck();
        this.currentStrategy = strategy; // save the selected language strategy for color theme

        // error catching
        if(deck.getCards().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No cards found for this language");
            showLanguageMenu();
            return;
        }

        // use SessionManager to manage session state
        sessionManager.setCurrentDeck(deck);
        
        // subscribe this UI as an observer to deck progress changes
        deck.addObserver(this);

        showFlashcardScreen();
    }

    // show flashcard
    // sets up the UI with the phrase display area, action buttons, and applies
    // the selected language's color theme
    // loads the first card upon initialization
    private void showFlashcardScreen() {
        this.cardPanel = new JPanel();
        cardPanel.setLayout(new BorderLayout(20,20));

        phraseLabel = new JLabel("", SwingConstants.CENTER);
        phraseLabel.setFont(new Font("Arial", Font.BOLD, 22));

        progressLabel = new JLabel("Card 1 / " + sessionManager.getTotalCards(), SwingConstants.CENTER);
        progressLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        showAnswerButton = new JButton("Show Answer");
        nextButton = new JButton("Next");
        // return to language menu
        languageMenuButton = new JButton("Return to Language Menu");

        // show answer if the user clicks the button
        showAnswerButton.addActionListener(this::handleShowAnswer);
        nextButton.addActionListener(this::handleNextCard);
        languageMenuButton.addActionListener(e -> showLanguageMenu());

        // add buttons to a panel
        buttonPanel = new JPanel();
        buttonPanel.add(showAnswerButton);
        buttonPanel.add(nextButton);

        // create a top panel with progress label
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(languageMenuButton, BorderLayout.WEST);
        topPanel.add(progressLabel, BorderLayout.CENTER);

        // add phrase and buttons to the interface
        cardPanel.add(phraseLabel, BorderLayout.CENTER);
        cardPanel.add(buttonPanel, BorderLayout.SOUTH);
        cardPanel.add(topPanel, BorderLayout.PAGE_START);

        frame.setContentPane(cardPanel);

        // apply language flag color theme
        applyLanguageTheme(currentStrategy);

        frame.revalidate();

        loadCard(); // load the first card in the shuffled deck
    }

    // apply language Theme
    // customize background, button, and text colors based on the selected language's strategy
    private void applyLanguageTheme(LanguageSelectionStrategy strategy) {
        ColorTheme theme = strategy.getColorTheme();
        Color background = theme.getBackground();
        Color buttons = theme.getButtons();
        Color text = theme.getText();

        // Update main background
        cardPanel.setBackground(background);

        // apply custom text color to all labels
        phraseLabel.setForeground(text);
        if (progressLabel != null) {
            progressLabel.setForeground(text);
        }

        // Update buttons
        for (Component c : buttonPanel.getComponents()) {
            if (c instanceof JButton jb) {
                jb.setOpaque(true); // make sure the changes will be visible
                jb.setContentAreaFilled(true); // ensure the button paints its background
                jb.setBorderPainted(false);   // remove border so background color looks consistent
                jb.setFocusPainted(false);
                jb.setBackground(buttons);
                jb.setForeground(text);
            }
        }


        buttonPanel.setBackground(background);
        
        // main menu button
        languageMenuButton.setOpaque(true);
        languageMenuButton.setBackground(background);
        languageMenuButton.setForeground(text);
        languageMenuButton.setContentAreaFilled(true);
        languageMenuButton.setBorderPainted(false);
        languageMenuButton.setFocusPainted(false);
        languageMenuButton.setBackground(buttons);

        // refresh UI
        cardPanel.revalidate();
        cardPanel.repaint();
    }


    // load the front of the flashcard (phrase)
    private void loadCard() {
        Flashcard card = sessionManager.getCurrentCard();
        if (card == null) return;
        
        sessionManager.toggleShowingAnswer(false); // reset the answer display state

        phraseLabel.setText("<html><center>" + card.getFront() + "</center></html>");
        showAnswerButton.setEnabled(true);
    }

    // show the back of the card (translation)
    private void handleShowAnswer(ActionEvent event) {
        Flashcard card = sessionManager.getCurrentCard();
        if (card == null) return;
        
        phraseLabel.setText("<html><center>" + card.getBack() + "</center></html>");
        sessionManager.toggleShowingAnswer(true); // handle the show answer button action
    }

    // next card logic
    // advances to the next flashcard in the deck
    // shows end screen if reached the end
    private void handleNextCard(ActionEvent event) {
        if (sessionManager.getCurrentIndex() < sessionManager.getTotalCards() - 1) {
            sessionManager.nextCard();
            loadCard();
        } else {
            showEndScreen();
        }
    }

    // display the end of deck view
    private void showEndScreen() {
        JPanel endPanel = new JPanel(new BorderLayout());
        JLabel endLabel = new JLabel("End of deck! Great job!", SwingConstants.CENTER);
        endLabel.setFont(new Font("Arial", Font.BOLD, 22));

        JButton restartBtn = new JButton("Back to Menu");
        restartBtn.addActionListener(e -> showLanguageMenu());

        // end or restart
        endPanel.add(endLabel, BorderLayout.CENTER);
        endPanel.add(restartBtn, BorderLayout.SOUTH);

        frame.setContentPane(endPanel);
        frame.revalidate();
    }
}