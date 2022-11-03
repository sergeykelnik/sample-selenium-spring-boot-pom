package com.Guru99POMSeleniumSpringBoot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class MobilePage extends CommonElements {

    private By sortByButtons = By.cssSelector(".sort-by select");
    private By compareAllButton = By.cssSelector("button[title='Compare']");

    private By sonyPrice = By.cssSelector("#product-price-1");
    private By iphonePrice = By.cssSelector("#product-price-2");
    private By galaxyPrice = By.cssSelector("#product-price-3");

    private By sonyLink = By.cssSelector(".product-name a[title='Sony Xperia']");
    private By iphoneLink = By.cssSelector(".product-name a[title='IPhone']");
    private By galaxyLink = By.cssSelector(".product-name a[title='Samsung Galaxy']");

    private By sonyBuyButton = By.cssSelector("a[title='Xperia']+div .actions [type='button']");
    private By iphoneBuyButton = By.cssSelector("a[title='IPhone']+div .actions [type='button']");
    private By galaxyBuyButton = By.cssSelector("a[title='Samsung Galaxy']+div .actions [type='button']");

    private By sonyCompareButton = By.cssSelector("a[title='Xperia']+div .actions [type='button']+.add-to-links .link-compare");
    private By iphoneCompareButton = By.cssSelector("a[title='IPhone']+div .actions [type='button']+.add-to-links .link-compare");
    private By galaxyCompareButton = By.cssSelector("a[title='Samsung Galaxy']+div .actions [type='button']+.add-to-links .link-compare");

    public void sortByName() {
        WebElement sortableElement = driver.findElements(sortByButtons).get(0);
        Select select = new Select(sortableElement);
        select.selectByVisibleText("Name");
    }

    public String getPhonePrice(String name) throws NoSuchElementException {
        if (name.equalsIgnoreCase("sony")) {
            return driver.findElement(sonyPrice).getText();
        } else if (name.equalsIgnoreCase("iphone")) {
            return driver.findElement(iphonePrice).getText();
        } else if (name.equalsIgnoreCase("galaxy")) {
            return driver.findElement(galaxyPrice).getText();
        } else {
            throw new NoSuchElementException("Wrong phone name");
        }
    }

    public PhonePage getPhoneLink(String name) {
        if (name.equalsIgnoreCase("sony")) {
            driver.findElement(sonyLink).click();
            return new PhonePage();
        } else if (name.equalsIgnoreCase("iphone")) {
            driver.findElement(iphoneLink).click();
            return new PhonePage();
        } else if (name.equalsIgnoreCase("galaxy")) {
            driver.findElement(galaxyLink).click();
            return new PhonePage();
        } else {
            throw new NoSuchElementException("Wrong phone name");
        }
    }

    public ShoppingCart clickBuyButton(String name) {
        if (name.equalsIgnoreCase("sony")) {
            driver.findElement(sonyBuyButton).click();
            return new ShoppingCart();
        } else if (name.equalsIgnoreCase("iphone")) {
            driver.findElement(iphoneBuyButton).click();
            return new ShoppingCart();
        } else if (name.equalsIgnoreCase("galaxy")) {
            driver.findElement(galaxyBuyButton).click();
            return new ShoppingCart();
        } else {
            throw new NoSuchElementException("Wrong phone name");
        }
    }

    public ComparePopUp compareTwoPhones(String name1, String name2, String name3) {
        addPhoneToCompare(name1);
        addPhoneToCompare(name2);
        addPhoneToCompare(name3);
        driver.findElement(compareAllButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String currentWindow : driver.getWindowHandles()) {
            driver.switchTo().window(currentWindow);
        }
        return new ComparePopUp();
    }

    private void addPhoneToCompare(String name) {
        if (name.equalsIgnoreCase("sony")) {
            driver.findElement(sonyCompareButton).click();
        } else if (name.equalsIgnoreCase("iphone")) {
            driver.findElement(iphoneCompareButton).click();
        } else if (name.equalsIgnoreCase("galaxy")) {
            driver.findElement(galaxyCompareButton).click();
        } else {
            if (!name.isEmpty()) {
                throw new NoSuchElementException("Wrong phone name");
            }
        }
    }
}
