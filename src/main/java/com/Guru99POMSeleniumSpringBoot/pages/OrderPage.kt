package com.Guru99POMSeleniumSpringBoot.pages

import org.openqa.selenium.By
import org.springframework.stereotype.Component

@Component
class OrderPage : BasePage() {
    private val successMessage = By.cssSelector(".checkout-onepage-success .page-title h1")

    fun getFinalMessage(): String {
        return driver.findElement(successMessage).text
    }
}