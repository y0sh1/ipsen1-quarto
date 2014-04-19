package ipsen1.quarto.form.bord;

import ipsen1.quarto.business.Pion;

import ipsen1.quarto.business.Spel;
import ipsen1.quarto.form.Form;
import ipsen1.quarto.form.pionnen.PionLabel;
import ipsen1.quarto.util.QuartoColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeselecteerdePionForm extends Form {
    private Pion geselecteerdePion;
    private JLabel pionLabel;
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
        add(pionLabel, BorderLayout.CENTER);
    }

    public void pakGeselecteerdePion() {
        // TODO: Implementeer mij
        System.out.println("Pak geselecteerde pion");
    }

    public void setGeselecteerdePion(Pion geselecteerdePion) {
        this.geselecteerdePion = geselecteerdePion;
        redraw();
    }
}
