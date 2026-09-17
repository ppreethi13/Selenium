package pomutilities1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class saucedemoproductpage {

    WebDriver driver;


    By productsTitle =
            By.xpath("//span[text()='Products']");


    By backpack =
            By.id("add-to-cart-sauce-labs-backpack");


    By cartBadge =
            By.className("shopping_cart_badge");


    By cart =
            By.className("shopping_cart_link");


    public saucedemoproductpage(WebDriver driver) {

        this.driver = driver;
    }


    public boolean verifyProductsPage() {

        return driver.findElement(productsTitle).isDisplayed();
    }


    public void addBackpack() {

        driver.findElement(backpack).click();
    }


    public String getCartCount() {

        return driver.findElement(cartBadge).getText();
    }


    public void clickCart() {

        driver.findElement(cart).click();
    }
}