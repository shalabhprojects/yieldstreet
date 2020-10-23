package com.yieldstreet.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Login extends PageBase {

    public Login withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    private WebElement inputUserName() {
        return elementPresent(By.id("user-name"));
    }

    private WebElement inputPassword() {
        return elementPresent(By.id("password"));
    }

    private WebElement buttonLogin() {
        return elementPresent(By.id("login-button"));
    }

    private WebElement labelAppLogo() {
        return elementPresent(By.xpath("//div[@class='app_logo']"));
    }

    public Login standardUserLogin() {

        inputUserName().sendKeys("standard_user");
        inputPassword().sendKeys("secret_sauce");
        buttonLogin().click();

        Assert.assertEquals(labelAppLogo().isDisplayed(), true, "App Logo is displayed");

        return this;
    }

}
