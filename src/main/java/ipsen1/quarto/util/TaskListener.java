package ipsen1.quarto.util;

import ipsen1.quarto.task.Task;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Y0sh1 on 08/04/14.
 */
public class TaskListener implements ActionListener {
    private Task task;

    public TaskListener(Task t) {
        task = t;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        task.run();
    }
}
