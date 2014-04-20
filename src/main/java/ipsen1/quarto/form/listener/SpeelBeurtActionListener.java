package ipsen1.quarto.form.listener;

import ipsen1.quarto.task.SpeelBeurt;

import java.awt.event.ActionListener;

public abstract class SpeelBeurtActionListener implements ActionListener {
    protected SpeelBeurt beurtTask;

    public SpeelBeurtActionListener(SpeelBeurt task) {
        super();
        this.beurtTask = task;
    }
}
