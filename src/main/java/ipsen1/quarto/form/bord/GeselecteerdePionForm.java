package ipsen1.quarto.form.bord;

import ipsen1.quarto.business.Pion;

import ipsen1.quarto.business.Spel;
import ipsen1.quarto.form.Form;
import ipsen1.quarto.util.QuartoColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeselecteerdePionForm extends Form {
    //    private JButton pionLabel;
    private Pion geselecteerdePion;
    private ImageIcon pionIcoon;
    private Spel spel;
    private JLabel pionLabel;

    private GeselecteerdePionForm() {}

    public GeselecteerdePionForm(Spel spel) {
        this.setLayout(new BorderLayout());
        this.spel = spel;
        setPreferredSize(new Dimension(256, 320));
        setBackground(QuartoColor.DARK_BROWN);

//        geselecteerdePion = new Pion(Vorm.ROND, Kleur.WIT, Hoogte.HOOG, Hol.HOL);

        JLabel geselecteerdePionLabel = new JLabel("Gegeven spelstuk", SwingConstants.CENTER);
        geselecteerdePionLabel.setForeground(Color.WHITE);
        add(geselecteerdePionLabel, BorderLayout.NORTH);
    }

    private void tekenPion() {
        pionIcoon = geselecteerdePion.getImageIcon();
        final int SCALE_FACTOR = 2;
        pionIcoon = new ImageIcon(pionIcoon.getImage().getScaledInstance(320 / SCALE_FACTOR, 540 / SCALE_FACTOR, Image.SCALE_DEFAULT));

        pionLabel = new JLabel(pionIcoon);
        add(pionLabel, BorderLayout.CENTER);

        // Om een of andere reden wilt de pion niet getekent worden zonder deze statements. Ook repaint() hielp niet
        pionLabel.setVisible(false);
        pionLabel.setVisible(true);

    }

    public void pakGeselecteerdePion() {
        // TODO: Implementeer mij
        System.out.println("Pak geselecteerde pion");
    }

    public void setGeselecteerdePion() {
        System.out.println("setGeselecteerdePion");
        this.geselecteerdePion = spel.getHuidigePion();

        if(pionLabel != null) {
            remove(pionLabel);
        }
        tekenPion();
    }
}
