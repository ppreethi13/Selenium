package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropTest {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://demoapps.qspiders.com/ui/dragDrop/dragToCorrect?sublist=2");
		
		WebElement mob1= driver.findElement(By.xpath("//div[text()='Mobile Charger']"));
		WebElement lap1= driver.findElement(By.xpath("//div[text()='Laptop Charger']"));
		
		WebElement mob2= driver.findElement(By.xpath("//div[text()='Mobile Cover']"));
		WebElement lap2= driver.findElement(By.xpath("//div[text()='Laptop Cover']"));
		
		WebElement mob3=driver.findElement(By.xpath("//div[text()='Mobile Accessories']"));
		WebElement lap3=driver.findElement(By.xpath("//div[text()='Laptop Accessories']"));
		
		Actions action=new Actions(driver);
		action.dragAndDrop(mob1, mob3).perform();
		action.dragAndDrop(mob2, mob3).perform();
		action.dragAndDrop(lap1, lap3).perform();
		action.dragAndDrop(lap2, lap3).perform();
		driver.quit();
		System.out.println("Order is Placed");
	}
}