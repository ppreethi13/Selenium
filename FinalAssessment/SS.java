package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SS {
	

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.shoppersstack.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.findElement(By.className("featuredProducts_cardBody__l4gLE")).click();
        driver.findElement(By.id("Check Delivery")).sendKeys("583101");
        WebElement ref =driver.findElement(By.id("Check"));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(ref));
        ref.click();
        String text = driver.findElement(By.xpath("//p[text()='Not Deliveriable.']")).getText();
    	System.out.println(text);
        Thread.sleep(2000);
        driver.quit();

}
}