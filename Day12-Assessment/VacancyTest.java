package tests;

import org.testng.annotations.Test;

import baseclassutility.BaseClass1;
import pomutilities.LoginPage1;
import pomutilities.RecruitmentPage1;
import pomutilities.VacancyPage;
import pomutilities.ExcelReader;

public class VacancyTest extends BaseClass1 {

    LoginPage1 loginPage;
    RecruitmentPage1 recruitmentPage;
    VacancyPage vacancyPage;

    @Test
    public void createVacancyTest() {

        // ==========================================
        // READ DATA FROM EXCEL
        // ==========================================

        System.out.println("======================================");
        System.out.println("READING DATA FROM EXCEL");
        System.out.println("======================================");


        String username =
                ExcelReader.getData(
                        "Sheet1", 1, 0);

        String password =
                ExcelReader.getData(
                        "Sheet1", 1, 1);

        String vacancyName =
                ExcelReader.getData(
                        "Sheet1", 1, 2);

        String jobTitle =
                ExcelReader.getData(
                        "Sheet1", 1, 3);

        String vacancyDescription =
                ExcelReader.getData(
                        "Sheet1", 1, 4);

        String hiringManager =
                ExcelReader.getData(
                        "Sheet1", 1, 5);

        String positions =
                ExcelReader.getData(
                        "Sheet1", 1, 6);


        // ==========================================
        // PRINT EXCEL DATA
        // ==========================================

        System.out.println("--------------------------------------");

        System.out.println(
                "Username       : [" + username + "]");

        System.out.println(
                "Password       : [" + password + "]");

        System.out.println(
                "Vacancy Name   : [" + vacancyName + "]");

        System.out.println(
                "Job Title      : [" + jobTitle + "]");

        System.out.println(
                "Description    : [" + vacancyDescription + "]");

        System.out.println(
                "Hiring Manager : [" + hiringManager + "]");

        System.out.println(
                "Positions      : [" + positions + "]");

        System.out.println("--------------------------------------");


        // ==========================================
        // STEP 1 - LOGIN
        // ==========================================

        System.out.println("Step 1: Logging in");

        loginPage =
                new LoginPage1(driver);

        loginPage.login(
                username,
                password);

        System.out.println("Login successful");


        // ==========================================
        // STEP 2 - RECRUITMENT
        // ==========================================

        System.out.println(
                "Step 2: Opening Recruitment and Vacancies");

        recruitmentPage =
                new RecruitmentPage1(driver);

        recruitmentPage.openVacancyPage();

        System.out.println(
                "Recruitment and Vacancies opened");


        // ==========================================
        // STEP 3 - ADD BUTTON
        // ==========================================

        System.out.println(
                "Step 3: Clicking Add button");

        recruitmentPage.clickAddVacancy();

        System.out.println(
                "Add Vacancy page opened");


        // ==========================================
        // CREATE VACANCY PAGE OBJECT
        // ==========================================

        vacancyPage =
                new VacancyPage(driver);


        // ==========================================
        // STEP 4 - VACANCY NAME
        // ==========================================

        System.out.println(
                "Step 4: Entering vacancy name");

        vacancyPage.enterVacancyName(
                vacancyName);

        System.out.println(
                "Vacancy name entered");


        // ==========================================
        // STEP 5 - JOB TITLE
        // ==========================================

        System.out.println(
                "Step 5: Selecting job title");

        System.out.println(
                "Job Title being sent to application: ["
                + jobTitle
                + "]");

        vacancyPage.selectJobTitle(
                jobTitle);

        System.out.println(
                "Job title selected");


        // ==========================================
        // STEP 6 - DESCRIPTION
        // ==========================================

        System.out.println(
                "Step 6: Entering description");

        vacancyPage.enterDescription(
                vacancyDescription);

        System.out.println(
                "Description entered");


        // ==========================================
        // STEP 7 - HIRING MANAGER
        // ==========================================

        System.out.println(
                "Step 7: Selecting hiring manager");

        vacancyPage.selectHiringManager(
                hiringManager);

        System.out.println(
                "Hiring manager selected");


        // ==========================================
        // STEP 8 - NUMBER OF POSITIONS
        // ==========================================

        System.out.println(
                "Step 8: Entering number of positions");

        vacancyPage.enterNumberOfPositions(
                positions);

        System.out.println(
                "Number of positions entered");


        // ==========================================
        // STEP 9 - SAVE
        // ==========================================

        System.out.println(
                "Step 9: Clicking Save button");

        vacancyPage.clickSave();

        System.out.println(
                "Save button clicked successfully");


        // ==========================================
        // TEST COMPLETE
        // ==========================================

        System.out.println("======================================");
        System.out.println("VACANCY CREATION COMPLETED");
        System.out.println("======================================");
    }
}