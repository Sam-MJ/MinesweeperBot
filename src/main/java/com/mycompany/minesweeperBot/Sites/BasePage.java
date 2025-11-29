package com.mycompany.minesweeperBot.Sites;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mycompany.minesweeperBot.Models.Difficulty;
import com.mycompany.minesweeperBot.Models.GameStatus;
import com.mycompany.minesweeperBot.Models.CellCoordinate;
import com.mycompany.minesweeperBot.Board;

public abstract class BasePage {

    protected WebDriver driver;
    protected String baseUrl;
    protected By boardBy;
    protected By cellBy;
    protected By reset;

    public abstract void startGame(Difficulty difficulty);
    public abstract void resetGame();

    public abstract void clickCell(CellCoordinate coordinate, boolean leftClick);
    public abstract Board readBoard();
    public abstract GameStatus getGameStatus();

    public String getBaseUrl(){
        return baseUrl;
    }

    public By getBoardBy(){
        return boardBy;
    }

    public By getCellBy(){
        return cellBy;
    }
}
