package ipsen1.quarto.form.pionnen;

import ipsen1.quarto.business.Pion;

import javax.swing.*;
import java.awt.*;

public class PionLabel extends JLabel {
    private Pion pion;

    public PionLabel(Pion pion) {
        this.pion = pion;

        setHorizontalAlignment(SwingConstants.CENTER);

        setForeground(Color.WHITE);
        if(pion == null)
            drawEmpty();
        else
            drawImage();
    }

    private void drawEmpty() {
        // TODO: Zet een placeholder neer als er nog geen pion gekozen is
    }

    private void drawImage() {
        setText(null);
        ImageIcon pionIcoon = pion.getImageIcon();

        final int SCALE_FACTOR = 2;
        pionIcoon = new ImageIcon(pionIcoon.getImage()
                .getScaledInstance(320 / SCALE_FACTOR, 540 / SCALE_FACTOR, Image.SCALE_DEFAULT));

        setIcon(pionIcoon);
    }

    public void fixImage() {
        // FIXME: Dit is een vreselijke hack om te zorgen
        // dat het plaatje netjes zichtbaar wordt...
        setVisible(false);
        setVisible(true);
    }
}
