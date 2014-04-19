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
    private Pion[][] matrix;

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
        matrix = bord.getMatrix();
        isGeldigeQuarto();
    }

    public boolean isGeldigeQuarto() {
        // TODO: Implementeer mij
//        for(int x = 0; x < matrix.length; x++) {
//            for(int y = 0; y < matrix.length; y++) {
//                if(matrix[x])
//            }
//        }


        try {
            for(int x = 0; x < matrix.length - 1; x++){
                if(matrix[0][x].getHol() == matrix[0][x + 1].getHol()) {
                    System.out.println("isGeldigeQuart() == true");
                    return true;
                }
            }
        } catch (NullPointerException ex) {
//            return false;
        }
        System.out.println("isGeldigeQuart() == false");
        return false;
    }
}
