package pomutilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMTest {

    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream(".//src/test/resources/DDT/orangehrm.properties");

        Properties p = new Properties();
        p.load(fis);

        String url = p.getProperty("URL");
        String username = p.getProperty("username");
        String password = p.getProperty("password");

        FileInputStream fis1 = new FileInputStream("./src/test/resources/DDT/Orangehrm2.xlsx");

        Workbook wb = WorkbookFactory.create(fis1);

        DataFormatter df = new DataFormatter();

        String firstName = df.formatCellValue(wb.getSheet("Sheet1").getRow(1).getCell(0));
        String middleName = df.formatCellValue(wb.getSheet("Sheet1").getRow(1).getCell(1));
        String lastName = df.formatCellValue(wb.getSheet("Sheet1").getRow(1).getCell(2));
        String vacancy = df.formatCellValue(wb.getSheet("Sheet1").getRow(1).getCell(3));
        String email = df.formatCellValue(wb.getSheet("Sheet1").getRow(1).getCell(4));

        String mobile = df.formatCellValue(
                wb.getSheet("Sheet1").getRow(1).getCell(5));

        String resume = df.formatCellValue(
                wb.getSheet("Sheet1").getRow(1).getCell(6));

     //   String dateOfApplication = df.formatCellValue(
       //         wb.getSheet("Sheet1").getRow(1).getCell(7));

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(url);

        LoginPage login = new LoginPage(driver);

        login.getUsernameTF(username);
        login.getPasswordTF(password);
        login.getLoginButton();

        RecruitmentPage recruitment = new RecruitmentPage(driver);

        recruitment.getRecruitment();
        recruitment.getAddButton();

        AddCandidatePage candidate = new AddCandidatePage(driver);

        candidate.getFirstName(firstName);
        candidate.getMiddleName(middleName);
        candidate.getLastName(lastName);
        candidate.getVacancy(vacancy);
        candidate.getEmail(email);
        candidate.getMobile(mobile);
        System.out.println(resume);
        candidate.getResume(resume);
        //candidate.getDateOfApplication(dateOfApplication);
        candidate.getSaveButton();
        
        wb.close();
        fis.close();
        fis1.close();

        
    }
}
