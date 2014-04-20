package ipsen1.quarto.form.listener;

import ipsen1.quarto.business.Spel;
import ipsen1.quarto.task.OpslaanSpel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpelOpslaanListener implements ActionListener{
    private Spel huidigespel;

    public SpelOpslaanListener(Spel huidigespel){
        this.huidigespel = huidigespel;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (huidigespel != null) {
            new OpslaanSpel(huidigespel).run();
        }
    }
}
