package com.yieldstreet.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Checkout extends PageBase {

    public Checkout withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    private WebElement inputFirstName() {
        return elementPresent(By.id("first-name"));
    }

    private WebElement inputLastName() {
        return elementPresent(By.id("last-name"));
    }

    private WebElement inputZip() {
        return elementPresent(By.id("postal-code"));
    }

    private WebElement buttonContinue() {
        return elementPresent(By.xpath("//input[@value='CONTINUE']"));
    }

    private WebElement buttonFinish() {
        return elementPresent(By.xpath("//a[text()='FINISH']"));
    }

    private WebElement labelOrderConfirmation() {
        return elementPresent(By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']"));
    }

    public Checkout orderCheckout() {

        inputFirstName().sendKeys("Test");
        inputLastName().sendKeys("User");
        inputZip().sendKeys("06902");
        buttonContinue().click();
        buttonFinish().click();

        Assert.assertEquals(labelOrderConfirmation().isDisplayed(), true, "Order Confirmation is displayed");

        return this;
    }
}
