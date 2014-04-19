package ipsen1.quarto.task;

import ipsen1.quarto.QuartoApplication;
import ipsen1.quarto.business.Pion;
import ipsen1.quarto.business.Spel;
import ipsen1.quarto.factory.Pionnen;
import ipsen1.quarto.form.BordForm;
import ipsen1.quarto.form.listener.GeefQuartoAanActionListener;
import ipsen1.quarto.form.listener.KiesPionActionListener;
import ipsen1.quarto.form.listener.PlaatsPionActionListener;

public class SpeelBeurt extends Task {
    @Override
    public boolean validate() {
        if(!(QuartoApplication.currentApplication().currentForm() instanceof BordForm))
            return false;

        if(spel != null && !spel.isQuarto())
            return false;

        return true;
    }

    private Spel spel;
    private BordForm bordForm;

    @Override
    public void execute() {
        // Stap 1.1
        Pion[] resterendePionnen = Pionnen.all();

        // De KiesPionListener koppelt het kiezen van een pion terug naar de kiesPion method van deze task.
        bordForm.getBeschikbarePionnenForm().setKiesPionListener(new KiesPionActionListener(this));
        bordForm.getBeschikbarePionnenForm().setBeschikbarePionnen(resterendePionnen);
        // Stap 1.2
        bordForm.getBeschikbarePionnenForm().redraw();

        // De KiesPionListener koppelt het plaatsen van een pion terug naar de plaatsPion method van deze task.
        bordForm.getBord().setPlaatsPionListener(new PlaatsPionActionListener(this));
        bordForm.getBord().setStatusText(spel.getStatusText());
        bordForm.getBord().redraw();

        bordForm.getButtonPanel().setQuartoListener(new GeefQuartoAanActionListener(spel));
        bordForm.getButtonPanel().redraw();
    }

    public void execute(Spel spel, BordForm bord) {
        this.spel = spel;
        this.bordForm = bord;

        execute();
    }

    public void kiesPion(Pion pion) {
        spel.setGeselecteerdePion(pion);
        bordForm.getGeselecteerdePion().setGeselecteerdePion(pion);
        bordForm.getGeselecteerdePion().redraw();

        spel.volgendeSpeler(); // TODO: Verplaatsen naar spel?
        bordForm.getBord().setStatusText(spel.getStatusText());
    }

    public void plaatsPion(int x, int y) {
        Pion huidigePion = spel.getGeselecteerdePion();
        if(huidigePion == null)
            return;

        huidigePion.setX(x);
        huidigePion.setY(y);

        spel.plaatsPion(huidigePion);
        bordForm.plaatsPion(huidigePion);

        spel.verwijderGeselecteerdePion();
        bordForm.getGeselecteerdePion().redraw();

        spel.volgendeSpeler(); // TODO: Verplaatsen naar spel?
        bordForm.getBord().setStatusText(spel.getStatusText());
    }
}
