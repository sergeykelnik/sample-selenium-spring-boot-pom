package com.Guru99POMSeleniumSpringBoot;

import com.Guru99POMSeleniumSpringBoot.pages.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@SpringBootTest
public class SpringBasicApplicationTests extends BaseTest {

    @Autowired
    private HomePage homePage;

    @Autowired
    private MobilePage mobilePage;

    @Autowired
    private PhonePage phonePage;

    @Autowired
    private ShoppingCart shoppingCart;

    @Autowired
    private ComparePopUp comparePopUp;

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private MyDashboardPage myDashboardPage;

    @Autowired
    private CreateAccountPage createAccountPage;

    @Autowired
    private WishListPage wishListPage;

    @Autowired
    private TVCategoryPage tvCategoryPage;

    @Autowired
    private CheckoutPage checkoutPage;

    @Autowired
    private OrderPage orderPage;

    @Value("${name}")
    private String name;

    @Value("${middlename}")
    private String middlename;

    @Value("${lastname}")
    private String lastname;

    //Generated each run
    private String email_address;

    @Value("${password}")
    private String password;

    @Value("${billing.address}")
    private String billing_address;

    @Value("${billing.city}")
    private String billing_city;

    @Value("${billing.state}")
    private String billing_state;

    @Value("${billing.zip}")
    private String billing_zip;

    @Value("${billing.country}")
    private String billing_country;

    @Value("${billing.telephone}")
    private String billing_telephone;

    final String randoms = String.format("%03d", new Random().nextInt(100000));

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().deleteAllCookies();
        driver.get("http://live.techpanda.org/index.php/");
    }

    @AfterMethod
    public void screenShot(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                String timestamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
                File src = screenshot.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(src, new File("target/screenshots/screenshot_" + timestamp + ".png"));
                System.out.println("Successfully captured a screenshot");
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
    }

    //@Ignore
    @Test(priority = 1)
    public void day1Test() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(homePage.getPageTitle(), "Home page");
        homePage.clickMobileLink();
        softAssert.assertEquals(mobilePage.getPageTitle(), "Mobile");
        mobilePage.sortByName();
        softAssert.assertEquals(mobilePage.getPhoneList().get(0).getText(), "IPHONE");
        softAssert.assertEquals(mobilePage.getPhoneList().get(1).getText(), "SAMSUNG GALAXY");
        softAssert.assertEquals(mobilePage.getPhoneList().get(2).getText(), "SONY XPERIA");
        softAssert.assertAll();
    }

    //@Ignore
    @Test(priority = 2)
    public void day2Test() {
        homePage.clickMobileLink();
        String priceOnMobilePage = mobilePage.getPhonePrice("iphone");
        mobilePage.getPhoneLink("iphone");
        String priceOnPhonePage = phonePage.getPhonePrice();
        Assert.assertEquals(priceOnMobilePage, priceOnPhonePage);
        System.out.println(priceOnMobilePage + " equals to " + priceOnPhonePage);
    }

    //@Ignore
    @Test(priority = 3)
    public void day3Test() {
        homePage.clickMobileLink();
        mobilePage.clickBuyButton("sony");
        shoppingCart.updateQtyTo("1000");
        SoftAssert softAssert = new SoftAssert();
        String errorMessageTop = shoppingCart.getErrorMessageTop();
        String errorMessageItem = shoppingCart.getErrorMessageItem();
        softAssert.assertEquals(errorMessageTop, "Some of the products cannot be ordered in requested quantity.");
        softAssert.assertEquals(errorMessageItem, "* The maximum quantity allowed for purchase is 500.");
        shoppingCart.emptyCart();
        String pageHeaderMessage = shoppingCart.getPageHeaderMessage();
        softAssert.assertEquals(pageHeaderMessage, "SHOPPING CART IS EMPTY");
        softAssert.assertAll();
    }

    //@Ignore
    @Test(priority = 4)
    public void day4Test() {
        homePage.clickMobileLink();
        String parentWindowHandler = driver.getWindowHandle();
        mobilePage.compareTwoPhones("sony", "iphone", "");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(comparePopUp.getPageHeaderMessage(), "COMPARE PRODUCTS");
        softAssert.assertEquals(comparePopUp.getPhoneList().get(0).getText(), "SONY XPERIA");
        softAssert.assertEquals(comparePopUp.getPhoneList().get(1).getText(), "IPHONE");
        driver.switchTo().window(parentWindowHandler);
        softAssert.assertAll();
    }

    //@Ignore
    @Test(priority = 5)
    public void day5Test() {
        homePage.goToMyAccount();
        loginPage.clickNewAccountButton();
        createAccountPage.fillOutRegistrationForm(name, middlename, lastname, randoms + "mail@mail.ee", password, true);
        email_address = randoms + "mail@mail.ee";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(myDashboardPage.getSuccessMessage(), "Thank you for registering with Main Website Store.");
        homePage.clickTVLink();
        tvCategoryPage.addItemToWishList("lg");
        wishListPage.clickShareWishList();
        wishListPage.fillOutSubmitWishList("galowor896@wpfoo.com", "Share message!");
        softAssert.assertEquals(wishListPage.getSuccessMessage(), "Your Wishlist has been shared.");
        softAssert.assertAll();
    }

    //@Ignore
    @Test(priority = 6)
    public void day6Test() {
        homePage.goToMyAccount();
        loginPage.loginAsUser(email_address, password);
        homePage.clickTVLink();
        tvCategoryPage.addItemToWishList("samsung");
        myDashboardPage.clickWishlistLink();
        wishListPage.addToCart();
        shoppingCart.proceedToCheckout();
        checkoutPage.fillInBillingData(billing_address, billing_city, billing_state, billing_zip, billing_country, billing_telephone);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(checkoutPage.getFlatRate(), "Fixed $5.00");
        checkoutPage.selectPaymentInfo("Check");
        softAssert.assertEquals(checkoutPage.getSubTotal() + checkoutPage.getFlatRateSum(), checkoutPage.getGrandTotal());
        checkoutPage.placeOrder();
        softAssert.assertEquals(orderPage.getFinalMessage(), "YOUR ORDER HAS BEEN RECEIVED.");
        softAssert.assertAll();
    }
}