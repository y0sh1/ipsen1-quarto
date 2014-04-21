package ipsen1.quarto.form;

import ipsen1.quarto.QuartoApplication;
import ipsen1.quarto.business.Speler;
import ipsen1.quarto.form.listener.KiesSpelersActionListener;
import ipsen1.quarto.form.menu.MenuButton;
import ipsen1.quarto.util.FontOpenSans;
import ipsen1.quarto.util.QuartoColor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KiesSpelersForm extends Form {
    private KiesSpelersActionListener kiesSpelersListener;

    public KiesSpelersForm() {
        setPreferredSize(new Dimension(1024, 768));
        setLayout(new BorderLayout(10, 10));
        setBackground(QuartoColor.DARK_BROWN);
        redraw();
    }

    public void setKiesSpelersListener(KiesSpelersActionListener kiesSpelersListener) {
        this.kiesSpelersListener = kiesSpelersListener;
        redraw();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
    }

    public Speler[] getSpelers() {
        Speler[] spelers = new Speler[textFields.length];
        for(int i = 0; i < textFields.length; i++)
            spelers[i] = new Speler(textFields[i].getText());

        return spelers;
    }

    private JTextField[] textFields;

    public void redraw() {
        removeAll();

        // Defineren Titel koptekst
        JLabel titelLabel = new JLabel("Geef de namen op", SwingConstants.CENTER);
        titelLabel.setFont(FontOpenSans.create(48));
        titelLabel.setForeground(QuartoColor.WHITE);

        // Namen paneel
        JPanel namenPaneel = new JPanel();
        namenPaneel.setOpaque(false);
        JLabel instructieTekst = new JLabel();
        instructieTekst.setForeground(QuartoColor.WHITE);

        final int side_margin = 1024 / 6;
        setBorder(new EmptyBorder(0, side_margin, 55, side_margin));

        textFields = new JTextField[2];
        textFields[0] = new JTextField("Speler 1", 16);
        textFields[1] = new JTextField("Speler 2", 16);

        for(JTextField tf : textFields)
                namenPaneel.add(tf);

        // Knop aanmaken en invullen
        JButton okKnop = new MenuButton("Beginnen");
        if(kiesSpelersListener != null)
            okKnop.addActionListener(kiesSpelersListener);
        okKnop.setSize(20,20);
        okKnop.setBorder(new EmptyBorder(0,0,0,0));

        // Toevoegen Labels
        add(namenPaneel, BorderLayout.CENTER);
        add(titelLabel, BorderLayout.NORTH);
        add(okKnop, BorderLayout.SOUTH);
    }
}