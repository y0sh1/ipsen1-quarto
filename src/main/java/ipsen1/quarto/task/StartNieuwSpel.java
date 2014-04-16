package ipsen1.quarto.task;

import ipsen1.quarto.QuartoApplication;
import ipsen1.quarto.form.BordForm;

public class StartNieuwSpel extends Task {
    @Override
    public boolean validate() {
        return true;
    }

    @Override
    public void execute() {
        QuartoApplication.currentApplication().presentForm(new BordForm());
    }
}
