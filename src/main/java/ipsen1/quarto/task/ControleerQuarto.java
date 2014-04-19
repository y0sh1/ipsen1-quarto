package ipsen1.quarto.task;

import ipsen1.quarto.business.Pion;
import ipsen1.quarto.business.Spel;
import ipsen1.quarto.business.Bord;

import java.util.List;

public class ControleerQuarto extends Task {
    private Spel spel;
    private Bord bord;
    private List<Pion[][]> blacklistedcombinaties;
    private boolean staatQuartoBeurtTellerAan;

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
        blacklistedcombinaties = bord.getBlackListedCombinaties();
        staatQuartoBeurtTellerAan = spel.staatQuartoBeurtTellerAan();
        isGeldigeQuarto();
    }

    public boolean isGeldigeQuarto() {
        // TODO: Implementeer mij
        
        return false;
    }
}
