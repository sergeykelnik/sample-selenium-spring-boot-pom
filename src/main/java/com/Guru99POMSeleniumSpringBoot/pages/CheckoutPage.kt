package com.Guru99POMSeleniumSpringBoot.pages

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.Select
import org.springframework.stereotype.Component

@Component
class CheckoutPage : BasePage() {

    private val billingAddress = By.cssSelector("[id='billing:street1']")

    private val billingCity = By.cssSelector("[id='billing:city']")

    private val billingState = By.cssSelector("[id='billing:region_id']")

    private val billingZip = By.cssSelector("[id='billing:postcode']")

    private val billingCountry = By.cssSelector("[id='billing:country_id']")

    private val billingPhone = By.cssSelector("[id='billing:telephone']")

    private val billingSave = By.cssSelector("[onclick='billing.save()']")

    private val shippingSave = By.cssSelector("[onclick='shippingMethod.save()']")

    private val paymentSave = By.cssSelector("[onclick='payment.save()']")

    private val flatRate = By.cssSelector("[for='s_method_flatrate_flatrate']")

    private val checkMethod = By.cssSelector("[for='p_method_checkmo']")

    private val cardMethod = By.cssSelector("[for='p_method_ccsave']")

    private val subTotal = By.cssSelector("tfoot tr.first .a-right.last .price")

    private val flatRateSum = By.cssSelector("tfoot tr .a-right.last .price")

    private val grandTotal = By.cssSelector("tfoot tr.last .a-right.last .price")

    private val placeOrder = By.cssSelector("[title='Place Order']")

    private val selectAddress = By.cssSelector("#billing-address-select")

    private val selectThisAddressForShipping = By.cssSelector("[for='billing:use_for_shipping_yes']")


    fun fillInBillingData(billingAddress: String, billingCity: String, billingState: String, billingZip: String, billingCountry: String, billingPhone: String) {
        Select(driver.findElement(selectAddress)).selectByVisibleText("New Address")

        val elementBillingAddress = driver.findElement(this.billingAddress)
        elementBillingAddress.clear()
        elementBillingAddress.sendKeys(billingAddress)

        val elementBillingCity = driver.findElement(this.billingCity)
        elementBillingCity.clear()
        elementBillingCity.sendKeys(billingCity)

        Select(driver.findElement(this.billingState)).selectByVisibleText(billingState)

        val elementBillingZip = driver.findElement(this.billingZip)
        elementBillingZip.clear()
        elementBillingZip.sendKeys(billingZip)

        Select(driver.findElement(this.billingCountry)).selectByVisibleText(billingCountry)

        val elementBillingPhone = driver.findElement(this.billingPhone)
        elementBillingPhone.clear()
        elementBillingPhone.sendKeys(billingPhone)

        driver.findElement(selectThisAddressForShipping).click()
        driver.findElement(billingSave).click()
    }

    fun selectPaymentInfo(method: String) {
        driver.findElement(shippingSave).click()
        when (method) {
            "Card" -> driver.findElement(cardMethod).click()
            "Check" -> driver.findElement(checkMethod).click()
        }
        driver.findElement(paymentSave).click()
    }

    fun getFlatRate(): String {
        return driver.findElement(flatRate).text
    }

    fun getSubTotal(): Float {
        val e = driver.findElement(subTotal).text.substring(1).toFloat()
        println(e)
        return e
    }

    fun getFlatRateSum(): Float {
        val e = driver.findElements(flatRateSum)[1].text.substring(1).toFloat()
        println(e)
        return e
    }

    fun getGrandTotal(): Float {
        val e = driver.findElement(grandTotal).text.substring(1).toFloat()
        println(e)
        return e
    }

    fun placeOrder() {
        driver.findElement(placeOrder).click()
    }
}