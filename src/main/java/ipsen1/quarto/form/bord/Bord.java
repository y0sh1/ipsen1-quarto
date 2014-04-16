// Door Tim Vane.

package ipsen1.quarto.form.bord;

import ipsen1.quarto.form.Form;

import javax.swing.*;

import java.awt.*;

public class Bord extends Form {
    private final int size = 768;
    private JLabel statusLabel = new JLabel("TIJDELIJKE STATUS TEKST. AANPASSEN!!!!");
    private JButton[] knoppen = new JButton[4 * 4];

    public Bord() {
        setPreferredSize(new Dimension(size, size));
        setupStatusPaneel();
        setupKnoppen();
    }

    private void setupStatusPaneel() {
        JPanel statusPaneel = new JPanel();
        statusPaneel.add(statusLabel);
        this.add(statusPaneel);
    }

    private void setupKnoppen() {
        final ImageIcon VAKJE_ICOON = new ImageIcon("src/main/resources/Vakje.png");
        int knopNummer = 0;
        JPanel vakjesPlaatsPanelen[] = new JPanel[4];

        for(int i = 0; i < knoppen.length; i++) {
            knoppen[i] = new JButton(VAKJE_ICOON);
        }

        for(int i = 0; i < vakjesPlaatsPanelen.length; i++) {
            vakjesPlaatsPanelen[i] = new JPanel();
            for(int j = 0; j < 4; j++) {
                vakjesPlaatsPanelen[i].add(knoppen[knopNummer]);
                knopNummer++;
            }
            this.add(vakjesPlaatsPanelen[i]);
        }
    }

    public void setStatusText(String status) {
        this.statusLabel.setText(status);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawOval(getWidth() / 2 - 300, 125, 600, 600);
    }
}
