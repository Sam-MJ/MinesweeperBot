package com.mycompany.minesweeperBot;

import java.util.List;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mycompany.minesweeperBot.Sites.BasePage;

public class BoardInteractions {

    private BasePage basePage;
    private Board board;
    private WebDriver driver;

    public BoardInteractions(BasePage page, Board board){
        this.basePage = page;
        this.board = board;
        this.driver = setup();
    }

    private WebDriver setup(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(basePage.getBaseUrl());

        return driver;
    }

    public Board updateBoard(){

        WebElement boardElement = driver.findElement(basePage.getBoardBy());

        List<WebElement> cellElements = boardElement.findElements(basePage.getBoardBy());

        Board gameStateBoard = basePage.convertBoard(cellElements, board);

        return gameStateBoard;
    }

    //public static void markMines(List<coordinates)
    //public static void clickSafe(List<coordinates)
}
