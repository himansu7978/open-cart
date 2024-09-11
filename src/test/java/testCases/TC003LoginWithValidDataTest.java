package testCases;


import org.testng.Reporter;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;

@Listeners(utilities.ExtentReportManager.class)
public class TC003LoginWithValidDataTest extends BaseClass {

	@Test(groups = {"Sanity","Master"})
	public void loginWithValidData() {
		//Home page
		HomePage hP = new HomePage(driver);
		hP.getLinkMy_Account().click();
		hP.getLinkLogin().click();
		
		//login
		LoginPage log = new LoginPage(driver);
		log.getTextloginEmail().sendKeys(p.readData("username"));
		log.getTextloginPassword().sendKeys(p.readData("password"));
		log.getButtonLogin().click();
		hP.getLinkMy_Account().click();
		
		//My Account
		MyAccountPage myAcc = new MyAccountPage(driver);
		//Assert.assertEquals(myAcc.getMsgHeading().getText(), "My Account");
		myAcc.getMyaccoutLogout().click();
		
		Reporter.log("LoginWith Valid Data TC003 Finished ");

	}

}
