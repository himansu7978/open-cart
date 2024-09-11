package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//h2[text()='My Account']")
	private WebElement msgHeading;

	@FindBy(xpath = "(//a[text()='Logout'])[1]")
	private WebElement myaccoutLogout;

	public WebElement getMsgHeading() {
		return msgHeading;
	}

	public WebElement getMyaccoutLogout() {
		return myaccoutLogout;
	}

}
