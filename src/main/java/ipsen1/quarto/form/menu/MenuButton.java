package ipsen1.quarto.form.menu;

import ipsen1.quarto.util.FontOpenSans;

import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.*;

public class MenuButton extends JButton {
    public static final Dimension HOOFDMENU_DIMENSION = new Dimension(180, 96),
                                  INGAME_MENU_DIMENSION = new Dimension(90, 60),
                                  DEFAULT_DIMENSION = HOOFDMENU_DIMENSION;

    public MenuButton() {
        super();
        setAppearance();
    }

    public MenuButton(Icon icon) {
        super(icon);
        setAppearance();
    }

    public MenuButton(Icon icon, Dimension dimension) {
        super(icon);
        setAppearance();
        setPreferredSize(dimension);
    }

    public MenuButton(String text) {
        super(text);
        setAppearance();
    }

    public MenuButton(String text, Dimension dimension) {
        super(text);
        setAppearance();
        setPreferredSize(dimension);
    }

    private void setAppearance() {
        setBorder(null);
        setOpaque(true);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setFont(FontOpenSans.create(32).deriveFont(Font.BOLD));
        setPreferredSize(DEFAULT_DIMENSION);
    }
}
