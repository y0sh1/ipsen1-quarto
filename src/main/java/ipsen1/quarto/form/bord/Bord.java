//Auteur klasse: Tim Vane

package ipsen1.quarto.form.bord;

import ipsen1.quarto.business.Pion;
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
    private JButton[] knoppen = new JButton[4*4];
    private Spel spel;
    private JLayeredPane vakkenPanelen[] = new JLayeredPane[4*4];

    private Bord() {}

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
        JPanel vakkenHoofdPaneel = new JPanel();
        vakkenHoofdPaneel.setBackground(QuartoColor.DARK_BROWN);
        vakkenHoofdPaneel.setLayout(new GridLayout(4, 4, -100, 0));

        for (int i = 0; i < knoppen.length; i++) {
            knoppen[i] = new JButton(VAKJE_ICOON);
            knoppen[i].addActionListener(this);

            // Haalt de stijl van de JButton weg zodat alleen het rondje over blijft.
            knoppen[i].setContentAreaFilled(false);
            knoppen[i].setBorderPainted(false);
            knoppen[i].setFocusPainted(false);


            /* maakt een paneel aan met een standaard FlowLayout zodat de knoppen hun eigen grootte
               behouden aangezien dat niet mogelijk is met de GridLayout. */
            vakkenPanelen[i] = new JLayeredPane();
            vakkenPanelen[i].add(knoppen[i]);
            knoppen[i].setBounds(50, 0, 125, 85);

            vakkenHoofdPaneel.add(vakkenPanelen[i]);
        }
        this.add(vakkenHoofdPaneel, BorderLayout.CENTER);
    }

    //Werkt nog niet goed
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(87, 31, 31));
        g.drawOval(getWidth() / 2 - 300, 125, 600, 600);
    }

    public void voegIcoonToeAanBord(Pion pion, int vakNummer) {
        ImageIcon pionIcoon = pion.getImageIcon();
        final int PION_BREEDTE = 75;
        final int PION_HOOGTE = 100;

        pionIcoon = new ImageIcon(pionIcoon.getImage().getScaledInstance(PION_BREEDTE, PION_HOOGTE, Image.SCALE_SMOOTH));
        JLabel label = new JLabel(pionIcoon);
        vakkenPanelen[vakNummer].add(label);
        vakkenPanelen[vakNummer].moveToFront(label);

        final int PION_Y_LOCATIE = -25;
        final int PION_X_LOCATIE = 125 / 2 + 11;
        label.setBounds(PION_X_LOCATIE, PION_Y_LOCATIE, PION_BREEDTE, PION_HOOGTE);
    }

//    Implementeer mij
    @Override
    public void actionPerformed(ActionEvent e) {
        if(spel.getHuidigePion() != null) {
            JButton source = (JButton)e.getSource();
            source.removeActionListener(this); //knop is nu niet meer klikbaar
            Pion huidigePion = spel.getHuidigePion();

            for(int i = 0; i < knoppen.length; i++) {
                if(source == knoppen[i]) {
                    voegIcoonToeAanBord(huidigePion, i);
                }
            }
            spel.verwijderHuidigePion();
        }
    }
}
