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
    private int aantalSpelers = 2,
                huidigeSpeler = 0;

    private int quartoBeurtTeller = 0;

    private Spel() {}

    public Spel(BordForm bordForm) {
        this.bordForm = bordForm;
//        this.bordForm = bordForm;
        spelers = new Speler[2];
        spelers[0] = new Speler("Zwart");
        spelers[1] = new Speler("Wit");
        verkiesBeginnendeSpeler();

        spelBord = new Bord();
    }

    public void quartoAangeven() {
        // TODO: Implementeer mij
    }

    public void spelAfsluiten() {
        // TODO: Implementeer mij
    }

    public void volgendeSpeler() {
        huidigeSpeler++;

        if(huidigeSpeler > aantalSpelers)
            huidigeSpeler = 0;
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
        return huidigePion;
    }

    public void setHuidigePion(Pion huidigePion) {
        this.huidigePion = huidigePion;
        bordForm.setGeselecteerdePion();

    }

    public Speler[] getSpelers() {
        return spelers;
    }

    public Speler getHuidigeSpeler() {
        return spelers[huidigeSpeler];
    }

    public void verkiesBeginnendeSpeler() {
        huidigeSpeler = (int) Math.floor(Math.random() * aantalSpelers);
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
