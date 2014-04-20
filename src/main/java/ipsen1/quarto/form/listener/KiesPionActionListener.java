package ipsen1.quarto.form.listener;

import ipsen1.quarto.form.pionnen.PionButton;
import ipsen1.quarto.task.SpeelBeurt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KiesPionActionListener extends SpeelBeurtActionListener implements ActionListener {
    public KiesPionActionListener(SpeelBeurt task) {
        super(task);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof PionButton) {
            PionButton button = (PionButton) e.getSource();
            button.setEnabled(false);

            beurtTask.kiesPion(button.getPion());
            System.out.println("Pion " + button.getPion().toString() + " gekozen");
        }
    }
}
