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

        int y_locatie = PION_Y_LOCATIE;
        if(pion != null && pion.getHoogte() == Pion.Hoogte.LAAG)
            y_locatie += 20;

        setBounds(PION_X_LOCATIE, y_locatie, PION_BREEDTE, PION_HOOGTE);
        setPreferredSize(new Dimension(PION_BREEDTE, PION_HOOGTE));
        setSize(new Dimension(PION_BREEDTE, PION_HOOGTE));

        redraw();
    }

    private void drawEmpty() {
        // TODO: Zet een placeholder neer als er nog geen pion gekozen is
    }

    private final int PION_BREEDTE = 120,
                      PION_HOOGTE = 120,
                      PION_Y_LOCATIE = -8,
                      PION_X_LOCATIE = 2;

    private void drawImage() {
        setText(null);
        ImageIcon pionIcoon = pion.getImageIcon();

        pionIcoon = new ImageIcon(pionIcoon.getImage()
            .getScaledInstance(60, 100, Image.SCALE_SMOOTH));

        setIcon(pionIcoon);
        setOpaque(false);
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
