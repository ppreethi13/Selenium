
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

        ChromeOptions options = new ChromeOptions();

        options.addArguments(
                "--user-data-dir=C:\\selenium\\myntra-selenium-profile"
        );

        options.addArguments("--start-maximized");

        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get("https://www.myntra.com/");

        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.tagName("body")
                )
        );
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

        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("li.product-base")
                )
        );
        List<WebElement> products =
                driver.findElements(
                        By.cssSelector("li.product-base")
                );

        if (products.isEmpty()) {
            return;
        }
        WebElement firstProduct = products.get(0);

        String productText = firstProduct.getText();

        firstProduct.click();

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
        try {

            Thread.sleep(3000);

        } catch (InterruptedException ignored) {
        }
        driver.get(
                "https://www.myntra.com/wish-list"
        );

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

        try {

            Thread.sleep(Long.MAX_VALUE);

        } catch (InterruptedException ignored) {
        }
    }
}

