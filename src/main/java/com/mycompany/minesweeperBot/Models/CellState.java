package com.mycompany.minesweeperBot.Models;

public enum CellState {
    CLOSED("#"),
    FLAGGED("X"),
    EMPTY("_"),
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8");

    private final String symbol;

    CellState(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
