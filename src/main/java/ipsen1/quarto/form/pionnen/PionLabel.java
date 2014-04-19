package ipsen1.quarto.form.pionnen;

import ipsen1.quarto.business.Pion;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Image;

public class PionLabel extends JLabel {
    private Pion pion;

    public PionLabel(Pion pion) {
        super();
        this.pion = pion;

        if(pion == null)
            drawEmpty();
        else
            drawImage();
    }

    private void drawEmpty() {
    }

    private void drawImage() {
        ImageIcon pionIcoon = pion.getImageIcon();
//        final int PION_BREEDTE = 75;
//        final int PION_HOOGTE = 100;
//        pionIcoon = new ImageIcon(pionIcoon.getImage().getScaledInstance(PION_BREEDTE, PION_HOOGTE, Image.SCALE_SMOOTH));

        final int SCALE_FACTOR = 2;
        pionIcoon = new ImageIcon(pionIcoon.getImage().getScaledInstance(320 / SCALE_FACTOR, 540 / SCALE_FACTOR, Image.SCALE_DEFAULT));

        setIcon(pionIcoon);
    }
}
