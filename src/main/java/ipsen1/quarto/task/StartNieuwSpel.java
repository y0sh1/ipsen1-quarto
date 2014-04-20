package ipsen1.quarto.task;

import ipsen1.quarto.QuartoApplication;
import ipsen1.quarto.business.Spel;
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
        Spel spel = new Spel();
        BordForm bord = new BordForm();

        new SpeelBeurt(spel, bord).execute();

        QuartoApplication.currentApplication().presentForm(bord);
    }
}
