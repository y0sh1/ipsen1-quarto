package ipsen1.quarto.task;

import ipsen1.quarto.business.Spel;
import ipsen1.quarto.form.BordForm;

public class GeefQuartoAan extends Task {
    private Spel spel;
    private BordForm bordForm;

    public GeefQuartoAan(Spel spel, BordForm bordForm) {
        this.spel = spel;
        this.bordForm = bordForm;
    }

    @Override
    public boolean validate() {
        return (spel != null) && spel.isQuarto();
    }

    @Override
    public void execute() {
        String huidigeSpeler = spel.getHuidigeSpeler().getNaam();

        if(spel.isQuarto()) {
            bordForm.maakWinnaarBekend(huidigeSpeler);
            spel.spelAfsluiten();
        } else { // Geen geldige Quarto. Geef dit weer en eindig de beurt.
            bordForm.geefOngeldigeQuartoAan(spel.getStatusText(), huidigeSpeler);
            spel.volgendeSpeler();
        }
    }
}
