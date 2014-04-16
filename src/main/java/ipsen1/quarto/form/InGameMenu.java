package ipsen1.quarto.form;

import ipsen1.quarto.QuartoApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InGameMenu extends Form {
    public InGameMenu() {
        setPreferredSize(new Dimension(1024, 768));

        JButton closeButton = new JButton("Terug");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QuartoApplication.currentApplication().popForm();
            }
        });
        add(closeButton);
    }
}
