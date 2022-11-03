package com.Guru99POMSeleniumSpringBoot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.springframework.stereotype.Component;

@Component
public class MyDashboardPage extends BasePage {

    private By successMessage = By.cssSelector(".success-msg");

    //private By myWishlistLink = By.xpath("//*[text()='My Wishlist']");

    private By myWishlistLink = RelativeLocator.with(By.xpath("//*[text()='My Wishlist']")).below(By.xpath("//*[text()='My Wishlist']"));

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    public void clickWishlistLink() {
        driver.findElement(myWishlistLink).click();
    }
}
