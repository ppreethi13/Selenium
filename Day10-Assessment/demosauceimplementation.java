package keyworddrivers;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pomutilities1.saucedemologinpage;
import pomutilities1.saucedemoproductpage;
import pomutilities1.saucedemocartpage;
import pomutilities1.saucedemocheckoutpage;

public class demosauceimplementation {

    WebDriver driver;

    saucedemologinpage loginPage;
    saucedemoproductpage productsPage;
    saucedemocartpage cartPage;
    saucedemocheckoutpage checkoutPage;


    // Launch Browser
    public void launchBrowser() {

        ChromeOptions options = new ChromeOptions();

        // Disable Chrome password manager and password leak warning
        Map<String, Object> prefs = new HashMap<>();

        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);

        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        // Initialize Page Objects
        loginPage = new saucedemologinpage(driver);
        productsPage = new saucedemoproductpage(driver);
        cartPage = new saucedemocartpage(driver);
        checkoutPage = new saucedemocheckoutpage(driver);
    }


    // Open SauceDemo URL
    public void openURL(String url) {

        driver.get(url);
    }


    // Enter Username
    public void enterUsername(String username) {

        loginPage.enterUsername(username);
    }


    // Enter Password
    public void enterPassword(String password) {

        loginPage.enterPassword(password);
    }


    // Click Login
    public void clickLogin() {

        loginPage.clickLogin();
    }


    // Verify Products Page
    public boolean verifyProductsPage() {

        return productsPage.verifyProductsPage();
    }


    // Add Sauce Labs Backpack
    public void addBackpack() {

        productsPage.addBackpack();
    }


    // Get Cart Count
    public String getCartCount() {

        return productsPage.getCartCount();
    }


    // Click Cart
    public void clickCart() {

        productsPage.clickCart();
    }


    // Verify Backpack in Cart
    public boolean verifyBackpack() {

        return cartPage.verifyBackpackDisplayed();
    }


    // Click Checkout
    public void clickCheckout() {

        cartPage.clickCheckout();
    }


    // Enter First Name
    public void enterFirstName(String firstname) {

        checkoutPage.enterFirstName(firstname);
    }


    // Enter Last Name
    public void enterLastName(String lastname) {

        checkoutPage.enterLastName(lastname);
    }


    // Enter Postal Code
    public void enterPostalCode(String postalcode) {

        checkoutPage.enterPostalCode(postalcode);
    }


    // Click Continue
    public void clickContinue() {

        checkoutPage.clickContinue();
    }


    // Verify Checkout Overview Page
    public boolean verifyOverviewPage() {

        return checkoutPage.verifyOverviewPage();
    }


    // Click Finish
    public void clickFinish() {

        checkoutPage.clickFinish();
    }


    // Verify Thank You Message
    public boolean verifyThankYouMessage() {

        return checkoutPage.verifyThankYouMessage();
    }


    // Close Browser
    public void closeBrowser() {

        if (driver != null) {

            driver.quit();
        }
    }
}