package pomutilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	//declare
		
	@FindBy(name = "username")
	private WebElement usernameTF;
	
	@FindBy(name = "password")
	private WebElement passwordTF;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;

	public WebDriver getDriver() {
		return driver;
	}

	public void getUsernameTF(String value)
	{
		usernameTF.sendKeys(value);
	}

	public void getPasswordTF(String value) 
	{
		passwordTF.sendKeys(value);
	}

	public void getLoginButton() 
	{
		loginButton.click();
	}
	
	}
