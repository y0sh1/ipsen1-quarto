package ipsen1.quarto.task;

import ipsen1.quarto.QuartoApplication;
import ipsen1.quarto.form.BordForm;

public class StartNieuwSpel extends Task {
    @Override
    public boolean validate() {
        // TODO: Implementeer mij
        return true;
    }

    @Override
    public void execute() {
        // TODO: Implementeer mij
        System.out.println("Running StartNieuwSpel");
        QuartoApplication.currentApplication().presentForm(new BordForm());
    }
}
