package ipsen1.quarto.business;

import java.util.ArrayList;
import java.util.List;

public class Bord {
    private Pion[][] matrix;

    public final int BOARD_WIDTH = 4,
                     BOARD_HEIGHT = 4;

    private List<Pion[][]> blackListedCombinaties = new ArrayList<>();

    public Bord() {
        matrix = new Pion[BOARD_HEIGHT][BOARD_WIDTH];
    }

    public void blackListHuidigeCombinatie() {
        blackListedCombinaties.add(matrix.clone());
    }

    public Pion[][] getMatrix() {
        return matrix;
    }

    public List<Pion[][]> getBlackListedCombinaties() {
        return blackListedCombinaties;
    }
}
