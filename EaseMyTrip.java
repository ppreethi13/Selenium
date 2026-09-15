package WebDriver;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class EaseMyTrip {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.easemytrip.com/");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[text()=' One Way']")).click();
		WebElement fromfield = driver.findElement(By.id("FromSector_show"));
		fromfield.click();
		driver.findElement(By.id("a_FromSector_show")).sendKeys("Bengaluru");
	    Thread.sleep(1000);
	    driver.findElement(By.id("spnBengaluru")).click();
	    driver.findElement(By.id("a_Editbox13_show")).sendKeys("goa");
	    driver.findElement(By.id("spnGoa")).click();
	    driver.findElement(By.id("19/10/2026")).click();
	    driver.findElement(By.id("rtag")).click();
	    driver.findElement(By.id("fiv_2_27/10/2026")).click();
	    driver.findElement(By.id("iDownArr")).click();
	    driver.findElement(By.id("add")).click();
	    driver.findElement(By.xpath("(//div[@class=\"flex-adltcol\"])[1]")).click();
	    driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
	    String title=driver.getTitle();
		if(title.contains("EaseMyTrip.com Lowest Airfare, Flight Tickets, Cheap Air Tickets – EaseMyTrip.com"))
		{
			System.out.println("flight-results page is displayed.");
		}
		else
		{
			System.out.println("flight-results page is not displayed.");
		}

	}

}