//Auteur klasse: Tim Vane

package ipsen1.quarto.form.bord;

import ipsen1.quarto.business.Pion;
import ipsen1.quarto.form.Form;
import ipsen1.quarto.form.listener.PlaatsPionActionListener;
import ipsen1.quarto.form.pionnen.PionLabel;
import ipsen1.quarto.util.QuartoColor;
import javax.swing.*;
import java.awt.*;

public class Bord extends Form {
    private final int size = 768;
    private final int width = 4, height = 4;

    // TODO: Uit bord halen en in een eigen BordForm subview stoppen
    private JLabel statusLabel = new JLabel("Tekst");

    private JButton[] knoppen = new JButton[width * height];
    private JLayeredPane vakkenPanelen[] = new JLayeredPane[width * height];
    private Pion[] geplaatstePionnen = new Pion[width * height];

    public Bord() {
        setPreferredSize(new Dimension(size, size));
        setLayout(new BorderLayout(100, 100));
        setBackground(QuartoColor.DARK_BROWN);
        setupStatusPaneel();
        tekenKnoppen();
    }

    private void setupStatusPaneel() {
        JPanel statusPaneel = new JPanel();
        statusPaneel.setBackground(QuartoColor.DARK_BROWN);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        statusLabel.setForeground(Color.WHITE);
        statusPaneel.add(statusLabel);

        this.add(statusPaneel, BorderLayout.NORTH);
    }

    private void tekenKnoppen() {
        final ImageIcon VAKJE_ICOON = new ImageIcon("src/main/resources/Vakje.png");
        JPanel vakkenHoofdPaneel = new JPanel();
        vakkenHoofdPaneel.setBackground(QuartoColor.DARK_BROWN);
        vakkenHoofdPaneel.setLayout(new GridLayout(4, 4, -100, 0));

        for (int i = 0; i < knoppen.length; i++) {
            knoppen[i] = new JButton(VAKJE_ICOON);
            if(plaatsPionListener != null)
                knoppen[i].addActionListener(plaatsPionListener);

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

    public void setStatusText(String text) {
        statusLabel.setText(text);
    }

    public void voegPionToe(Pion pion) {
        int vakNummer = pion.getX() * pion.getY();

        PionLabel label = new PionLabel(pion);
        vakkenPanelen[vakNummer].add(label);
        vakkenPanelen[vakNummer].moveToFront(label);

        final int PION_BREEDTE = 75;
        final int PION_HOOGTE = 100;

        final int PION_Y_LOCATIE = -25;
        final int PION_X_LOCATIE = 125 / 2 + 11;
        label.setBounds(PION_X_LOCATIE, PION_Y_LOCATIE, PION_BREEDTE, PION_HOOGTE);
    }

    private PlaatsPionActionListener plaatsPionListener;

    public void setPlaatsPionListener(PlaatsPionActionListener plaatsPionListener) {
        this.plaatsPionListener = plaatsPionListener;
    }
}
