package pomutilities1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class saucedemocartpage {

    WebDriver driver;


    By backpack =
            By.xpath("//div[text()='Sauce Labs Backpack']");


    By checkoutButton =
            By.id("checkout");


    public saucedemocartpage(WebDriver driver) {

        this.driver = driver;
    }


    public boolean verifyBackpackDisplayed() {

        return driver.findElement(backpack).isDisplayed();
    }


    public void clickCheckout() {

        driver.findElement(checkoutButton).click();
    }
}