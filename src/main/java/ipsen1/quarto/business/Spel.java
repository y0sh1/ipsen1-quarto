package ipsen1.quarto.business;

public class Spel {
    // Is er een Quarto?
    private boolean quarto = false;

    private Bord spelBord;

    private Pion geselecteerdePion;

    private Speler[] spelers;
    private int aantalSpelers = 2,
                huidigeSpeler = 0;

    private int quartoBeurtTeller = 0;

    public Spel() {
        spelers = new Speler[2];
        spelers[0] = new Speler("Tim");
        spelers[1] = new Speler("Joshua");
        verkiesBeginnendeSpeler();

        spelBord = new Bord();
    }

    public void quartoAangeven() {
        // TODO: Implementeer mij
    }

    @Deprecated
    public void spelAfsluiten() {
        // TODO: Implementeer mij
    }

    public void volgendeSpeler() {
        huidigeSpeler++;

        if(huidigeSpeler > aantalSpelers - 1)
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


    public Pion getGeselecteerdePion() {
        return geselecteerdePion;
    }

    public void setGeselecteerdePion(Pion geselecteerdePion) {
        this.geselecteerdePion = geselecteerdePion;
    }

    public Speler[] getSpelers() {
        return spelers;
    }

    public Speler getHuidigeSpeler() {
        return spelers[huidigeSpeler];
    }

    public void verwijderGeselecteerdePion() {
        this.geselecteerdePion = null;
    }

    private boolean geselecteerdePionIsLeeg() {
        return geselecteerdePion == null;
    }

    public void verkiesBeginnendeSpeler() {
        huidigeSpeler = (int) Math.floor(Math.random() * aantalSpelers);
    }

    public void plaatsPion(Pion pion) {
        spelBord.setPion(pion);
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
        sb.append("<html>");

        sb.append(getHuidigeSpeler().getNaam());
        sb.append(" is aan de beurt.");
        sb.append("<br>");

        if(geselecteerdePionIsLeeg())
            sb.append("Kies een stuk uit voor de tegenstander.");
        else
            sb.append("Plaats het stuk.");

        sb.append("</html>");

        return sb.toString();
    }
}
