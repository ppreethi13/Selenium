package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BuzzPage {

    WebDriver driver;

    By buzz = By.xpath("//span[text()='Buzz']");
    By postText = By.xpath("//textarea[@placeholder=\"What's on your mind?\"]");
    By postButton = By.xpath("//button[normalize-space()='Post']");
    By recentPost = By.xpath("(//div[contains(@class,'orangehrm-buzz-post-body')])[1]");
    By profile = By.xpath("//span[contains(@class,'oxd-userdropdown-tab')]");
    By logout = By.xpath("//a[text()='Logout']");

    public BuzzPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickBuzz() {
        driver.findElement(buzz).click();
    }

    public void enterPost(String text) {
        driver.findElement(postText).sendKeys(text);
    }

    public void clickPost() {
        driver.findElement(postButton).click();
    }

    public String getRecentPost() {
        return driver.findElement(recentPost).getText();
    }

    public void logout() {
        driver.findElement(profile).click();
        driver.findElement(logout).click();
    }
}