package testCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObject.HomePage;
import pageObject.OpenCartRegisterPage;

@Listeners(utilities.ExtentReportManager.class)
public class TC_001RegistetTest extends BaseClass {
	
	@Test(groups = {"Regression","Master"})
	public void userRegistration() {
		
		Reporter.log("TC_001RegistetTest Start",true);
		
		// navigate to home page
		HomePage home = new HomePage(driver);
		// click on My_Account link
		home.getLinkMy_Account().click();
		// Click on RegisterLink
		home.getLinkRegister().click();

		// Go To the Register page
		OpenCartRegisterPage register = new OpenCartRegisterPage(driver);
		// Validate The Register page
		boolean registerpage = register.getRegisterPage().isDisplayed();

		Assert.assertEquals(registerpage, true, "Validation failed");

		// Enter the data First name TestField
		register.getTextFirstName().sendKeys("Maharajji");
		// Enter the Data From Last Name TestField
		register.getTextLastName().sendKeys("Nimkarolibaba");
		// Enter the data from EmailTestField
		register.getTextEmail().sendKeys(randomString()+"@gmail.com");
		//Enter Your Mobile number
		register.getTextTelephone().sendKeys(randomNumnber());
		// Enter the Data from Password Test filed
		register.getTextPassWord().sendKeys("Baba@1234");
		//Confirm your Password
		register.getTextConfirmPassword().sendKeys("Baba@1234");
		// Turn On the Subscribe Toggle
		register.getSubscribeTougle().click();
		// Turn on the Privacy Toggle
		register.getPrivacyTougle().click();
		// Click On the Confirm Button
		register.getButtonContinew().click();
		
		Assert.assertEquals(register.getMsgConfirmation().getText(),"Your Account Has Been Created!");
		Reporter.log("Validation Sucess",true);
		
		Reporter.log("TC_001RegistetTest Finshed",true);

	}

}
