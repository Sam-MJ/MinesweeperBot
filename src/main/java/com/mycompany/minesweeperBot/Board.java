package com.mycompany.minesweeperBot;

public class Board {

    private enum CellState{
        CLOSED,
        FLAGGED,
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT;

        @Override
        public String toString(){
            switch (this) {
                case CLOSED: return "_";
                case FLAGGED: return "X";
                case ONE: return "1";
                case TWO: return "2";
                case THREE: return "3";
                case FOUR: return "4";
                case FIVE: return "5";
                case SIX: return "6";
                case SEVEN: return "7";
                case EIGHT: return "8";

                default:
                    return super.toString();
            }
        }
    }

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
