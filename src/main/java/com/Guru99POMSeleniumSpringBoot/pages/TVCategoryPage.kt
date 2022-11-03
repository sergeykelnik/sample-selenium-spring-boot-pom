package com.Guru99POMSeleniumSpringBoot.pages

import org.openqa.selenium.By
import org.springframework.stereotype.Component

@Component
class TVCategoryPage : ProductCategoryPage() {
    private val lgWishListButton =
        By.cssSelector("a[title='LG LCD']+div .actions [type='button']+.add-to-links .link-wishlist")
    private val samsungWishListButton =
        By.cssSelector("a[title='Samsung LCD']+div .actions [type='button']+.add-to-links .link-wishlist")

    fun addItemToWishList(name: String): WishListPage {
        if (name.equals("lg", ignoreCase = true)) {
            driver.findElement(lgWishListButton).click()
        } else if (name.equals("samsung", ignoreCase = true)) {
            driver.findElement(samsungWishListButton).click()
        }
        return WishListPage()
    }
}