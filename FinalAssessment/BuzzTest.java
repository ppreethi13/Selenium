package base;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import testcases.BuzzPage;
import testcases.LoginPage;

public class BuzzTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        BuzzPage buzzPage = new BuzzPage(driver);

        buzzPage.clickBuzz();

        buzzPage.enterPost("heyyyyyyyyyyyyyyyyyy");

        buzzPage.clickPost();

        if (buzzPage.getRecentPost().contains("heyyyyyyyyyyyyyyyyyy")) {
            System.out.println("Post is displayed");
        } else {
            System.out.println("Post is not displayed");
        }

        buzzPage.logout();

        driver.quit();
    }
}