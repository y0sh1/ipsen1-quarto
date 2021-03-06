package ipsen1.quarto.task;

import ipsen1.quarto.QuartoApplication;
import ipsen1.quarto.business.Pion;
import ipsen1.quarto.business.Spel;
import ipsen1.quarto.factory.Pionnen;
import ipsen1.quarto.form.BordForm;
import ipsen1.quarto.form.listener.GeefQuartoAanActionListener;
import ipsen1.quarto.form.listener.KiesPionActionListener;
import ipsen1.quarto.form.listener.PlaatsPionActionListener;
import ipsen1.quarto.form.listener.SpelOpslaanListener;

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
    private ControleerQuarto controleerQuarto;

    @Override
    public void execute() {
        // Koppel een listener aan het bord voor het opslaan van het spel
        bordForm.getButtonPanel().setSpelOpslaanListener(new SpelOpslaanListener(spel));

        // Stap 1.1
        Pionnen resterendePionnen = spel.getResterendePionnen(),
                geplaatstePionnen = spel.getGeplaatstePionnen();

        // De KiesPionListener koppelt het kiezen van een pion terug naar de kiesPion method van deze task.
        bordForm.getBeschikbarePionnenForm().setKiesPionListener(new KiesPionActionListener(this));
        bordForm.getBeschikbarePionnenForm().setBeschikbarePionnen(resterendePionnen);
        // Stap 1.2
        bordForm.getBeschikbarePionnenForm().redraw();

        // De KiesPionListener koppelt het plaatsen van een pion terug naar de plaatsPion method van deze task.
        bordForm.getBord().setPlaatsPionListener(new PlaatsPionActionListener(this));
        bordForm.getBord().setStatusText(spel.getStatusText());
        bordForm.getBord().redraw();
        bordForm.getBord().voegPionnenToe(geplaatstePionnen);

        bordForm.getGeselecteerdePion().setGeselecteerdePion(spel.getGeselecteerdePion());
        bordForm.getGeselecteerdePion().redraw();

        bordForm.getButtonPanel().setQuartoListener(new GeefQuartoAanActionListener(spel, bordForm));
        bordForm.getButtonPanel().redraw();
    }

    public void execute(Spel spel, BordForm bord) {
        this.spel = spel;
        this.bordForm = bord;
        execute();
    }

    public boolean kiesPion(Pion pion) {
        if (spel.getGeselecteerdePion() != null) {
            return false;
        }
        spel.setGeselecteerdePion(pion);
        bordForm.getGeselecteerdePion().setGeselecteerdePion(pion);

        spel.volgendeSpeler(); // TODO: Verplaatsen naar spel?
        bordForm.getBord().setStatusText(spel.getStatusText());
        return true;
    }

    public boolean plaatsPion(int x, int y) {
        Pion huidigePion = spel.getGeselecteerdePion();
        if(huidigePion == null)
            return false;

        huidigePion.setX(x);
        huidigePion.setY(y);

        if(! spel.plaatsPion(huidigePion))
            return false;

        bordForm.plaatsPion(huidigePion);
        new ControleerQuarto(spel).run();

        spel.verwijderGeselecteerdePion();
        bordForm.getGeselecteerdePion().verwijderGeselecteerdePion();

        bordForm.getBord().setStatusText(spel.getStatusText());

        return true;
    }
}
