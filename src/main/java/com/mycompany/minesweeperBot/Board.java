package com.mycompany.minesweeperBot;
import com.mycompany.minesweeperBot.Models.CellState;
import java.util.List;

/**
 * internal board to be solved on.
 */
public class Board {

    private CellState[][] board;
    private int width;
    private int height;

    public Board(int height, int width) {

        this.board = new CellState[height][width];
        this.height = height;
        this.width = width;

        for (int y = 0; y < this.board.length; y++){
            for (int x = 0; x < this.board[y].length; x++){
                this.board[y][x] = CellState.CLOSED;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder();

        for (CellState[] row : board){
            for (CellState cell : row){
                returnString.append(cell.toString()).append(" ");
            }
            returnString.append("\n");
        }

        return returnString.toString();
    }

    public void updateFromArray(List<CellState> cellStateList) {
        int y = 0;
        int x = 0;
        for(CellState cellState : cellStateList) {
            this.board[y][x] = cellState;
            if(x < width - 1) {
                x++;
            } else {
                x = 0;
                y++;
            }
        }
    }
}
