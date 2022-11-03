package com.Guru99POMSeleniumSpringBoot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class HomePage extends CommonElements {

    private By mobileLink = By.cssSelector(".nav-1 a");

    private By tvLink = By.cssSelector(".nav-2 a");

    private By accountLink = By.cssSelector(".skip-account");

    private By accountLinkFinal = By.xpath("//*[text()='My Account']");

    private By headerMiniCart = By.cssSelector(".header-minicart");

    private By cartLink = By.cssSelector(".cart-link");

    public MobilePage clickMobileLink() {
        driver.findElement(mobileLink).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.titleIs("Mobile"));
        return new MobilePage();
    }

    public TVCategoryPage clickTVLink() {
        driver.findElement(tvLink).click();
        return new TVCategoryPage();
    }

    public LoginPage goToMyAccount() {
        driver.findElement(accountLink).click();
        driver.findElement(accountLinkFinal).click();
        return new LoginPage();
    }

    public ShoppingCart goToShoppingCart() {
        driver.findElement(headerMiniCart).click();
        driver.findElement(cartLink).click();
        return new ShoppingCart();
    }
}