package com.mycompany.minesweeperBot.Sites;

import com.mycompany.minesweeperBot.Board;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MineSweeperOnline extends BasePage {

    public MineSweeperOnline(){
        this.baseUrl = "https://minesweeper.online"; //"https://minesweeper.online/game/5106996301";
        this.boardBy = By.id("AreaBlock");
        this.cellBy = By.className("cell");
    }

    public Board convertBoard(List<WebElement> cellElements, Board board){
        // TODO find out which element classes show what numbers, update the game state board to those numbers and return.
        List<String> cellsClasses = cellElements.stream().map(item -> item.getAttribute("class")).collect(Collectors.toList());
        return board;
    }
}
