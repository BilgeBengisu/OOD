package ui;
import java.awt.Color;

/*
    @author: Bilge Akyol 
    implementing color theme to match flag colors for each Language Strategy
**/

public class ColorTheme {
    private Color background;
    private Color buttons;
    private Color text;

    public ColorTheme(Color background, Color buttons, Color text) {
        this.background = background;
        this.buttons = buttons;
        this.text = text;
    }

    // getters
    public Color getBackground() { return background; }
    public Color getButtons() { return buttons; }
    public Color getText() { return text; }
}