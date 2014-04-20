package ipsen1.quarto.business;

import ipsen1.quarto.task.SluitSpelAf;

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
        spelers = new Speler[] {
            new Speler("Speler 1"),
            new Speler("Speler 2")
        };
        spelBord = new Bord();
    }

    public void spelAfsluiten() {
        new SluitSpelAf().run();
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

    public void setSpelers(Speler[] spelers) {
        this.spelers = spelers;
        verkiesBeginnendeSpeler();
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

    public boolean plaatsPion(Pion pion) {
        return spelBord.setPion(pion);
    }

    public void slaSpelOp() {
        // TODO: Implementeer mij
    }

    public void laadSaveGame() {
        // TODO: Implementeer mij
    }

    public int getQuartoBeurtTeller() {
        return quartoBeurtTeller;
    }

    public boolean staatQuartoBeurtTellerAan() {
        if(quartoBeurtTeller > 0)
            return true;
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
