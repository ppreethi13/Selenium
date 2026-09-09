package WebDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookApplication2 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        WebElement createAccount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Create new account')]")));
        System.out.println("Create New Account LocationX: " + createAccount.getLocation().getX());
        System.out.println("Create New Account LocationY: " + createAccount.getLocation().getY());
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        System.out.println("DOM Attribute Before: " + emailField.getDomAttribute("value"));
        System.out.println("DOM Property Before: " + emailField.getDomProperty("value"));
        emailField.sendKeys("ppreethi1311@gmail.com@gmail.com");
        System.out.println("DOM Attribute After: " + emailField.getDomAttribute("value"));
        System.out.println("DOM Property After: " + emailField.getDomProperty("value"));
        createAccount.click();
        WebElement submitButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='dialog']//button"+ " | //div[@role='dialog']//input[@type='submit']"+ " | //div[@role='dialog']//div[@role='button']")));
        System.out.println("Submit Button Width: " + submitButton.getSize().getWidth());
        System.out.println("Submit Button Height: " + submitButton.getSize().getHeight());
        System.out.println("background-color: " + submitButton.getCssValue("background-color"));
        System.out.println("color: " + submitButton.getCssValue("color"));
        System.out.println("font-size: " + submitButton.getCssValue("font-size"));
        System.out.println("font-weight: " + submitButton.getCssValue("font-weight"));
    }
}