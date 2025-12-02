package ui.helpers;

import ui.helpers.CardDisplayView;
import ui.ColorTheme;
import javax.swing.*;
import java.awt.*;

/**
 * ThemeManager.java
 * Single Responsibility pattern
 * breaking FlashcardUI's functionalities to helper functions to protect both OCP and SRP
 * this file handles the application of the theme
 * with applyTheme() and styleButton() functions
 * 
 * @author Bilge Akyol
 */


public class ThemeManager {
    public void applyTheme(CardDisplayView view, ColorTheme theme) {
        if (view == null || theme == null) return;

        Color background = theme.getBackground();
        Color buttons = theme.getButtons();
        Color text = theme.getText();

        JPanel cardPanel = view.getPanel();
        if (cardPanel != null) {
            cardPanel.setBackground(background);
        }

        JLabel phrase = view.getPhraseLabel();
        if (phrase != null) phrase.setForeground(text);

        JLabel progress = view.getProgressLabel();
        if (progress != null) progress.setForeground(text);

        JPanel buttonPanel = view.getButtonPanel();
        if (buttonPanel != null) buttonPanel.setBackground(background);

        JButton[] btns = new JButton[] { view.getShowAnswerButton(), view.getNextButton(), view.getLanguageMenuButton() };
        for (JButton b : btns) {
            if (b == null) continue;
            styleButton(b, buttons, text);
        }

        // repaint to ensure visual update
        if (cardPanel != null) {
            cardPanel.revalidate();
            cardPanel.repaint();
        }
    }

    public void styleButton(JButton b, Color bg, Color fg) {
        b.setOpaque(true);
        b.setContentAreaFilled(true);
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setBackground(bg);
        b.setForeground(fg);
    }
}