package com.mycompany.minesweeperBot;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mycompany.minesweeperBot.Models.Difficulty;
import com.mycompany.minesweeperBot.Models.GameStatus;
import com.mycompany.minesweeperBot.Sites.BasePage;

public class GameController {

    private BasePage gamePage;
    private WebDriver driver;

    public GameController(BasePage gamePage) {
        this.gamePage = gamePage;
        this.driver = this.setup();
    }

    private WebDriver setup(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(this.gamePage.getBaseUrl());

        return driver;
    }

    private void run() {
        gamePage.startGame(Difficulty.Beginner);

        while(gamePage.getGameStatus() == GameStatus.InProgress) {
            gamePage.readBoard();
        }

    }
    // start game
    // reset on loss
    // end game and close browser.
}
