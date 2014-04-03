package ipsen1.quarto.business;

public class Spel {
    /**
     * Is er een Quarto?
     */
    private boolean quarto = false;

    private Pion huidigePion;
    private Bord spelBord;

    private Speler[] spelers;
    private int huidigeSpeler = 0;

    private int quartoBeurtTeller = 0;

    public Spel() {
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
        return huidigePion;
    }

    public void setHuidigePion(Pion huidigePion) {
        this.huidigePion = huidigePion;
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
