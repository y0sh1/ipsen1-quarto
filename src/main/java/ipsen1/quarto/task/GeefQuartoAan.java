package ipsen1.quarto.task;

import ipsen1.quarto.business.Spel;

public class GeefQuartoAan extends Task {
    private Spel spel;

    public GeefQuartoAan(Spel spel) {
        this.spel = spel;
    }

    @Override
    public boolean validate() {
        return spel != null;
    }

    @Override
    public void execute() {
        new ControleerQuarto(spel).execute();
    }
}
