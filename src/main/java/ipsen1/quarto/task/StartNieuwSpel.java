package ipsen1.quarto.task;

import ipsen1.quarto.QuartoApplication;
import ipsen1.quarto.form.BordForm;
import ipsen1.quarto.form.Hoofdmenu;

public class StartNieuwSpel extends Task {
    private boolean isInHoofdmenu() {
        return QuartoApplication.currentApplication().currentForm() instanceof Hoofdmenu;
    }

    @Override
    public boolean validate() {
        return isInHoofdmenu();
    }

    @Override
    public void execute() {
        QuartoApplication.currentApplication().presentForm(new BordForm());
    }
}
