package com.Guru99POMSeleniumSpringBoot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryPage extends BasePage {

    private By sortByButtons = By.cssSelector(".sort-by select");
    private By compareAllButton = By.cssSelector("button[title='Compare']");

    public void sortBy(String type) {
        Select select = new Select(driver.findElements(sortByButtons).get(0));
        if (type.equalsIgnoreCase("Name")) {
            select.selectByVisibleText("Name");
        } else if (type.equalsIgnoreCase("Position")) {
            select.selectByVisibleText("Position");
        } else if (type.equalsIgnoreCase("Price")) {
            select.selectByVisibleText("Price");
        } else {
            throw new NoSuchElementException("Wrong sorting type");
        }
    }

    public void compareAll() {
        driver.findElement(compareAllButton).click();
    }
}