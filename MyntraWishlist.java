
package WebDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyntraWishlist {

    public static void main(String[] args) {

        // =====================================================
        // CHROME OPTIONS
        // =====================================================

        ChromeOptions options = new ChromeOptions();

        /*
         * IMPORTANT:
         * This is a completely separate Chrome profile.
         *
         * Do NOT use your normal Chrome profile here.
         */

        options.addArguments(
                "--user-data-dir=C:\\selenium\\myntra-selenium-profile"
        );

        options.addArguments("--start-maximized");

        /*
         * These options help Chrome start correctly when
         * Selenium is creating a fresh profile.
         */

        options.addArguments("--remote-allow-origins=*");

        // =====================================================
        // START CHROME
        // =====================================================

        WebDriver driver = new ChromeDriver(options);

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(30));

        // =====================================================
        // OPEN MYNTRA
        // =====================================================

        driver.get("https://www.myntra.com/");

        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.tagName("body")
                )
        );

        // =====================================================
        // SEARCH PRODUCT
        // =====================================================

        WebElement searchBox = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(
                                "input[placeholder*='Search']"
                        )
                )
        );

        searchBox.click();

        searchBox.sendKeys("Nike Shoes");

        searchBox.sendKeys(Keys.ENTER);

        // =====================================================
        // WAIT FOR SEARCH RESULTS
        // =====================================================

        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("li.product-base")
                )
        );

        // =====================================================
        // GET PRODUCTS
        // =====================================================

        List<WebElement> products =
                driver.findElements(
                        By.cssSelector("li.product-base")
                );

        if (products.isEmpty()) {
            return;
        }

        // =====================================================
        // SELECT FIRST PRODUCT
        // =====================================================

        WebElement firstProduct = products.get(0);

        String productText = firstProduct.getText();

        firstProduct.click();

        // =====================================================
        // WAIT FOR PRODUCT PAGE
        // =====================================================

        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(
                                "//*[contains(" +
                                "translate(normalize-space(.)," +
                                "'abcdefghijklmnopqrstuvwxyz'," +
                                "'ABCDEFGHIJKLMNOPQRSTUVWXYZ')," +
                                "'WISHLIST')]"
                        )
                )
        );

        // =====================================================
        // FIND WISHLIST BUTTON
        // =====================================================

        List<WebElement> wishlistButtons =
                driver.findElements(
                        By.xpath(
                                "//*[contains(" +
                                "translate(normalize-space(.)," +
                                "'abcdefghijklmnopqrstuvwxyz'," +
                                "'ABCDEFGHIJKLMNOPQRSTUVWXYZ')," +
                                "'WISHLIST')]"
                        )
                );

        boolean wishlistClicked = false;

        // =====================================================
        // CLICK WISHLIST
        // =====================================================

        for (WebElement button : wishlistButtons) {

            try {

                if (button.isDisplayed() &&
                        button.isEnabled()) {

                    button.click();

                    wishlistClicked = true;

                    break;
                }

            } catch (Exception ignored) {
            }
        }

        if (!wishlistClicked) {
            return;
        }

        // =====================================================
        // WAIT FOR WISHLIST ACTION
        // =====================================================

        try {

            Thread.sleep(3000);

        } catch (InterruptedException ignored) {
        }

        // =====================================================
        // OPEN WISHLIST PAGE
        // =====================================================

        driver.get(
                "https://www.myntra.com/wish-list"
        );

        // =====================================================
        // WAIT FOR WISHLIST PAGE
        // =====================================================

        wait.until(
                ExpectedConditions.urlContains(
                        "wish-list"
                )
        );

        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.tagName("body")
                )
        );

        // =====================================================
        // KEEP BROWSER OPEN
        // =====================================================

        /*
         * DO NOT use driver.quit().
         *
         * The browser will remain open until you close it
         * manually.
         */

        try {

            Thread.sleep(Long.MAX_VALUE);

        } catch (InterruptedException ignored) {
        }
    }
}

