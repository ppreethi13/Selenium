package pomutilities1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class saucedemologinpage {

    WebDriver driver;


    By username =
            By.id("user-name");


    By password =
            By.id("password");


    By loginButton =
            By.id("login-button");


    public saucedemologinpage(WebDriver driver) {

        this.driver = driver;
    }


    public void enterUsername(String username) {

        driver.findElement(this.username)
              .sendKeys(username);
    }


    public void enterPassword(String password) {

        driver.findElement(this.password)
              .sendKeys(password);
    }


    public void clickLogin() {

        driver.findElement(loginButton).click();
    }
}