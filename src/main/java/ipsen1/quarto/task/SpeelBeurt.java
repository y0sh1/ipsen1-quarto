package ipsen1.quarto.task;

import ipsen1.quarto.QuartoApplication;
import ipsen1.quarto.business.Pion;
import ipsen1.quarto.business.Spel;
import ipsen1.quarto.factory.Pionnen;
import ipsen1.quarto.form.BordForm;
import ipsen1.quarto.form.listener.KiesPionActionListener;
import ipsen1.quarto.form.listener.PlaatsPionActionListener;

public class SpeelBeurt extends Task {
    @Override
    public boolean validate() {
        if(!(QuartoApplication.currentApplication().currentForm() instanceof BordForm)) {
            return false;
        }

        return true;
    }

    private Spel spel;
    private BordForm bord;

    @Override
    public void execute() {
        // Stap 1.1
        Pion[] resterendePionnen = Pionnen.all();

        // De KiesPionListener koppelt het kiezen van een pion terug naar de kiesPion method van deze task.
        bord.getBeschikbarePionnenForm().setKiesPionListener(new KiesPionActionListener(this));
        bord.getBeschikbarePionnenForm().setBeschikbarePionnen(resterendePionnen);
        // Stap 1.2
        bord.getBeschikbarePionnenForm().redraw();

        // De KiesPionListener koppelt het plaatsen van een pion terug naar de plaatsPion method van deze task.
        bord.getBord().setPlaatsPionListener(new PlaatsPionActionListener(this));
        bord.getBord().setStatusText(spel.getStatusText());

//        spel.setHuidigePion(gekozenPion);
//        spel.volgendeSpeler();
    }

    public void execute(Spel spel, BordForm bord) {
        this.spel = spel;
        this.bord = bord;

        execute();
    }

    public void kiesPion(Pion pion) {
        spel.setHuidigePion(pion);
        bord.getGeselecteerdePion().setGeselecteerdePion(pion);
        spel.volgendeSpeler(); // TODO: Verplaatsen naar spel?
    }

    public void plaatsPion(Pion pion) {
        spel.plaatsPion(pion);
        bord.plaatsPion(pion);
        spel.volgendeSpeler(); // TODO: Verplaatsen naar spel?
    }

    // Alternatieve versie
    public void plaatsPion(Pion pion, int x, int y) {
        pion.setX(x);
        pion.setY(y);

        plaatsPion(pion);
    }
}
