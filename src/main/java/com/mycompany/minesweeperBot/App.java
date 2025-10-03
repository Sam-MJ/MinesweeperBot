package com.mycompany.minesweeperBot;

import com.mycompany.minesweeperBot.Sites.MineSweeperOnline;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Board board = new Board(4,4);
        System.out.println(board.toString());

        /* BoardInteractions boardInteractor = new BoardInteractions(new MineSweeperOnline(), board);
        System.out.println(boardInteractor.updateBoard()); */
    }
}
