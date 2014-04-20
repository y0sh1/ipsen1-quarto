package ipsen1.quarto.business;

import java.util.ArrayList;
import java.util.List;

public class Bord {
    private Pion[][] matrix;

    public final int width = 4,
                     height = 4;

    private List<int[]> blackListedCombinaties = new ArrayList<>();

    public Bord() {
        matrix = new Pion[height][width];
    }

    public boolean setPion(Pion pion) {
        if(matrix[pion.getY()][pion.getX()] == null) {
            matrix[pion.getY()][pion.getX()] = pion;
            return true;
        }
        return false;
    }

    public void blackListHuidigeCombinatie(int[] combinatie) {
        blackListedCombinaties.add(combinatie);
    }

    public Pion[][] getMatrix() {
        return matrix;
    }

    public List<int[]> getBlackListedCombinaties() {
        return blackListedCombinaties;
    }
}
