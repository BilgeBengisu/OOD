package ui;
import java.awt.Color;

/**
 * ColorTheme.java
 * Encapsulates color scheme for language-specific UI customization.
 * 
 * Stores and provides access to the three primary colors used in the flashcard UI:
 * background, buttons, and text. Each language strategy provides its own theme
 * matching the country's flag colors.
 * 
 * @author Bilge Akyol
 */
public class ColorTheme {
    private Color background;
    private Color buttons;
    private Color text;

    // constructs a ColorTheme with the specified colors for background, button, and the text
    public ColorTheme(Color background, Color buttons, Color text) {
        this.background = background;
        this.buttons = buttons;
        this.text = text;
    }

    // gets the background color
    public Color getBackground() { return background; }

    // gets the button color
    public Color getButtons() { return buttons; }

    // gets the text color
    public Color getText() { return text; }
}