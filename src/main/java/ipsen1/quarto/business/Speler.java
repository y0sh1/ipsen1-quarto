package ipsen1.quarto.business;

import java.io.Serializable;

public class Speler implements Serializable {
    private String naam;

    public Speler(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}
