package ipsen1.quarto.task;

import ipsen1.quarto.business.Spel;
import ipsen1.quarto.business.Bord;

public class ControleerQuarto extends Task {
    private Spel spel;
    private Bord bord;

    public ControleerQuarto(Spel spel) {
        this.spel = spel;
        bord = spel.getBord();
    }

    @Override
    public boolean validate() {
        return spel != null;
    }

    @Override
    public void execute() {
        // TODO: Implementeer mij
        System.out.println("Controleer Quarto execute() start");

    }

    public boolean isGeldigeQuarto() {
        // TODO: Implementeer mij
        return false;
    }
}
