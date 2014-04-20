package ipsen1.quarto.form;

import ipsen1.quarto.QuartoApplication;

import ipsen1.quarto.business.Pion;

import ipsen1.quarto.form.bord.BeschikbarePionnenForm;
import ipsen1.quarto.form.bord.Bord;
import ipsen1.quarto.form.bord.GeselecteerdePionForm;
import ipsen1.quarto.form.listener.GeefQuartoAanActionListener;
import ipsen1.quarto.util.QuartoColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BordForm extends Form {
    private final int width = 1024,
                      height = 768;

    private BeschikbarePionnenForm beschikbarePionnen = new BeschikbarePionnenForm();
    private ButtonPanel buttonPanel = new ButtonPanel();
    private Bord bord = new Bord();
    private GeselecteerdePionForm geselecteerdePion = new GeselecteerdePionForm();

    public BordForm() {
        setPreferredSize(new Dimension(width, height));
        setLayout(new BorderLayout(0, 0));
        setBackground(QuartoColor.DARK_BROWN);

        addSubViews();
    }

    private void addSubViews() {
        add(bord, BorderLayout.WEST);

        JPanel sidebar = new JPanel();
        sidebar.setBackground(QuartoColor.DARK_BROWN);
        sidebar.setPreferredSize(new Dimension(256, height));
        sidebar.add(beschikbarePionnen);
        sidebar.add(geselecteerdePion);
        sidebar.add(buttonPanel);
        add(sidebar, BorderLayout.EAST);
    }

    public void maakWinnaarBekend(String speler) {
        Object[] optie = {"Spel afsluiten"};
        String message = "De Quarto is geldig! Het spel is gewonnen door " + speler + "!";
        String title = "Spel gewonnen";
        JOptionPane.showOptionDialog(null, message, title, JOptionPane.OK_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, optie, optie[0]);
    }

    public void geefOngeldigeQuartoAan(String statusText, String speler) {
        String message = "De Quarto is ongeldig. De beurt is voorbij en " + speler +
                " is aan zet";
        String title = "Ongeldige Quarto!";
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
        bord.setStatusText(statusText);
    }

    public void plaatsPion(Pion pion) {
        bord.voegPionToe(pion);
    }

    public Bord getBord() {
        return bord;
    }

    public GeselecteerdePionForm getGeselecteerdePion() {
        return geselecteerdePion;
    }

    public BeschikbarePionnenForm getBeschikbarePionnenForm() {
        return beschikbarePionnen;
    }

    public ButtonPanel getButtonPanel() {
        return buttonPanel;
    }

    public class ButtonPanel extends Form {
        private JButton quartoButton, menuButton;
        private GeefQuartoAanActionListener quartoListener;

        public ButtonPanel() {
            setPreferredSize(new Dimension(256, 64));
            setLayout(new FlowLayout());
            setBackground(QuartoColor.DARK_BROWN);

            redraw();
        }

        @Override
        public void redraw() {
            removeAll();

            quartoButton = new JButton("Quarto!");
            menuButton = new JButton("Menu");

            if(quartoListener != null)
                quartoButton.addActionListener(quartoListener);

            menuButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    QuartoApplication.currentApplication()
                            .presentForm(new InGameMenu());
                }
            });

            add(quartoButton);
            add(menuButton);
        }

        public void setQuartoListener(GeefQuartoAanActionListener quartoListener) {
            this.quartoListener = quartoListener;
        }
    }
}
