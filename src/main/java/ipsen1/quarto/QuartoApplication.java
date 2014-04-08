package ipsen1.quarto;

import ipsen1.quarto.form.Hoofdmenu;

import javax.swing.*;
import java.awt.*;

/**
 * Quarto app
 */
public class QuartoApplication extends JFrame {
    public static void main(String[] args) {
        QuartoApplication app = new QuartoApplication();
    }

    private Hoofdmenu hoofdmenu = new Hoofdmenu();

    public QuartoApplication() {
        super();

        add(hoofdmenu);

        // Zet de grootte van het venster naar die van het hoofdmenu
        Dimension dim = hoofdmenu.getPreferredSize();
        dim.height += 20;
        dim.width += 20;
        setSize(dim);

        setResizable(false);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}