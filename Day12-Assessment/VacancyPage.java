package pomutilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VacancyPage {

    WebDriver driver;
    WebDriverWait wait;

    // Vacancy Name
    By vacancyNameField = By.xpath(
            "//label[normalize-space()='Vacancy Name']/following::input[1]");

    // Job Title dropdown
    By jobTitleDropdown = By.xpath(
            "//label[normalize-space()='Job Title']/following::div[contains(@class,'oxd-select-text')][1]");

    // Description
    By descriptionField = By.xpath(
            "//label[normalize-space()='Description']/following::textarea[1]");

    // Hiring Manager
    By hiringManagerField = By.xpath(
            "//label[normalize-space()='Hiring Manager']/following::input[1]");

    // Number of Positions
    By numberOfPositionsField = By.xpath(
            "//label[normalize-space()='Number of Positions']/following::input[1]");

    // Save button
    By saveButton = By.xpath(
            "//button[normalize-space()='Save']");


    // Constructor
    public VacancyPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20));
    }


    // ==========================================
    // ENTER VACANCY NAME
    // ==========================================

    public void enterVacancyName(String vacancyName) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        vacancyNameField));

        element.clear();
        element.sendKeys(vacancyName);
    }


    // ==========================================
    // SELECT JOB TITLE
    // ==========================================

    public void selectJobTitle(String jobTitle) {

        System.out.println(
                "Job Title from Excel: [" + jobTitle + "]");

        // Step 1: Click Job Title dropdown
        WebElement dropdown = wait.until(
                ExpectedConditions.elementToBeClickable(
                        jobTitleDropdown));

        dropdown.click();

        System.out.println(
                "Job Title dropdown opened");


        // Step 2: Wait for dropdown options
        By optionsLocator = By.xpath(
                "//div[@role='option']");

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        optionsLocator));


        // Step 3: Get all options
        List<WebElement> options =
                driver.findElements(optionsLocator);

        System.out.println(
                "Number of Job Title options found: "
                + options.size());


        // Step 4: Search for required job title
        boolean found = false;

        for (WebElement option : options) {

            String optionText =
                    option.getText().trim();

            System.out.println(
                    "Available Job Title: ["
                    + optionText + "]");


            if (optionText.equalsIgnoreCase(
                    jobTitle.trim())) {

                System.out.println(
                        "Matching Job Title found: "
                        + optionText);


                // Scroll option into view
                ((JavascriptExecutor) driver)
                        .executeScript(
                                "arguments[0].scrollIntoView({block:'center'});",
                                option);


                // Wait until clickable
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                option));


                // Click the actual option
                option.click();

                System.out.println(
                        "Job Title clicked");


                found = true;

                break;
            }
        }


        // Step 5: If job title wasn't found
        if (!found) {

            throw new RuntimeException(
                    "Job Title not found in dropdown: "
                    + jobTitle);
        }


        // Small wait for dropdown to close
        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(
                        optionsLocator));

        System.out.println(
                "Job Title selected successfully");
    }


    // ==========================================
    // ENTER DESCRIPTION
    // ==========================================

    public void enterDescription(String description) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        descriptionField));

        element.clear();
        element.sendKeys(description);
    }


    // ==========================================
    // SELECT HIRING MANAGER
    // ==========================================

    public void selectHiringManager(
            String hiringManager) {

        System.out.println(
                "Hiring Manager from Excel: ["
                + hiringManager + "]");

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        hiringManagerField));

        element.clear();

        element.sendKeys(hiringManager);


        By managerOption = By.xpath(
                "//div[@role='option']//span[normalize-space()='"
                + hiringManager
                + "']");


        WebElement option = wait.until(
                ExpectedConditions.elementToBeClickable(
                        managerOption));


        option.click();


        System.out.println(
                "Hiring Manager selected successfully");
    }


    // ==========================================
    // ENTER NUMBER OF POSITIONS
    // ==========================================

    public void enterNumberOfPositions(
            String positions) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        numberOfPositionsField));

        element.clear();

        element.sendKeys(positions);
    }


    // ==========================================
    // CLICK SAVE
    // ==========================================

    public void clickSave() {

        WebElement save = wait.until(
                ExpectedConditions.elementToBeClickable(
                        saveButton));

        save.click();

        System.out.println(
                "Save button clicked successfully");
    }
}