package com.yieldstreet.qa.ui;

import com.yieldstreet.qa.pages.Login;
import com.yieldstreet.qa.pages.Products;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    private WebDriver driver;

    @BeforeMethod
    public void before() {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    protected Login login() {

        return new Login().withDriver(driver);
    }

    protected Products products() {

        return new Products().withDriver(driver);
    }

    @AfterMethod
    public void after() {

        driver.quit();
    }
}
