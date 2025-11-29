package com.mycompany.minesweeperBot;
import com.mycompany.minesweeperBot.Models.CellState;

/**
 * internal board to be solved on.
 */
public class Board {

    private CellState[][] board;

    public Board(int height, int width){

        this.board = new CellState[height][width];

        for (int y = 0; y < this.board.length; y++){
            for (int x = 0; x < this.board[y].length; x++){
                this.board[y][x] = CellState.CLOSED;
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder returnString = new StringBuilder();

        for (CellState[] row : board){
            for (CellState cell : row){
                returnString.append(cell.toString()).append(" ");
            }
            returnString.append("\n");
        }

        return returnString.toString();
    }
}
