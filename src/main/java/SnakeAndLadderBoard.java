import lombok.Data;

import java.util.ArrayList;

@Data
public class SnakeAndLadderBoard {
    ArrayList<ArrayList<Integer>> board;

    public SnakeAndLadderBoard(ArrayList<ArrayList<Integer>> board) {
        this.board = board;
    }


}
