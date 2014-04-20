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
    private final int width = 4,
                      height = 4;

    // TODO: Uit bord halen en in een eigen BordForm subview stoppen
    private JLabel statusLabel = new JLabel("Tekst");

    private VlakButton[][] knoppen = new VlakButton[height][width];
    private JLayeredPane vakkenPanelen[][] = new JLayeredPane[height][width];

    public Bord() {
        setPreferredSize(new Dimension(size, size));
        setLayout(new BorderLayout(100, 100));
        setBackground(QuartoColor.DARK_BROWN);
        redraw();
    }

    @Override
    public void redraw() {
        removeAll();
        setupStatusPaneel();
        tekenKnoppen();
    }

    private void setupStatusPaneel() {
        JPanel statusPaneel = new JPanel();
        statusPaneel.setBackground(QuartoColor.DARK_BROWN);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        statusLabel.setForeground(Color.WHITE);
        statusLabel.setVerticalAlignment(SwingConstants.TOP);
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);

        statusPaneel.add(statusLabel);

        this.add(statusPaneel, BorderLayout.NORTH);
    }

    private void tekenKnoppen() {
        JPanel vakkenHoofdPaneel = new JPanel();
        vakkenHoofdPaneel.setBackground(QuartoColor.DARK_BROWN);
        vakkenHoofdPaneel.setLayout(new GridLayout(width, height, 0, 0));

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                VlakButton button = new VlakButton(x, y);
                if (plaatsPionListener != null)
                    button.addActionListener(plaatsPionListener);

                /* maakt een paneel aan met een standaard FlowLayout zodat de knoppen hun eigen grootte
                   behouden aangezien dat niet mogelijk is met de GridLayout. */
                vakkenPanelen[y][x] = new JLayeredPane();
                vakkenPanelen[y][x].add(button);

                vakkenHoofdPaneel.add(vakkenPanelen[y][x]);
                knoppen[y][x] = button;
            }
            add(vakkenHoofdPaneel, BorderLayout.CENTER);
        }
    }

    public void setStatusText(String text) {
        statusLabel.setText(text);
    }

    public void voegPionToe(Pion pion) {
        PionLabel label = new PionLabel(pion);
        JLayeredPane jLayeredPane = vakkenPanelen[pion.getY()][pion.getX()];

        jLayeredPane.add(label);
        jLayeredPane.moveToFront(label);
    }

    private PlaatsPionActionListener plaatsPionListener;

    public void setPlaatsPionListener(PlaatsPionActionListener plaatsPionListener) {
        this.plaatsPionListener = plaatsPionListener;
    }
}
