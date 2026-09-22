package pomutilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage1 {

    WebDriver driver;
    WebDriverWait wait;

    By usernameField = By.name("username");
    By passwordField = By.name("password");
    By loginButton = By.xpath("//button[@type='submit']");

    public LoginPage1(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20));
    }

    public void login(String username, String password) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        usernameField))
                .sendKeys(username);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        passwordField))
                .sendKeys(password);

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        loginButton))
                .click();
    }
}