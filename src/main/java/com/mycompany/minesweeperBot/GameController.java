package com.mycompany.minesweeperBot;

import com.mycompany.minesweeperBot.Models.Difficulty;
import com.mycompany.minesweeperBot.Models.GameStatus;
import com.mycompany.minesweeperBot.Sites.BasePage;

public class GameController {

    private BasePage gamePage;


    public GameController(BasePage gamePage) {
        this.gamePage = gamePage;
    }

    public void run() {
        gamePage.startGame(Difficulty.Beginner);

        while(gamePage.getGameStatus() == GameStatus.InProgress) {
            Board board = gamePage.readBoard();
            System.out.println(board.toString());
        }

    }
    // start game
    // reset on loss
    // end game and close browser.
}
