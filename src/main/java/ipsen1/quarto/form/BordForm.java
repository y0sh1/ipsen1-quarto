package ipsen1.quarto.form;

import ipsen1.quarto.QuartoApplication;

import ipsen1.quarto.business.Pion;
import ipsen1.quarto.business.Spel;

import ipsen1.quarto.form.bord.BeschikbarePionnenForm;
import ipsen1.quarto.form.bord.Bord;
import ipsen1.quarto.form.bord.GeselecteerdePionForm;
import ipsen1.quarto.util.QuartoColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BordForm extends Form {
    private Spel spel = new Spel();
    private final int width = 1024,
                      height = 768;

    private JPanel bord = new Bord(spel),
                   beschikbarePionnen = new BeschikbarePionnenForm(),
                   geselecteerdePionnen = new GeselecteerdePionForm(),
                   buttonPanel = new ButtonPanel();



    public BordForm() {
        setupUI();
    }

    public BordForm(Spel startSpel) {
        spel = startSpel;
        setupUI();
    }

    private void setupUI() {
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
        sidebar.add(geselecteerdePionnen);
        sidebar.add(buttonPanel);
        add(sidebar, BorderLayout.EAST);
    }

    public void maakWinnaarBekend() {
        // TODO: Implementeer mij
    }

    public void geefOngeldigeQuartoAan() {
        // TODO: Implementeer mij
    }

    public void plaatsPion(Pion pion, int x, int y) {
        // TODO: Implementeer mij
    }

    public void hideForm() { // De naam `hide` bestaat al in JComponent, maar is deprecated
        // TODO: Implementeer mij
    }

    private void roepQuarto() {
        System.out.println("Iemand roept Quarto!");
        spel.quartoAangeven();
    }

    public Spel getSpel() {
        return spel;
    }

    private class ButtonPanel extends JPanel {
        private JButton quartoButton = new JButton("Quarto!"),
                        menuButton = new JButton("Menu");

        public ButtonPanel() {
            setPreferredSize(new Dimension(256, 64));
            setLayout(new FlowLayout());
            setBackground(QuartoColor.DARK_BROWN);

            addButtons();
        }

        private void addButtons() {
            quartoButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    roepQuarto();
                }
            });
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
    }
}
