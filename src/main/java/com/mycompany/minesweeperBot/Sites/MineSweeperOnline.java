package com.mycompany.minesweeperBot.Sites;

import com.mycompany.minesweeperBot.Board;
import com.mycompany.minesweeperBot.utils.InteractionUtils;
import com.mycompany.minesweeperBot.Models.CellCoordinate;
import com.mycompany.minesweeperBot.Models.Difficulty;
import com.mycompany.minesweeperBot.Models.GameStatus;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This should contain purely actions taken on the page and methods relying on internal data
 */
public class MineSweeperOnline extends BasePage {

    private By beginner = By.className("level1-link");
    private By intermediate = By.className("level2-link");
    private By expert = By.className("level3-link");

    private By topAreaFace = By.id("top-area-face");


    public int boardSizeX;
    public int boardSizeY;

    public MineSweeperOnline(WebDriver driver){
        this.driver = driver;
        this.baseUrl = "https://minesweeper.online"; //"https://minesweeper.online/game/5106996301";
        this.boardBy = By.id("AreaBlock");
        this.cellBy = By.className("cell");
    }

    public void startGame(Difficulty difficulty) {
        switch (difficulty) {
            case Beginner:
                InteractionUtils.clickButton(driver, beginner);
                boardSizeX = 9;
                boardSizeY = 9;
                break;
            case Intermediate:
                InteractionUtils.clickButton(driver, intermediate);
                boardSizeX = 16;
                boardSizeY = 16;
                break;
            case Expert:
                InteractionUtils.clickButton(driver, expert);
                boardSizeX = 30;
                boardSizeY = 16;
                break;
            default:
                break;
        }
    }

    public void resetGame() {
        InteractionUtils.clickButton(driver, reset);
    }

    public void clickCell(CellCoordinate coordinate, boolean leftClick) {
        String cellID = String.format("cell_%d_%d", coordinate.getX(), coordinate.getY());
        By cellBy = By.id(cellID);
        InteractionUtils.clickButton(driver, cellBy, leftClick);
    }

    private List<WebElement> getCellElements() {
        WebElement boardElement = driver.findElement(boardBy);
        List<WebElement> cellElements = boardElement.findElements(cellBy);
        return cellElements;
    }

    public Board readBoard() {
        // do I want to create a new board every time and return it?
        Board board = new Board(boardSizeY, boardSizeX);

        List<WebElement> cellElements = getCellElements();
        // TODO find out which element classes show what numbers, update the game state board to those numbers and return.
        List<String> cellsClasses = cellElements.stream().map(item -> item.getAttribute("class")).collect(Collectors.toList());
        // filter classes to show number.
        // update board to those values
        // return the board.


        return board;
    }

    public GameStatus getGameStatus() {
        WebElement topAreaFaceElement = driver.findElement(topAreaFace);
        if(topAreaFaceElement.getAttribute("class").contains("lose")) {
            return GameStatus.Lost;
        } else if (topAreaFaceElement.getAttribute("class").contains("win")) {
            return GameStatus.Won;
        } else {
            return GameStatus.InProgress;
        }
    }

}
