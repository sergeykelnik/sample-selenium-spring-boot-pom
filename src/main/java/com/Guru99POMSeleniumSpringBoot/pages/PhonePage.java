package com.Guru99POMSeleniumSpringBoot.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class PhonePage extends BasePage {

    private By phonePrice = By.cssSelector(".price");

    public String getPhonePrice() {
        return driver.findElement(phonePrice).getText();
    }
}
