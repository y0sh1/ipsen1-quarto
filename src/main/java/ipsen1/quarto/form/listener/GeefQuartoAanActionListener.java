package ipsen1.quarto.form.listener;

import ipsen1.quarto.business.Spel;
import ipsen1.quarto.task.GeefQuartoAan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeefQuartoAanActionListener implements ActionListener {
    private Spel spel;

    public GeefQuartoAanActionListener(Spel spel) {
        this.spel = spel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new GeefQuartoAan(spel).run();
    }
}
