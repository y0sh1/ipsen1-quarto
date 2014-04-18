package ipsen1.quarto.util;

import java.awt.*;
import java.io.FileInputStream;
import java.io.InputStream;

public class FontOpenSans {

    public static Font create(float size) {
        // Font klasse defineren
        Font fontOpenSansBase;
        Font fontOpenSansReal = null;
        // Font ophalen, koppelen en opblazen
        try {
            InputStream is = new FileInputStream("src/main/resources/OpenSans-Regular.ttf");
            fontOpenSansBase = Font.createFont(Font.TRUETYPE_FONT, is);
            fontOpenSansReal = fontOpenSansBase.deriveFont(size);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return fontOpenSansReal;
    }
}
