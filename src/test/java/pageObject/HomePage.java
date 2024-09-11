package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement linkMy_Account;

	@FindBy(xpath = "//a[text()='Register']")
	private WebElement linkRegister;

	@FindBy(xpath = "//a[text()='Login']")
	private WebElement linkLogin;

	public WebElement getLinkLogin() {
		return linkLogin;
	}

	public WebElement getLinkMy_Account() {
		return linkMy_Account;
	}

	public WebElement getLinkRegister() {
		return linkRegister;
	}

}
