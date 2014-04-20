package ipsen1.quarto.form.bord;

import ipsen1.quarto.business.Pion;
import ipsen1.quarto.factory.Pionnen;
import ipsen1.quarto.form.Form;
import ipsen1.quarto.form.listener.KiesPionActionListener;
import ipsen1.quarto.form.pionnen.PionButton;
import ipsen1.quarto.util.QuartoColor;

import javax.swing.*;
import java.awt.*;

public class BeschikbarePionnenForm extends Form {
    private Pionnen beschikbarePionnen;
    private JPanel pionnenButtonsPanel = new JPanel();

    public BeschikbarePionnenForm() {
        setPreferredSize(new Dimension(256, 320));
        pionnenButtonsPanel.setPreferredSize(new Dimension(256, 290));

        setBackground(QuartoColor.DARK_BROWN);
        pionnenButtonsPanel.setLayout(new GridLayout(4, 4));
        pionnenButtonsPanel.setBackground(QuartoColor.DARK_BROWN);
        JLabel beschikbarePionnenLabel = new JLabel("Beschikbare spelstukken");
        beschikbarePionnenLabel.setForeground(Color.WHITE);
        add(beschikbarePionnenLabel);

        add(pionnenButtonsPanel);
        redraw();
    }

    @Override
    public void redraw() {
        if(beschikbarePionnen != null) {
            pionnenButtonsPanel.removeAll();
            voegPionnenToe(beschikbarePionnen);
        }
    }

    private KiesPionActionListener kiesPionListener;

    public void setKiesPionListener(KiesPionActionListener kiesPionListener) {
        this.kiesPionListener = kiesPionListener;
    }

    private void voegPionnenToe(Pionnen pionnen) {
        for(Pion pion : pionnen) {
            JButton btn = new PionButton(pion);
            if(kiesPionListener != null)
                btn.addActionListener(kiesPionListener);

            pionnenButtonsPanel.add(btn);
        }
    }

    public void setBeschikbarePionnen(Pionnen beschikbarePionnen) {
        this.beschikbarePionnen = beschikbarePionnen;
    }
}
