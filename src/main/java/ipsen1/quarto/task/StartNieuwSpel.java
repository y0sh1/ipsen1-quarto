package ipsen1.quarto.task;

import ipsen1.quarto.QuartoApplication;
import ipsen1.quarto.business.Spel;
import ipsen1.quarto.form.BordForm;
import ipsen1.quarto.form.Hoofdmenu;
import ipsen1.quarto.form.listener.SpelOpslaanListener;

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
        bord.getButtonPanel().setSpelOpslaanListener(new SpelOpslaanListener(spel));
        new SpeelBeurt().execute(spel, bord);

        QuartoApplication.currentApplication().presentForm(bord);
    }
}
