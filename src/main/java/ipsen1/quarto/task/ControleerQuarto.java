package ipsen1.quarto.task;

import ipsen1.quarto.business.Pion;
import ipsen1.quarto.business.Spel;
import ipsen1.quarto.business.Bord;

import java.util.Arrays;
import java.util.List;

public class ControleerQuarto extends Task {
    private Spel spel;
    private Bord bord;
    private List<int[]> blacklistedcombinaties;
    private boolean staatQuartoBeurtTellerAan;
    private Pion[][] matrix;
    private int[] combinatie;

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
        matrix = bord.getMatrix();
        blacklistedcombinaties = bord.getBlackListedCombinaties();
        staatQuartoBeurtTellerAan = spel.staatQuartoBeurtTellerAan();
        boolean geldigeQuarto = isGeldigeQuarto();

        if(geldigeQuarto && !staatQuartoBeurtTellerAan) {
            spel.setQuarto(true);
            spel.verhoogQuartoBeurtTeller();
        }

        if(geldigeQuarto && staatQuartoBeurtTellerAan) {
            if(spel.getQuartoBeurtTeller() > 1) {
                bord.blackListHuidigeCombinatie(combinatie);
                spel.setQuarto(false);
                spel.deactiveerQuartoBeurtTeller();
            } else {
                spel.verhoogQuartoBeurtTeller();
            }
        }
    }

    private boolean isGeldigeQuarto() {
        if(horizontalCheck() || verticalCheck() || diagonalCheck()) {
            return true;
        }

        return false;
    }

    private boolean horizontalCheck() {
        for(int y = 0; y < matrix.length; y++) {
            if(checkCombinatie(matrix[y][0], matrix[y][1], matrix[y][2], matrix[y][3])) {
                if(!combinationExistsInBlacklist(y, 0, y, 3)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean verticalCheck() {
        for(int x = 0; x < matrix.length; x++) {
            if(checkCombinatie(matrix[0][x], matrix[1][x], matrix[2][x], matrix[3][x])) {
                if(!combinationExistsInBlacklist(x, 0, x, 3)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean diagonalCheck() {
        if(checkCombinatie(matrix[0][0], matrix[1][1], matrix[2][2], matrix[3][3])) {
            if(!combinationExistsInBlacklist(0, 0, 3, 3)) {
                return true;
            }
        }

        if(checkCombinatie(matrix[3][0], matrix[2][1], matrix[1][2], matrix[0][3])) {
            if(!combinationExistsInBlacklist(3, 0, 0, 3)) {
                return true;
            }
        }
        return false;
    }

    private boolean combinationExistsInBlacklist(int xBegin, int yBegin, int xEind, int yEind) {
        combinatie = new int[]{xBegin, yBegin, xEind, yEind};
        for(int i = 0; i < blacklistedcombinaties.size(); i ++) {
            int[] blacklistIndex = blacklistedcombinaties.get(i);
            if(Arrays.equals(blacklistIndex, combinatie)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCombinatie(Pion p1, Pion p2, Pion p3, Pion p4) {
        try {
//        check of deze combinatie bestaat uit pionnen met dezelfde holte.
            if (p1.getHol() == p2.getHol() && p1.getHol() == p3.getHol()
                    && p1.getHol() == p4.getHol())
                return true;

//        check of deze combinatie bestaat uit pionnen met dezelfde hoogte.
            if (p1.getHoogte() == p2.getHoogte() && p1.getHoogte() == p3.getHoogte()
                    && p1.getHoogte() == p4.getHoogte())
                return true;

//        check of deze combinatie bestaat uit pionnen met dezelfde kleur.
            if (p1.getKleur() == p2.getKleur() && p1.getKleur() == p3.getKleur()
                    && p1.getKleur() == p4.getKleur())
                return true;

//        check of deze combinatie bestaat uit pionnen met dezelfde vorm.
            if (p1.getVorm() == p2.getVorm() && p1.getVorm() == p3.getVorm()
                    && p1.getVorm() == p4.getVorm())
                return true;

        } catch(NullPointerException ex) { }

//        Als er een NullPointerException of geen combinatie is, return false
        return false;
    }
}
