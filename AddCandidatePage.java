package pomutilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCandidatePage {

    WebDriver driver;

    public AddCandidatePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "firstName")
    private WebElement firstName;

    @FindBy(name = "middleName")
    private WebElement middleName;

    @FindBy(name = "lastName")
    private WebElement lastName;

    @FindBy(xpath = "//label[text()='Vacancy']/following::div[contains(@class,'oxd-select-text')][1]")
    private WebElement vacancy;

    @FindBy(xpath = "(//input[@placeholder='Type here'])[1]")
    private WebElement email;

    @FindBy(xpath = "(//input[@placeholder='Type here'])[2]")
    private WebElement mobile;

    @FindBy(xpath = "//input[@type='file']")
    private WebElement resume;

   // @FindBy(xpath = "//input[@placeholder='yyyy-dd-mm']")
    //private WebElement dateOfApplication;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;

    public void getFirstName(String value) {
        firstName.sendKeys(value);
    }

    public void getMiddleName(String value) {
        middleName.sendKeys(value);
    }

    public void getLastName(String value) {
        lastName.sendKeys(value);
    }

    public void getVacancy(String value) {
        vacancy.click();
        driver.findElement(By.xpath("//div[@role='option']//span[text()='" + value + "']")).click();
    }

    public void getEmail(String value) {
        email.sendKeys(value);
    }

    public void getMobile(String value) {
        mobile.sendKeys(value);
    }

    public void getResume(String path) {
        resume.sendKeys(path);
    }

  //  public void getDateOfApplication(String value) {
    //    dateOfApplication.sendKeys(value);
    //}

    public void getSaveButton() {
        saveButton.click();
    }
}