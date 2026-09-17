package dataelement;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import keyworddrivers.demosauceexecutor;
import pomutilities1.ExcelUtility;
import pomutilities1.ReadProperties;

public class SauceDemoTest {
    demosauceexecutor executor;
    String username;
    String password;
    String firstname;
    String lastname;
    String postalcode;

    @BeforeClass
    public void setUp() {
        executor = new demosauceexecutor();
        username = ExcelUtility.getData("SauceDemo", 1, 0);
        password = ExcelUtility.getData("SauceDemo", 1, 1);
        firstname = ExcelUtility.getData("SauceDemo", 1, 2);
        lastname = ExcelUtility.getData("SauceDemo", 1, 3);
        postalcode = ExcelUtility.getData("SauceDemo", 1, 4);
        executor.executor("LAUNCH_BROWSER");
        executor.openURL(
                ReadProperties.getProperty("url"));
    }

    @Test
    public void loginTest() {
        executor.enterUsername(username);
        executor.enterPassword(password);
        executor.executor("LOGIN");
        executor.executor("VERIFY_PRODUCTS");
    }

    @Test(dependsOnMethods = "loginTest")
    public void orderPlacementTest() {
        executor.executor("ADD_BACKPACK");
        executor.executor("VERIFY_CART_COUNT");
        executor.executor("OPEN_CART");
        executor.executor("VERIFY_BACKPACK");
        executor.executor("CHECKOUT");
        executor.enterFirstName(firstname);
        executor.enterLastName(lastname);
        executor.enterPostalCode(postalcode);
        executor.executor("CONTINUE");
        executor.executor("VERIFY_OVERVIEW");
        executor.executor("FINISH");
        executor.executor("VERIFY_THANKYOU");
    }

    @AfterClass
    public void tearDown() {

        executor.executor("CLOSE_BROWSER");
    }
}
