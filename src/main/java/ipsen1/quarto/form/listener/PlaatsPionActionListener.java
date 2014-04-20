package ipsen1.quarto.form.listener;

import ipsen1.quarto.form.bord.VlakButton;
import ipsen1.quarto.task.SpeelBeurt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlaatsPionActionListener extends SpeelBeurtActionListener implements ActionListener {
    public PlaatsPionActionListener(SpeelBeurt task) {
        super(task);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof VlakButton) {
            VlakButton button = (VlakButton) e.getSource();

            beurtTask.plaatsPion(button.getX(), button.getY());
        }
    }
}
