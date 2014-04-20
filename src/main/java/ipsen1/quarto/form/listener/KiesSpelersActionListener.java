package ipsen1.quarto.form.listener;

import ipsen1.quarto.form.KiesSpelersForm;
import ipsen1.quarto.task.StartNieuwSpel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KiesSpelersActionListener implements ActionListener {
    private StartNieuwSpel startTask;
    private KiesSpelersForm spelersForm;

    public KiesSpelersActionListener(StartNieuwSpel startTask, KiesSpelersForm spelersForm) {
        this.startTask = startTask;
        this.spelersForm = spelersForm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Running listener");
        startTask.setSpelers(spelersForm.getSpelers());
        startTask.execute();
    }
}
