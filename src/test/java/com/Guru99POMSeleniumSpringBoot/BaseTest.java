package com.Guru99POMSeleniumSpringBoot;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    @BeforeSuite(alwaysRun = true)
    protected void prepareInstance() throws Exception {
        springTestContextPrepareTestInstance();
    }

    @BeforeClass
    public void setUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}