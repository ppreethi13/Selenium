package WebDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebPage {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.instagram.com/");
		driver.findElement(By.xpath("//button[@type='button']")).click();
		driver.findElement(By.name("email")).sendKeys("ppreethi1311@gmail.com");
		driver.findElement(By.id("_r_5_")).sendKeys("preethi@123");
		WebElement textfield = driver.findElement(By.name("email"));
		System.out.println("id"+textfield.getSize());
		WebElement text = driver.findElement(By.id("_r_5_"));
		System.out.println("pass"+ text.getSize());
	}
}
