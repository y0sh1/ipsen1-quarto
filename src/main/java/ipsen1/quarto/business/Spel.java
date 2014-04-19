package ipsen1.quarto.business;

import ipsen1.quarto.form.BordForm;
import ipsen1.quarto.form.bord.GeselecteerdePionForm;

public class Spel {
    // Is er een Quarto?
    private boolean quarto = false;

    private Bord spelBord;

    private Pion huidigePion;

    private Speler[] spelers;
    private int aantalSpelers = 2,
                huidigeSpeler = 0;

    private int quartoBeurtTeller = 0;

    public Spel() {
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
        //Auteur method: Tim Vane
        return huidigePion;
    }

    public void setHuidigePion(Pion huidigePion) {
        //Auteur method: Tim Vane
        this.huidigePion = huidigePion;
    }

    public Speler[] getSpelers() {
        return spelers;
    }

    public Speler getHuidigeSpeler() {
        return spelers[huidigeSpeler];
    }

    public void verwijderHuidigePion() {
        //Auteur method: Tim Vane
        this.huidigePion = null;
    }

    public boolean huidigePionIsEmpty() {
        //Auteur method: Tim Vane
        if (huidigePion == null)
            return true;
        else
            return false;
    }

    public void verkiesBeginnendeSpeler() {
        huidigeSpeler = (int) Math.floor(Math.random() * aantalSpelers);
    }

    public void plaatsPion(Pion pion) {
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

    public String getStatusText() {
        StringBuilder sb = new StringBuilder();

        sb.append(getHuidigeSpeler().getNaam());
        sb.append(" is aan de beurt.");
        sb.append("Kies een stuk uit voor de tegenstander.");

        return sb.toString();
    }
}
