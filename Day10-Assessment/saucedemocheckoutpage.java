package pomutilities1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class saucedemocheckoutpage {

    WebDriver driver;


    By firstName =
            By.id("first-name");


    By lastName =
            By.id("last-name");


    By postalCode =
            By.id("postal-code");


    By continueButton =
            By.id("continue");


    By overviewTitle =
            By.xpath("//span[text()='Checkout: Overview']");


    By finishButton =
            By.id("finish");


    By thankYouMessage =
            By.xpath("//h2[text()='Thank you for your order!']");


    public saucedemocheckoutpage(WebDriver driver) {

        this.driver = driver;
    }


    public void enterFirstName(String firstname) {

        driver.findElement(firstName)
              .sendKeys(firstname);
    }


    public void enterLastName(String lastname) {

        driver.findElement(lastName)
              .sendKeys(lastname);
    }


    public void enterPostalCode(String postalcode) {

        driver.findElement(postalCode)
              .sendKeys(postalcode);
    }


    public void clickContinue() {

        driver.findElement(continueButton).click();
    }


    public boolean verifyOverviewPage() {

        return driver.findElement(overviewTitle).isDisplayed();
    }


    public void clickFinish() {

        driver.findElement(finishButton).click();
    }


    public boolean verifyThankYouMessage() {

        return driver.findElement(thankYouMessage).isDisplayed();
    }
}