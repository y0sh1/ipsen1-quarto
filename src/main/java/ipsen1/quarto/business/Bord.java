package ipsen1.quarto.business;

import java.util.ArrayList;
import java.util.List;

public class Bord {
    private int[][] matrix;

    public final int BOARD_WIDTH = 4,
                     BOARD_HEIGHT = 4;

    private List<int[][]> blackListedCombinaties = new ArrayList<int[][]>();

    public Bord() {
        matrix = new int[BOARD_HEIGHT][BOARD_WIDTH];
    }

    public void blackListHuidigeCombinatie() {
        blackListedCombinaties.add(matrix.clone());
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public List<int[][]> getBlackListedCombinaties() {
        return blackListedCombinaties;
    }
}
