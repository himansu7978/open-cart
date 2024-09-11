package baseTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

import utilities.ReadDataPropertiesFile;

public class BaseClass {
	public static WebDriver driver;
	public ReadDataPropertiesFile p;

	@BeforeClass(groups = { "Sanity", "Regression", "Master", "DataDriven"})
	@Parameters({ "os", "browser" })
	public void setUp(String os, String browser) {

		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid Browser");
			return;
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		p = new ReadDataPropertiesFile();
		driver.get(p.readData("url"));// Reading the data from Properties file

	}

	@BeforeMethod
	public void login() {
		Reporter.log("Login Done ", true);
	}

	@AfterClass(groups = { "Sanity", "Regression", "Master" })
	public void logout() {
		Reporter.log("Logout Done", true);
	}

	@AfterClass
	public void closeSetup() {
		driver.quit();
	}

	public String randomString() {

		String randomString = RandomStringUtils.randomAlphabetic(5);

		return randomString;
	}

	public String randomNumnber() {
		String randomNumber = RandomStringUtils.randomNumeric(10);

		return randomNumber;
	}

	public String captureScreen(String tname) {

		String timeStamp = new SimpleDateFormat("YYYY-MM-DD-HH-MM-SS").format(new Date());

		TakesScreenshot shot = (TakesScreenshot) driver;
		File sorce = shot.getScreenshotAs(OutputType.FILE);
		String targetFilepath = System.getProperty("user.dir") + "\\screenShots" + tname + timeStamp
				+ ".png";
		File destination = new File(targetFilepath);
		try {
			Files.copy(sorce, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sorce.renameTo(destination);
		return targetFilepath;
	}
}
