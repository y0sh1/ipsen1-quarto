package ipsen1.quarto.task;

import ipsen1.quarto.QuartoApplication;
import ipsen1.quarto.business.Spel;
import ipsen1.quarto.business.Speler;
import ipsen1.quarto.form.BordForm;
import ipsen1.quarto.form.Hoofdmenu;
import ipsen1.quarto.form.listener.SpelOpslaanListener;
import ipsen1.quarto.form.KiesSpelersForm;
import ipsen1.quarto.form.listener.KiesSpelersActionListener;

public class StartNieuwSpel extends Task{
    private boolean isInHoofdmenu() {
        return QuartoApplication.currentApplication().currentForm() instanceof Hoofdmenu;
    }

    @Override
    public boolean validate() {
        return isInHoofdmenu();
    }

    private Speler[] spelers;
    private KiesSpelersForm spelersForm;

    @Override
    public void execute() {
        if(spelers == null) {
            spelersForm = new KiesSpelersForm();
            KiesSpelersActionListener listener = new KiesSpelersActionListener(this, spelersForm);
            spelersForm.setKiesSpelersListener(listener);
            QuartoApplication.currentApplication().presentForm(spelersForm);
        } else {
            spelers = spelersForm.getSpelers();
            Spel spel = new Spel();
            spel.setSpelers(spelers);
            BordForm bord = new BordForm();

            new SpeelBeurt().execute(spel, bord);

            QuartoApplication.currentApplication().presentForm(bord);
        }
    }

    public void setSpelers(Speler[] spelers) {
        this.spelers = spelers;
    }
}
