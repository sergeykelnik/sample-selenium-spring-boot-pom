package com.Guru99POMSeleniumSpringBoot.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCart extends CommonElements {

    private By qtyField = By.cssSelector(".product-cart-actions input");

    private By qtyUpdateButton = By.cssSelector(".product-cart-actions button");

    private By errorMessageTop = By.cssSelector(".error-msg");

    private By errorMessageItem = By.cssSelector(".item-msg.error");

    private By emptyCartButton = By.cssSelector("[value='empty_cart']");

    private By proceedToCheckout = By.cssSelector("[title='Proceed to Checkout']");

    public void updateQtyTo(String qty) {
        driver.findElement(qtyField).sendKeys(qty);
        driver.findElement(qtyUpdateButton).click();
    }

    public String getErrorMessageTop() {
        return driver.findElement(errorMessageTop).getText();
    }

    public String getErrorMessageItem() {
        return driver.findElement(errorMessageItem).getText();
    }

    public void emptyCart() {
        driver.findElement(emptyCartButton).click();
    }

    public void proceedToCheckout() {
        driver.findElement(proceedToCheckout).click();
    }
}
