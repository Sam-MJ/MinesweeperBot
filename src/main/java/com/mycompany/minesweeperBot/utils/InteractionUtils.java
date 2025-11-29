package com.mycompany.minesweeperBot.utils;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class InteractionUtils {

    static public void clickButton(WebDriver driver, By by) {
        List<WebElement> buttonList = driver.findElements(by);
        if(buttonList.size() > 1) {
            throw new Error("Ambiguous By, more than one button available.");
        }

        WebElement button = buttonList.get(0);
        button.click();
    }

    static public void clickButton(WebDriver driver, By by, boolean leftClick) {
        List<WebElement> buttonList = driver.findElements(by);
        if(buttonList.size() > 1) {
            throw new Error("Ambiguous By, more than one button available.");
        }

        WebElement button = buttonList.get(0);

        if(leftClick) {
            button.click();
        } else {
            Actions actions = new Actions(driver);
            actions.contextClick(button).perform();
        }
    }
}
