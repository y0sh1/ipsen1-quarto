package ipsen1.quarto.form;

import javax.swing.*;
import java.awt.*;

public class Instructies extends Form {
    public Instructies(){
        super();

        setPreferredSize(new Dimension(800, 600));
        setLayout(new GridLayout(3,1));

        JLabel titelLabel = new JLabel("Instructies", SwingConstants.CENTER);
        titelLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 34));
        add(titelLabel);
    }
}