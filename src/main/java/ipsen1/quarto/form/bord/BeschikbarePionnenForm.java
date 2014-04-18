package ipsen1.quarto.form.bord;

import ipsen1.quarto.business.Pion;
import ipsen1.quarto.factory.Pionnen;
import ipsen1.quarto.form.Form;
import ipsen1.quarto.util.QuartoColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BeschikbarePionnenForm extends Form {
    private JPanel pionnenButtonsPanel = new JPanel();

    public BeschikbarePionnenForm() {
        setPreferredSize(new Dimension(256, 320));
        pionnenButtonsPanel.setPreferredSize(new Dimension(256, 256));
        setUpUI();
    }

    private void setUpUI() {
        setBackground(QuartoColor.DARK_BROWN);
        pionnenButtonsPanel.setLayout(new GridLayout(4, 4));

        JLabel beschikbarePionnenLabel = new JLabel("Beschikbare spelstukken");
        beschikbarePionnenLabel.setForeground(Color.WHITE);
        add(beschikbarePionnenLabel);

        voegPionnenToe();
        add(pionnenButtonsPanel);
    }

    private void voegPionnenToe() {
        for(Pion p : Pionnen.all()) {
            pionnenButtonsPanel.add(getPionButton(p));
        }
    }

    private JButton getPionButton(Pion pion) {
        ImageIcon pionIcoon = pion.getImageIcon();

        final int SCALE_FACTOR = 8;
        pionIcoon = new ImageIcon(pionIcoon.getImage().getScaledInstance(320 / SCALE_FACTOR, 540 / SCALE_FACTOR, Image.SCALE_SMOOTH));
        JButton pionButton = new JButton(pionIcoon);

        pionButton.setOpaque(false);
        pionButton.setContentAreaFilled(false);
        pionButton.setBorderPainted(false);
        pionButton.addActionListener(new PionButtonActionListener());

        return pionButton;
    }

    public void kiesPion() {
        // TODO: Implementeer mij
    }

    private class PionButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Click");
        }
    }
}
