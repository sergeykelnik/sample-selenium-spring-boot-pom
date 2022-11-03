package com.Guru99POMSeleniumSpringBoot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommonElements extends BasePage {

    private By phoneTitles = By.cssSelector(".product-name a");
    private By pageHeader = By.cssSelector("h1");

    public List<WebElement> getPhoneList() {
        List<WebElement> webElements = driver.findElements(phoneTitles);
        return webElements;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getPageHeaderMessage() {
        return driver.findElement(pageHeader).getText();
    }
}
