package ipsen1.quarto.form.pionnen;

import ipsen1.quarto.business.Pion;

import javax.swing.*;
import java.awt.Image;

public class PionButton extends JButton {
    private Pion pion;
    private final int width = 160, height = 170;

    public PionButton(Pion pion) {
        this.pion = pion;
        setAppearance();

        if(pion == null)
            drawEmpty();
        else
            drawImage();
    }

    public PionButton() {
        super();
        setAppearance();
    }

    private void setAppearance() {
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.BOTTOM);
        setBounds(192 / 2 , -32, width, height);
    }

    private void drawEmpty() {
    }

    private void drawImage() {
        ImageIcon pionIcoon = pion.getImageIcon();

        final int SCALE_FACTOR = 8;
        pionIcoon = new ImageIcon(pionIcoon.getImage().getScaledInstance(320 / SCALE_FACTOR, 540 / SCALE_FACTOR, Image.SCALE_SMOOTH));
        setIcon(pionIcoon);
    }

    public void setPion(Pion pion) {
        this.pion = pion;
        drawImage();
    }

    public Pion getPion() {
        return pion;
    }
}
