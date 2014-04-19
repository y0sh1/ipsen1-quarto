package ipsen1.quarto.form.listener;

import ipsen1.quarto.form.bord.VlakButton;
import ipsen1.quarto.form.pionnen.PionButton;
import ipsen1.quarto.task.SpeelBeurt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlaatsPionActionListener extends SpeelBeurtActionListener implements ActionListener {
    public PlaatsPionActionListener(SpeelBeurt task) {
        super(task);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Klik");
        if(e.getSource() instanceof VlakButton) {
            VlakButton button = (VlakButton) e.getSource();

            beurtTask.plaatsPion(button.getX(), button.getY());
            System.out.println("Pion plaatsen op x: " + button.getX() + " y: " + button.getY());
        }
    }
}
