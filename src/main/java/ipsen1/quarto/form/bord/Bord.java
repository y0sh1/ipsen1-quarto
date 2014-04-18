package ipsen1.quarto.form.bord;

import ipsen1.quarto.business.Spel;
import ipsen1.quarto.form.Form;
import ipsen1.quarto.util.QuartoColor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bord extends Form implements ActionListener {
    private final int size = 768;
    private JLabel statusLabel = new JLabel("TIJDELIJKE STATUS TEKST. AANPASSEN!!!!");
    private JButton[] knoppen = new JButton[4 * 4];
    private Spel spel;

    public Bord(Spel spel) {
        this.spel = spel;
        setPreferredSize(new Dimension(size, size));
        setLayout(new BorderLayout(100, 100));
        setBackground(QuartoColor.DARK_BROWN);
        setupStatusPaneel();
        setupKnoppen();
    }

    public void setStatusText(String status) {
        this.statusLabel.setText(status);
    }

    private void setupStatusPaneel() {
        JPanel statusPaneel = new JPanel();
        statusPaneel.setBackground(QuartoColor.DARK_BROWN);
        statusLabel.setFont(new Font("Arial", 1, 30));
        statusLabel.setForeground(Color.WHITE);
        statusPaneel.add(statusLabel);

        this.add(statusPaneel, BorderLayout.NORTH);
    }

    private void setupKnoppen() {
        final ImageIcon VAKJE_ICOON = new ImageIcon("src/main/resources/Vakje.png");
        int knopNummer = 0;
        JPanel vakkenPaneel = new JPanel();
        vakkenPaneel.setBackground(QuartoColor.DARK_BROWN);
        vakkenPaneel.setLayout(new GridLayout(4, 4, -50, 0));

        for (int i = 0; i < knoppen.length; i++) {
            knoppen[i] = new JButton(VAKJE_ICOON);
            knoppen[i].setPreferredSize(new Dimension(125, 85));
            knoppen[i].addActionListener(this);

            // Haalt de stijl van de JButton weg zodat alleen het rondje over blijft.
            knoppen[i].setContentAreaFilled(false);
            knoppen[i].setBorderPainted(false);
            knoppen[i].setFocusPainted(false);


            // maakt een paneel aan met een standaard FlowLayout zodat de knoppen kunnen resizen aangezien dat niet mogelijk is met de GridLayout
            JPanel paneel = new JPanel();
            paneel.add(knoppen[i]);
            paneel.setBackground(QuartoColor.DARK_BROWN);
            vakkenPaneel.add(paneel);
        }

        add(vakkenPaneel, BorderLayout.CENTER);
    }

    //Werkt nog niet goed
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(87, 31, 31));
        g.drawOval(getWidth() / 2 - 300, 125, 600, 600);
    }

//    Implementeer mij
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton)e.getSource();
        source.removeActionListener(this); //knop is nu niet meer klikbaar

        System.out.println(source);


    }
}
