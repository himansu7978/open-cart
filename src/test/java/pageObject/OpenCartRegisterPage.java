package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenCartRegisterPage extends BasePage {
	
	
	
	public OpenCartRegisterPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath = "//h1[text()='Register Account']")
	private WebElement registerPage;
	
	@FindBy(name = "firstname")
	private WebElement  textFirstName;
	
	@FindBy(id = "input-lastname")
	private WebElement textLastName;
	
	@FindBy(name = "email")
	private WebElement textEmail;
	
	@FindBy(name="telephone")
	private WebElement textTelephone;
	
	@FindBy(name = "password")
	private WebElement textPassWord;
	
	@FindBy(name = "confirm")
	private WebElement textConfirmPassword;
	
	@FindBy(name = "newsletter")
	private WebElement SubscribeTougle;
	
	@FindBy(name = "agree")
	private WebElement privacyTougle;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement buttonContinew;
	
	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	private WebElement msgConfirmation;

	public WebElement getMsgConfirmation() {
		return msgConfirmation;
	}

	public WebElement getRegisterPage() {
		return registerPage;
	}

	public WebElement getTextFirstName() {
		return textFirstName;
	}

	public WebElement getTextLastName() {
		return textLastName;
	}

	public WebElement getTextEmail() {
		return textEmail;
	}
	public WebElement getTextTelephone() {
		return textTelephone;
	}

	public WebElement getTextPassWord() {
		return textPassWord;
	}
	public  WebElement getTextConfirmPassword() {
		return textConfirmPassword;
		
	}

	public WebElement getSubscribeTougle() {
		return SubscribeTougle;
	}

	public WebElement getPrivacyTougle() {
		return privacyTougle;
	}

	public WebElement getButtonContinew() {
		return buttonContinew;
	}
	
	
	
	
}
