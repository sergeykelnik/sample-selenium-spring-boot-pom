package com.Guru99POMSeleniumSpringBoot.pages

import org.openqa.selenium.By
import org.springframework.stereotype.Component

@Component
class LoginPage : BasePage() {
    private val createAccountButton = By.cssSelector("[title='Create an Account']")
    private val email = By.cssSelector("#email")
    private val password = By.cssSelector("#pass")
    private val submit = By.cssSelector("#send2")
    fun clickNewAccountButton(): CreateAccountPage {
        driver.findElement(createAccountButton).click()
        return CreateAccountPage()
    }

    fun loginAsUser(email: String?, password: String?) {
        driver.findElement(this.email).sendKeys(email)
        driver.findElement(this.password).sendKeys(password)
        driver.findElement(submit).click()
    }
}