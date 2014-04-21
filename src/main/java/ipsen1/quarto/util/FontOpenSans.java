package ipsen1.quarto.util;

import java.awt.*;
import java.io.File;
import java.io.InputStream;

public class FontOpenSans {
    public static Font create(float size) {
        return new Font("Arial", Font.BOLD, (int) size);
    }

    /*
    public static Font create(float size) {
        // Font klasse defineren
        Font fontOpenSansBase;
        Font fontOpenSansReal = null;
        // Font ophalen, koppelen en opblazen
        try {
            InputStream is = FontOpenSans.class.getResourceAsStream(new File("/OpenSans-Regular.ttf").getAbsolutePath());
            fontOpenSansBase = Font.createFont(Font.TRUETYPE_FONT, is);

            fontOpenSansReal = fontOpenSansBase.deriveFont(size);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fontOpenSansReal;
    }
    */
}
