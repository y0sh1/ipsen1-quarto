package ipsen1.quarto.business;

public class Pion {
    private Vorm vorm;
    private Kleur kleur;
    private Hoogte hoogte;
    private Hol hol;

    private int x = 0, y = 0;

    public Pion() {
        // TODO: Is deze constructor nodig?
    }

    public Pion(Vorm vorm, Kleur kleur, Hoogte hoogte, Hol hol) {
        this.vorm = vorm;
        this.kleur = kleur;
        this.hoogte = hoogte;
        this.hol = hol;
    }

    public Pion(Vorm vorm, Kleur kleur, Hoogte hoogte, Hol hol, int x, int y) {
        this.vorm = vorm;
        this.kleur = kleur;
        this.hoogte = hoogte;
        this.hol = hol;
        this.x = x;
        this.y = y;
    }

    /**
     * Get the filename for this pawn.
     * @return String
     */
    public String toFileName() {
        StringBuilder sb = new StringBuilder(basePath);
        sb.append(hoogte.name());
        sb.append('_');
        sb.append(vorm.name());
        sb.append('_');
        sb.append(hol.name());
        sb.append('_');
        sb.append(kleur.name());

        sb.append(".png");

        return sb.toString().toLowerCase();
    }


    /**
     * Basispad naar de map met pion-afbeeldingen
     */
    private static final String basePath = "src/main/resources/pionnen/";

    public enum Vorm {
        ROND, VIERKANT
    }

    public enum Kleur {
        ZWART, WIT
    }

    public enum Hoogte {
        HOOG, LAAG
    }

    public enum Hol {
        HOL, VOL
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
