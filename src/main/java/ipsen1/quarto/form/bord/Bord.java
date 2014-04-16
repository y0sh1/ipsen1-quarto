package ipsen1.quarto.form.bord;

import javax.swing.*;
import java.awt.*;

public class Bord extends JPanel {
    private final int size = 768;

    public Bord() {
        setPreferredSize(new Dimension(size, size));
        add(new JLabel("Tim aan de beurt, plaats je spelstuk"));
    }
}
