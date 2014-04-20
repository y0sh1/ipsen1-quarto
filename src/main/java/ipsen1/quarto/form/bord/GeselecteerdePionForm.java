package ipsen1.quarto.form.bord;

import ipsen1.quarto.business.Pion;

import ipsen1.quarto.factory.Pionnen;
import ipsen1.quarto.form.Form;
import ipsen1.quarto.form.pionnen.PionLabel;
import ipsen1.quarto.util.QuartoColor;

import javax.swing.*;
import java.awt.*;

public class GeselecteerdePionForm extends Form {
    private Pion geselecteerdePion;
    private PionLabel pionLabel;
    private JLabel geselecteerdePionLabel;

    public GeselecteerdePionForm() {
        this.setLayout(new BorderLayout());
        setPreferredSize(new Dimension(256, 320));
        setBackground(QuartoColor.DARK_BROWN);

        geselecteerdePionLabel = new JLabel("Gegeven spelstuk", SwingConstants.CENTER);
        geselecteerdePionLabel.setForeground(Color.WHITE);

        redraw();
    }

    @Override
    public void redraw() {
        removeAll();

        add(geselecteerdePionLabel, BorderLayout.NORTH);

        pionLabel = new PionLabel(geselecteerdePion);
        pionLabel.setSize(new Dimension(320 / 2, 540 / 2));

        add(pionLabel, BorderLayout.CENTER);
    }

    public void setGeselecteerdePion(Pion geselecteerdePion) {
        this.geselecteerdePion = geselecteerdePion;
        redraw();
    }

    public void verwijderGeselecteerdePion() {
        geselecteerdePion = null;
        redraw();
    }
}
