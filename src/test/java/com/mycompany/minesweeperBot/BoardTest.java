package com.mycompany.minesweeperBot;

import com.mycompany.minesweeperBot.Models.CellState;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class BoardTest {

    @Test
    public void updateBoardFromArrayTest() {
        Board board = new Board(2, 3);

        List<CellState> cellStateList = Arrays.asList(
            CellState.EMPTY,
            CellState.ONE,
            CellState.TWO,
            CellState.THREE,
            CellState.FOUR,
            CellState.FIVE
        );
        board.updateFromArray(cellStateList);

        String expectedBoardString = board.toString();
        System.out.println(expectedBoardString);

        assertEquals("_ 1 2 \n3 4 5 \n", expectedBoardString);
    }
}
