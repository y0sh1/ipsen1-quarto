package ipsen1.quarto.task;

import ipsen1.quarto.business.Spel;

public class ControleerQuarto extends Task {
    private Spel spel;

    public ControleerQuarto(Spel spel) {
        this.spel = spel;
    }

    @Override
    public boolean validate() {
        return spel != null;
    }

    @Override
    public void execute() {
        // TODO: Implementeer mij
        System.out.println("OMG QUARTO!!1!");
    }

    public boolean isGeldigeQuarto() {
        // TODO: Implementeer mij
        return false;
    }
}
