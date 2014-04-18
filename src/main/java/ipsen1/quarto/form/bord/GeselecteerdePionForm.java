package ipsen1.quarto.form.bord;

import ipsen1.quarto.business.Pion;
import static ipsen1.quarto.business.Pion.*;
import ipsen1.quarto.form.Form;
import ipsen1.quarto.util.QuartoColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeselecteerdePionForm extends Form {
    private JButton pionButton;
    private Pion geselecteerdePion;

    public GeselecteerdePionForm() {
        setPreferredSize(new Dimension(256, 320));

        geselecteerdePion = new Pion(Vorm.ROND, Kleur.WIT, Hoogte.HOOG, Hol.HOL);

        JLabel geselecteerdePionLabel = new JLabel("Gegeven spelstuk", SwingConstants.CENTER);
        geselecteerdePionLabel.setForeground(Color.WHITE);
        add(geselecteerdePionLabel);
        voegButtonToe();
        setBackground(QuartoColor.DARK_BROWN);
    }

    private void voegButtonToe() {
        ImageIcon pionIcoon = geselecteerdePion.getImageIcon();
        final int SCALE_FACTOR = 2;
        pionIcoon = new ImageIcon(pionIcoon.getImage().getScaledInstance(320 / SCALE_FACTOR, 540 / SCALE_FACTOR, Image.SCALE_DEFAULT));

        pionButton = new JButton(pionIcoon);
        pionButton.addActionListener(new PionButtonActionListener());
        pionButton.setPreferredSize(getPreferredSize());
        pionButton.setOpaque(false);
        pionButton.setContentAreaFilled(false);
        pionButton.setBorderPainted(false);
        pionButton.setBackground(QuartoColor.DARK_BROWN);

        add(pionButton);
    }

    public void pakGeselecteerdePion() {
        // TODO: Implementeer mij
        System.out.println("Pak geselecteerde pion");
    }

    private class PionButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            pakGeselecteerdePion();
        }
    }
}
