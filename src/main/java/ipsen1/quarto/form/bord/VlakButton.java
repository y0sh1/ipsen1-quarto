package ipsen1.quarto.form.bord;

import javax.swing.*;

public class VlakButton extends JButton {
    private static final ImageIcon VAKJE_ICOON = new ImageIcon("src/main/resources/Vakje.png");

    private int x = 0, y = 0;
    private final int width = 192, height = 192;

    public VlakButton(int x, int y) {
        this.x = x;
        this.y = y;

        setStyle();
    }

    private void setStyle() {
        // Haalt de stijl van de JButton weg zodat alleen het rondje over blijft.
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);

        setBounds(width / 2 - 114 / 2, 0, width, height);
        setIcon(VAKJE_ICOON);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}