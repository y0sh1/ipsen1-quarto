package ipsen1.quarto.form.pionnen;

import ipsen1.quarto.business.Pion;

import javax.swing.*;
import java.awt.*;

public class PionLabel extends JLabel {
    private Pion pion;

    public PionLabel(Pion pion) {
        this.pion = pion;

        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.BOTTOM);
        setBounds(PION_X_LOCATIE, PION_Y_LOCATIE, PION_BREEDTE, PION_HOOGTE);

        redraw();
    }

    private void drawEmpty() {
        // TODO: Zet een placeholder neer als er nog geen pion gekozen is
    }

    private final int PION_BREEDTE = 75,
                      PION_HOOGTE = 100,
                      PION_Y_LOCATIE = 0,
                      PION_X_LOCATIE = 0;

    private void drawImage() {
        setText(null);
        ImageIcon pionIcoon = pion.getImageIcon();

        pionIcoon = new ImageIcon(pionIcoon.getImage()
            .getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));

        setIcon(pionIcoon);
    }

    public void redraw() {
        if(pion == null)
            drawEmpty();
        else
            drawImage();
    }

    public void fixImage() {
        // FIXME: Dit is een vreselijke hack om te zorgen
        // dat het plaatje netjes zichtbaar wordt...
        setVisible(false);
        setVisible(true);
    }
}
