package com.mycompany.minesweeperBot.Sites;

import com.mycompany.minesweeperBot.Board;
import com.mycompany.minesweeperBot.utils.InteractionUtils;
import com.mycompany.minesweeperBot.Models.CellCoordinate;
import com.mycompany.minesweeperBot.Models.CellState;
import com.mycompany.minesweeperBot.Models.Difficulty;
import com.mycompany.minesweeperBot.Models.GameStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * This should contain purely actions taken on the page and methods relying on internal data
 */
public class MineSweeperOnline extends BasePage {

    private By beginner = By.className("level1-link");
    private By intermediate = By.className("level2-link");
    private By expert = By.className("level3-link");

    private By topAreaFace = By.id("top_area_face");

    public int boardSizeX;
    public int boardSizeY;

    public MineSweeperOnline() {
        this.baseUrl = "https://minesweeper.online"; //"https://minesweeper.online/game/5106996301";
        this.driver = setupDriver();
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

    public Board readBoard() {
        // do I want to create a new board every time and return it?
        Board board = new Board(boardSizeY, boardSizeX);
        List<WebElement> cellElements = getCellElements();
        List<String> cellsClasses = cellElements.stream().map(item -> item.getAttribute("class")).collect(Collectors.toList());
        List<CellState> cellStates = getCellStatesFromClassList(cellsClasses);
        board.updateFromArray(cellStates);
        return board;
    }

    private List<WebElement> getCellElements() {
        WebElement boardElement = driver.findElement(boardBy);
        List<WebElement> cellElements = boardElement.findElements(cellBy);
        return cellElements;
    }

    private List<CellState> getCellStatesFromClassList(List<String> cellsClasses) {
        List<CellState> cellStates = new ArrayList<>(boardSizeX*boardSizeY);
        for(String cellClass : cellsClasses) {
            String[] classes = cellClass.split("\\s+");
            if(classes.length == 3) {
                cellStates.add(classToCellState(classes[2]));
            } else if (classes.length == 4) {
                cellStates.add(classToCellState(classes[3]));
            }
        }

        return cellStates;
    }

    private static final Map<String, CellState> CLASS_TO_STATE = Map.ofEntries(
        Map.entry("hdd_closed", CellState.CLOSED),
        Map.entry("hdd_flag", CellState.FLAGGED),
        Map.entry("hdd_type0", CellState.EMPTY),
        Map.entry("hdd_type1", CellState.ONE),
        Map.entry("hdd_type2", CellState.TWO),
        Map.entry("hdd_type3", CellState.THREE),
        Map.entry("hdd_type4", CellState.FOUR),
        Map.entry("hdd_type5", CellState.FIVE),
        Map.entry("hdd_type6", CellState.SIX),
        Map.entry("hdd_type7", CellState.SEVEN),
        Map.entry("hdd_type8", CellState.EIGHT)
    );

    private CellState classToCellState(String classStr) {
        CellState state = CLASS_TO_STATE.get(classStr);
        if (state == null) {
            throw new IllegalArgumentException("Unknown cell class: " + classStr);
        }
        return state;
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
