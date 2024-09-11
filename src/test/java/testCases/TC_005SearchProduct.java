package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import pageObject.SearchPage;

@Listeners(utilities.ExtentReportManager.class)
public class TC_005SearchProduct extends BaseClass {
	@DataProvider(name = "SearchProduct")
	public Object []  product(){
		Object obj [] =new Object [4];
		
		obj[0]="Iphone";
		obj[1]="Laptop";
		obj[2]="Mac";
		obj[3]="Samsung";
		
		return obj;			
	}
	
	@Test(dataProvider = "SearchProduct",groups = {"Sanity","Master"})
	public void searchTest(String search) {
		//Home page
				HomePage hP = new HomePage(driver);
				hP.getLinkMy_Account().click();
				hP.getLinkLogin().click();
				
				//login
				LoginPage log = new LoginPage(driver);
				log.getTextloginEmail().sendKeys(p.readData("username"));
				log.getTextloginPassword().sendKeys(p.readData("password"));
				log.getButtonLogin().click();
			
				//Searc product
				
				SearchPage sea=new SearchPage(driver);
				sea.getSerachTextField().sendKeys(search);
				sea.getSearchButton().click();
				
				//for clicking my account
				hP.getLinkMy_Account().click();
				
				//for logout
				MyAccountPage myp= new MyAccountPage(driver);
				myp.getMyaccoutLogout().click();
				
				
	}

}
