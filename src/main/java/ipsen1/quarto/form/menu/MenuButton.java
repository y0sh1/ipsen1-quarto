package ipsen1.quarto.form.menu;

import ipsen1.quarto.util.FontOpenSans;

import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.*;

public class MenuButton extends JButton {
    public MenuButton(Icon icon) {
        super(icon);
        setAppearance();
    }

    public MenuButton(String text) {
        super(text);
        setAppearance();
    }

    public MenuButton() {
        super();
        setAppearance();
    }

    private void setAppearance() {
        setBorder(null);
        setOpaque(true);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setFont(FontOpenSans.create(24).deriveFont(Font.BOLD));
    }
}
