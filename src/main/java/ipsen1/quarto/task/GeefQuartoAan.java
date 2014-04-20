package ipsen1.quarto.task;

import ipsen1.quarto.business.Spel;
import ipsen1.quarto.form.BordForm;

public class GeefQuartoAan extends Task {
    private Spel spel;
    private BordForm bordForm;
    String huidigeSpeler;

    public GeefQuartoAan(Spel spel, BordForm bordForm) {
        this.spel = spel;
        this.bordForm = bordForm;
        huidigeSpeler = spel.getHuidigeSpeler().getNaam();
    }

    @Override
    public boolean validate() {
        if(spel!= null && spel.isQuarto())
            return true;
//        Geen geldige Quarto. Geef dit weer en eindig de beurt.
        spel.volgendeSpeler();
        bordForm.geefOngeldigeQuartoAan(spel.getStatusText(), huidigeSpeler);
        return false;
    }

    @Override
    public void execute() {
        bordForm.maakWinnaarBekend(huidigeSpeler);
        spel.spelAfsluiten();
    }
}
