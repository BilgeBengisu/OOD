package ui.helpers;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.function.Consumer;
import strategy.LanguageSelectionStrategy;

/**
 * ScreenManager
 * Single Responsibility Pattern - breaking down UI responsibilities
 * Responsible for switching the main frame content between screens (menu, card, end)
 */
public class ScreenManager {
    private final JFrame frame;

    public ScreenManager(JFrame frame) {
        this.frame = frame;
    }

    /**
     * show a language selection menu
     * the labels(language enums) map to strategies
     * when a user selects one, the onSelect consumer is invoked with the corresponding strategy
     */
    public void showLanguageMenu(Map<String, LanguageSelectionStrategy> languages, Consumer<LanguageSelectionStrategy> onSelect) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(Math.max(3, languages.size() + 1), 1));

        JLabel title = new JLabel("Choose a language to practice: ", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        mainPanel.add(title);

        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        for (Map.Entry<String, LanguageSelectionStrategy> e : languages.entrySet()) {
            JButton btn = new JButton("<html><center>" + e.getKey() + "</center></html>");
            btn.setFont(buttonFont);
            btn.addActionListener(ev -> onSelect.accept(e.getValue()));
            mainPanel.add(btn);
        }

        frame.setContentPane(mainPanel);
        frame.revalidate();
    }

    /**
     * set panel as the content of the main frame
     */
    public void showPanel(JPanel panel) {
        frame.setContentPane(panel);
        frame.revalidate();
    }

    /**
     * show end screen with restart return to menu button
     */
    public void showEndScreen(Runnable onBackToMenu) {
        JPanel endPanel = new JPanel(new BorderLayout());
        JLabel endLabel = new JLabel("End of deck! Great job!", SwingConstants.CENTER);
        endLabel.setFont(new Font("Arial", Font.BOLD, 22));

        JButton restartBtn = new JButton("Back to Menu");
        restartBtn.addActionListener(e -> onBackToMenu.run());

        endPanel.add(endLabel, BorderLayout.CENTER);
        endPanel.add(restartBtn, BorderLayout.SOUTH);

        showPanel(endPanel);
    }
}
