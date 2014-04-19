package ipsen1.quarto.business;

import ipsen1.quarto.form.BordForm;
import ipsen1.quarto.form.bord.GeselecteerdePionForm;

public class Spel {
    /**
     * Is er een Quarto?
     */
    private boolean quarto = false;

    private BordForm bordForm;
    private Pion huidigePion;
    private Bord spelBord;

    private Speler[] spelers;
    private int huidigeSpeler = 0;

    private int quartoBeurtTeller = 0;

    private Spel() {}

    public Spel(BordForm bordForm) {
        this.bordForm = bordForm;
//        this.bordForm = bordForm;
        spelers = new Speler[2];
        spelBord = new Bord();
    }

    public void quartoAangeven() {
        // TODO: Implementeer mij
    }

    public void spelAfsluiten() {
        // TODO: Implementeer mij
    }

    public void volgendeSpeler() {
        // TODO: Implementeer mij
    }

    public boolean isQuarto() {
        return quarto;
    }

    public void setQuarto(boolean quarto) {
        this.quarto = quarto;
    }

    public Pion[] getGeplaatstePionnen() {
        // TODO: Implementeer mij
        return new Pion[0];
    }

    public Bord getBord() {
        return spelBord;
    }

    public Pion getHuidigePion() {
        //Auteur method: Tim Vane
        return huidigePion;
    }

    public void setHuidigePion(Pion huidigePion) {
        //Auteur method: Tim Vane
        this.huidigePion = huidigePion;
        bordForm.setGeselecteerdePion();
    }

    public void verwijderHuidigePion() {
        //Auteur method: Tim Vane
        this.huidigePion = null;
        bordForm.verwijderGeselecteerdePion();
    }

    public boolean huidigePionIsEmpty() {
        //Auteur method: Tim Vane
        if (huidigePion == null)
            return true;
        else
            return false;
    }

    public void verkiesBeginnendeSpeler() {
        // TODO: Implementeer mij
    }

    public void plaatsPion() {
        // TODO: Implementeer mij
    }

    public void slaSpelOp() {
        // TODO: Implementeer mij
    }

    public void laadSaveGame() {
        // TODO: Implementeer mij
    }

    public boolean staatQuartoBeurtTellerAan() {
        // TODO: Implementeer mij
        return false;
    }

    public void verhoogQuartoBeurtTeller() {
        quartoBeurtTeller++;
    }

    public void deactiveerQuartoBeurtTeller() {
        quartoBeurtTeller = 0;
    }
}
