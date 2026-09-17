package pomutilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecruitmentPage {

	public RecruitmentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Recruitment']")
	private WebElement recruitment;

	@FindBy(xpath = "//button[contains(.,'Add')]")
	private WebElement addButton;

	public void getRecruitment() {
		recruitment.click();
	}

	public void getAddButton() {
		addButton.click();
	}
}
