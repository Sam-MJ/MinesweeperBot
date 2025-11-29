package com.mycompany.minesweeperBot;

import java.time.Duration;

import com.mycompany.minesweeperBot.Sites.MineSweeperOnline;
import com.mycompany.minesweeperBot.Sites.BasePage;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        BasePage gamePage = new MineSweeperOnline();
        GameController gameController = new GameController(gamePage);

        gameController.run();
    }
}
