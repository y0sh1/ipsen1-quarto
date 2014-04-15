package ipsen1.quarto.form;

import ipsen1.quarto.QuartoApplication;
import ipsen1.quarto.business.Pion;
import ipsen1.quarto.form.Form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BordForm extends Form {
    private final int width = 1024,
    height = 768;

    public BordForm() {
        super();
        setPreferredSize(new Dimension(width, height));
        add(new JLabel("Hoi, ik ben het bord"));
        JButton btn = new JButton("Terug");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QuartoApplication.currentApplication().popForm();
            }
        });
        add(btn);
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
}
