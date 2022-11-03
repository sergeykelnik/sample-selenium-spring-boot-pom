package com.Guru99POMSeleniumSpringBoot.pages

import org.openqa.selenium.By
import org.springframework.stereotype.Component

@Component
class WishListPage : BasePage() {
    private val shareWishListButton = By.cssSelector(".btn-share")
    private val email = By.cssSelector("#email_address")
    private val message = By.cssSelector("#message")
    private val submit = By.cssSelector("[title='Share Wishlist']")
    private val successMessage = By.cssSelector(".success-msg")
    private val addToCartButton = By.cssSelector(".button.btn-cart")

    fun clickShareWishList() {
        driver.findElement(shareWishListButton).click()
    }

    fun fillOutSubmitWishList(email: String?, message: String?) {
        driver.findElement(this.email).sendKeys(email)
        driver.findElement(this.message).sendKeys(message)
        driver.findElement(submit).click()
    }

    fun addToCart() {
        driver.findElement(addToCartButton).click()
    }

    fun getSuccessMessage(): String {
        return driver.findElement(successMessage).text
    }
}