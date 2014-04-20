package ipsen1.quarto.form.bord;

import javax.swing.*;
import java.awt.*;

public class VlakButton extends JButton {
    private static final ImageIcon VAKJE_ICOON = new ImageIcon("src/main/resources/Vakje.png");

    private int x = 0, y = 0;
    private final int width = 120, height = 120;

    public VlakButton(int x, int y) {
        this.x = x;
        this.y = y;

        setPreferredSize(new Dimension(width, height));
        setSize(new Dimension(width, height));
        setStyle();
    }

    private void setStyle() {
        // Haalt de stijl van de JButton weg zodat alleen het rondje over blijft.
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);
        setContentAreaFilled(false);

        setBounds(50, 0, width, height);
        setIcon(VAKJE_ICOON);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
