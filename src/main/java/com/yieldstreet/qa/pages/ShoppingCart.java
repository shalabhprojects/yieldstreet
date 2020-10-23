package com.yieldstreet.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCart extends PageBase {

    public ShoppingCart withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    private WebElement buttonShoppingCart() {
        return elementPresent(By.xpath("//a[text()='CHECKOUT']"));
    }

    public ShoppingCart checkout() {

        buttonShoppingCart().click();
        return this;
    }
}
