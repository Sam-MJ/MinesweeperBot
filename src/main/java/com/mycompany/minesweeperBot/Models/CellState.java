package com.mycompany.minesweeperBot.Models;

public enum CellState {
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
