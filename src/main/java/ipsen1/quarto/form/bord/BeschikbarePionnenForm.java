package ipsen1.quarto.form.bord;

import ipsen1.quarto.business.Pion;
import ipsen1.quarto.business.Spel;
import ipsen1.quarto.factory.Pionnen;
import ipsen1.quarto.form.Form;
import ipsen1.quarto.util.QuartoColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BeschikbarePionnenForm extends Form {
    private JPanel pionnenButtonsPanel = new JPanel();
    private Spel spel;
    private JButton[] pionButton = new JButton[4*4];
    private Pion[] pionnen = new Pion[4*4];
    private int pionNummer = 0;

    private BeschikbarePionnenForm() {}

    public BeschikbarePionnenForm(Spel spel) {
        this.spel = spel;
        setPreferredSize(new Dimension(256, 320));
        pionnenButtonsPanel.setPreferredSize(new Dimension(256, 256));
        setUpUI();
    }

    private void setUpUI() {
        setBackground(QuartoColor.DARK_BROWN);
        pionnenButtonsPanel.setLayout(new GridLayout(4, 4));
        pionnenButtonsPanel.setBackground(QuartoColor.DARK_BROWN);
        JLabel beschikbarePionnenLabel = new JLabel("Beschikbare spelstukken");
        beschikbarePionnenLabel.setForeground(Color.WHITE);
        add(beschikbarePionnenLabel);

        voegPionnenToe();
        add(pionnenButtonsPanel);
    }

    private void voegPionnenToe() {
        pionnen = Pionnen.all();
        for(int i = 0; i < 4*4; i++) {
            pionnenButtonsPanel.add(getPionButton(pionnen[i]));
            pionNummer++;
        }
    }

    private JButton getPionButton(Pion pion) {
        ImageIcon pionIcoon = pion.getImageIcon();

        final int SCALE_FACTOR = 8;
        pionIcoon = new ImageIcon(pionIcoon.getImage().getScaledInstance(320 / SCALE_FACTOR, 540 / SCALE_FACTOR, Image.SCALE_SMOOTH));
        pionButton[pionNummer] = new JButton(pionIcoon);

        pionButton[pionNummer].setContentAreaFilled(false);
        pionButton[pionNummer].setBorderPainted(false);
        pionButton[pionNummer].setFocusPainted(false);
        pionButton[pionNummer].addActionListener(new PionButtonActionListener());

        return pionButton[pionNummer];
    }

    public void kiesPion() {
        // TODO: Implementeer mij
    }

    private class PionButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(spel.huidigePionIsEmpty()) {
                JButton source = (JButton)e.getSource();
                source.setEnabled(false);

//            Controleert op welke pion geklikt is en geeft die pion door aan het spel
                for(int i = 0; i < pionButton.length; i++) {
                    if(source == pionButton[i]) {
                        System.out.println(i);
                        spel.setHuidigePion(pionnen[i]);
                    }
                }
            }



        }
    }
}
