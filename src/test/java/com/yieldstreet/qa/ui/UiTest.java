package com.yieldstreet.qa.ui;

import org.testng.annotations.Test;

public class UiTest extends TestBase {

    @Test
    public void validStandardUserLogin() {

        login().standardUserLogin();
    }

    @Test
    public void validOrderPurchase() {

        login().standardUserLogin();
        products()
                .addAllItemsToCard("T-Shirt")
                .orderCheckout();

    }
}
