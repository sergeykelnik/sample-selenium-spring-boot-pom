package com.Guru99POMSeleniumSpringBoot.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class CreateAccountPage extends BasePage {

    private By fistname = By.cssSelector("#firstname");
    private By middlename = By.cssSelector("#middlename");
    private By lastname = By.cssSelector("#lastname");
    private By email_address = By.cssSelector("#email_address");
    private By password = By.cssSelector("#password");
    private By password_confirmation = By.cssSelector("#confirmation");
    private By subscribe = By.cssSelector("[type='checkbox']");
    private By register = By.cssSelector(".buttons-set [title='Register']");

    public MyDashboardPage fillOutRegistrationForm(String firstname, String middlename, String lastname, String email_address, String password, boolean subscribe) {
        driver.findElement(this.fistname).sendKeys(firstname);
        driver.findElement(this.middlename).sendKeys(middlename);
        driver.findElement(this.lastname).sendKeys(lastname);
        driver.findElement(this.email_address).sendKeys(email_address);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(this.password_confirmation).sendKeys(password);
        if (subscribe) {
            driver.findElement(this.subscribe).click();
        }
        driver.findElement(register).click();
        return new MyDashboardPage();
    }
}
