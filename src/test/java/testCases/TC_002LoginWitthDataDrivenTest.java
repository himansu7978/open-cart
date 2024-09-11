package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import utilities.DataProviderTest;

@Listeners(utilities.ExtentReportManager.class)
public class TC_002LoginWitthDataDrivenTest extends BaseClass {

//	@DataProvider(name = "InvalidData")
//	public Object[][] loginData() {
//		Object[][] obj = new Object[2][2];
//
//		obj[0][0] = "sahoohimansu555@gmail.com";
//		obj[0][1] = "Baba@1234";
//
//		obj[1][0] = "sahoo1@gmail.com";
//		obj[1][1] = "Sahoo@123";
//
//		return obj;
//
//	}

	@Test(dataProvider = "LoginTest", dataProviderClass = DataProviderTest.class, groups = { "DataDriven", "Master" })
	public void loginWithDataProvider(String email, String pwd, String expted) {
		HomePage hp = new HomePage(driver);
		hp.getLinkMy_Account().click();
		hp.getLinkLogin().click();

		// Validate login page
		LoginPage log = new LoginPage(driver);
		boolean validateloginpage = log.getValidateLoginPage().isDisplayed();
		Assert.assertEquals(validateloginpage, true, "Validation Failed");

		log.getTextloginEmail().sendKeys(email);
		log.getTextloginPassword().sendKeys(pwd);
		log.getButtonLogin().click();

		hp.getLinkMy_Account().click();

		// My Account
		MyAccountPage myAcc = new MyAccountPage(driver);
		boolean targetpage = myAcc.getMsgHeading().isDisplayed();

		if (expted.equalsIgnoreCase("Valid")) {
			if (targetpage == true) {

				myAcc.getMyaccoutLogout().click();
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}
		if (expted.equalsIgnoreCase("Invalid")) {
			if (targetpage == true) {
				myAcc.getMyaccoutLogout().click();
				Assert.assertTrue(false);
			} else {
				Assert.assertTrue(false);
			}
		}
	}

}
