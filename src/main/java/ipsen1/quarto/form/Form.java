package ipsen1.quarto.form;

import javax.swing.*;
import java.awt.*;

/**
 * Abstracte form waar alle andere forms van overerven.
 */
abstract public class Form extends JPanel {
    protected static final String BACKGROUND_FILENAME = "/hout_achtergrond.jpg";
    protected static Image background = new ImageIcon(Form.class.getResource(BACKGROUND_FILENAME)).getImage();

    public void redraw() {
        // No-op
    }
}
