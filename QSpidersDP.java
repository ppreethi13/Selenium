package WebDriver;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QSpidersDP {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoapps.qspiders.com/ui/datePick?sublist=0");
        WebElement dateField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Select A Date']")));
        dateField.click();
        WebElement nextMonth = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Next Month']")));
        nextMonth.click();
        WebElement date10 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'react-datepicker__day--010') and not(contains(@class,'react-datepicker__day--outside-month'))]")));
        date10.click();
        wait.until(driver1 -> {
            String value = dateField.getAttribute("value");
            return value != null && !value.trim().isEmpty();
        });
        String selectedDate = dateField.getAttribute("value");
        if (selectedDate.contains("10") && selectedDate.contains("2026")) {
            System.out.println("Date selected successfully: " + selectedDate);
        } else {
            throw new AssertionError("Date was not displayed correctly. Actual value: " + selectedDate);
        }
        while (true) {
            Thread.sleep(1000);
        }
    }
}