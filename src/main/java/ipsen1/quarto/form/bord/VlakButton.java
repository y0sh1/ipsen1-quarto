package ipsen1.quarto.form.bord;

import javax.swing.*;

public class VlakButton extends JButton {
    private static final ImageIcon VAKJE_ICOON = new ImageIcon("src/main/resources/Vakje.png");

    private int x = 0, y = 0;

    public VlakButton(int x, int y) {
        this.x = x;
        this.y = y;

        setStyle();
    }

    private void setStyle() {
        // Haalt de stijl van de JButton weg zodat alleen het rondje over blijft.
        setBorderPainted(false);
        setFocusPainted(false);

        setBounds(50, 0, 120, 79);
        setIcon(VAKJE_ICOON);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
