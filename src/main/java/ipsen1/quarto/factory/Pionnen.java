package ipsen1.quarto.factory;

import ipsen1.quarto.business.Pion;
import static ipsen1.quarto.business.Pion.*;

import java.util.ArrayList;

public class Pionnen extends ArrayList<Pion> {
    public Pion[] getResterendePionnen() {
        // TODO: Implementeer mij
        return new Pion[0];
    }

    public Pion getPion() {
        // TODO: Implementeer mij
        return new Pion();
    }

    /**
     * Return an array of all unique pawn combinations.
     * @return Pion[]
     */
    public static Pion[] all() {
        Pion[] pionnen = new Pion[16];
        int i = 0;

        for(Vorm v : Vorm.values()) {
            for (Kleur k : Kleur.values()) {
                for (Hoogte h : Hoogte.values()) {
                    for (Hol ho : Hol.values()) {
                        pionnen[i] = new Pion(v, k, h, ho);
                        i++;
                    }
                }
            }
        }

        return pionnen;
    }
}
