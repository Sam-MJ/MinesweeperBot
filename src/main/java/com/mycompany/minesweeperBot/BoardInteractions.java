package com.mycompany.minesweeperBot;
import org.openqa.selenium.WebDriver;


import com.mycompany.minesweeperBot.Sites.BasePage;

/**
 * Class to interface between the page board and the internal board
 * Place for board solving etc? maybe rename to board solver
 */

public class BoardInteractions {

    private BasePage gamePage;
    private Board board;
    private WebDriver driver;

    public BoardInteractions(WebDriver driver, BasePage page, Board board){
        this.gamePage = page;
        this.board = board;
        this.driver = driver;
    }

    /**
     *  Get board from game page and update internal game board.
     * */
    public Board updateBoard(){
       return gamePage.readBoard();
    }

    //public static void markMines(List<coordinates)
    //public static void clickSafe(List<coordinates)
}
