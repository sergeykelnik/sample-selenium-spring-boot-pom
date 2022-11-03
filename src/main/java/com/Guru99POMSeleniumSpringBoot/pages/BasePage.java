package com.Guru99POMSeleniumSpringBoot.pages;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BasePage {

    @Autowired
    WebDriver driver;
}
