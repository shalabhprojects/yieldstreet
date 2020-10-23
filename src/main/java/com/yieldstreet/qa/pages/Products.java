package com.yieldstreet.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Products extends PageBase {

    public Products withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    private List<WebElement> buttonAddToCart(String productName) {
        return elementsPresent(By.xpath("//div[contains(text(),'" + productName + "')]" +
                "/ancestor::div[@class='inventory_item']//button[text()='ADD TO CART']"));
    }

    private WebElement buttonShoppingCart() {
        return elementPresent(By.id("shopping_cart_container"));
    }

    public Products addAllItemsToCard(String productName) {

        buttonAddToCart(productName).forEach(button -> button.click());
        buttonShoppingCart().click();

        return this;
    }

    public Products orderCheckout() {

        new ShoppingCart().withDriver(driver).checkout();
        new Checkout().withDriver(driver).orderCheckout();

        return this;
    }
}
