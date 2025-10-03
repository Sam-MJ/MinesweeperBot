package com.mycompany.minesweeperBot.Sites;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mycompany.minesweeperBot.Board;

public abstract class BasePage {

    protected String baseUrl;
    protected By boardBy;
    protected By cellBy;

    public abstract Board convertBoard(List<WebElement> cellElements, Board board);

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
