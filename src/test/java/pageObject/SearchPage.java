package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "search")
	private WebElement serachTextField;

	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;

	public WebElement getSerachTextField() {
		return serachTextField;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

}
