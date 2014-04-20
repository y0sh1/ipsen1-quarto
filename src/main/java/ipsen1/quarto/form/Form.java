package ipsen1.quarto.form;

import javax.swing.*;
import java.awt.*;

/**
 * Abstracte form waar alle andere forms van overerven.
 */
abstract public class Form extends JPanel {
    protected static final String BACKGROUND_FILENAME = "src/main/resources/hout_achtergrond.jpg";
    protected static final Image background = new ImageIcon(BACKGROUND_FILENAME).getImage();

    protected final int DEFAULT_WIDTH = 1024,
                      DEFAULT_HEIGHT = 768;

    public Form() {
        redraw();
    }

    public void redraw() {
        if(isPrimaryForm())
            setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
    }

    protected boolean isPrimaryForm() {
        return getClass() .getPackage()
                .toString().endsWith("ipsen1.quarto.form");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(isPrimaryForm())
            g.drawImage(background, 0, 0, null);
    }
}
