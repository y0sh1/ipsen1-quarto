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
        System.out.println("Controleer Quarto execute() start");
        blacklistedcombinaties = bord.getBlackListedCombinaties();
        staatQuartoBeurtTellerAan = spel.staatQuartoBeurtTellerAan();
        matrix = bord.getMatrix();
        isGeldigeQuarto();
    }

    public boolean isGeldigeQuarto() {
        if(horizontalCheck() || verticalCheck() || diagonalCheck()) {
            return true;
        }


        System.out.println("isGeldigeQuart() == false");
        return false;
    }

    public boolean checkCombinatie(Pion p1, Pion p2, Pion p3, Pion p4) {
        try {
//        check of deze combinatie bestaat uit pionnen met dezelfde holte.
            if (p1.getHol() == p2.getHol() && p1.getHol() == p3.getHol()
                    && p1.getHol() == p4.getHol()) {
                System.out.println("hol is true");
                return true;

            }

//        check of deze combinatie bestaat uit pionnen met dezelfde hoogte.
            if (p1.getHoogte() == p2.getHoogte() && p1.getHoogte() == p3.getHoogte()
                    && p1.getHoogte() == p4.getHoogte()) {
                System.out.println("hoogte is true");
                return true;
            }

//        check of deze combinatie bestaat uit pionnen met dezelfde kleur.
            if (p1.getKleur() == p2.getKleur() && p1.getKleur() == p3.getKleur()
                    && p1.getKleur() == p4.getKleur()) {
                System.out.println("kleur is true");
                return true;
            }

//        check of deze combinatie bestaat uit pionnen met dezelfde vorm.
            if (p1.getVorm() == p2.getVorm() && p1.getVorm() == p3.getVorm()
                    && p1.getVorm() == p4.getVorm()) {
                System.out.println("vorm is true");
                return true;
            }
        } catch(NullPointerException ex) {
            System.out.println("nullpointer");
        }
        return false;
    }

    public boolean horizontalCheck() {
        for(int y = 0; y < matrix.length; y++) {
            if(checkCombinatie(matrix[y][0], matrix[y][1], matrix[y][2], matrix[y][3])) {
                System.out.println("horizontaal match in rij: " + y);
                return true;
            }
        }
        return false;
    }

    public boolean verticalCheck() {
        for(int x = 0; x < matrix.length; x++) {
            if(checkCombinatie(matrix[0][x], matrix[1][x], matrix[2][x], matrix[3][x])) {
                System.out.println("verticaal match in kolom: " + x);
                return true;
            }
        }
        return false;
    }

    public boolean diagonalCheck() {
        if(checkCombinatie(matrix[0][0], matrix[1][1], matrix[2][2], matrix[3][3])) {
            System.out.println("diagonaal1 match");
            return true;
        }
        if(checkCombinatie(matrix[3][0], matrix[2][1], matrix[1][2], matrix[0][3])) {
            System.out.println("diagonaal2 match");
            return true;
        }
        return false;
    }
}
