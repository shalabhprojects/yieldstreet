package com.yieldstreet.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PageBase {

    protected WebDriver driver;

    //    Returns Web element once its present, with a timeout of 15 seconds
    protected WebElement elementPresent(By by) {
        return new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    //    Returns Web elements once its present, with a timeout of 15 seconds
    protected List<WebElement> elementsPresent(By by) {
        return new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
}
