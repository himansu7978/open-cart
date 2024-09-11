package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//h2[text()='Returning Customer']")
	private WebElement validateLoginPage;

	@FindBy(id = "input-email")
	private WebElement textloginEmail;

	@FindBy(name = "password")
	private WebElement textloginPassword;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement buttonLogin;

	public WebElement getValidateLoginPage() {
		return validateLoginPage;
	}

	public WebElement getTextloginEmail() {
		return textloginEmail;
	}

	public WebElement getTextloginPassword() {
		return textloginPassword;
	}

	public WebElement getButtonLogin() {
		return buttonLogin;
	}

}
