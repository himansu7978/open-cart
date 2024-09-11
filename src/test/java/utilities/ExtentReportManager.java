package utilities;

import java.awt.Desktop;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseTest.BaseClass;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;

	String reportName;

	@Override
	public void onStart(ITestContext context) {

		String timeStamp = new SimpleDateFormat("YYYY.MM.DD.HH.MM.SS").format(new Date());
		reportName = "Test-Report-" + timeStamp + ".html";
		sparkReporter = new ExtentSparkReporter(".\\reports\\" + reportName);

		sparkReporter.config().setDocumentTitle("Open Cart Automation Reports");// Title of Report
		sparkReporter.config().setReportName("Open Cart Functional Testing");// name of the Testing
		sparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application ", "OpenCart");
		extent.setSystemInfo("Module ", "Admin");
		extent.setSystemInfo("Sub module ", "Custmor");
		extent.setSystemInfo("Username ", System.getProperty("user.name"));
		extent.setSystemInfo("Enviorment ", "QA");

		String os = context.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating Sysytem ", os);

		String browser = context.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Operating Sysytem ", browser);

		List<String> includeGroups = context.getCurrentXmlTest().getIncludedGroups();
		if (!includeGroups.isEmpty()) {
			extent.setSystemInfo("Groups", includeGroups.toString());
		}

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());// to disply the grop reports
		test.log(Status.PASS, result.getName() + " got SuccessFully Executed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());// to disply the grop reports

		test.log(Status.FAIL, result.getName() + " got Failed");
		test.log(Status.INFO, result.getThrowable().getMessage());

		try {
			String imgPath = new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());// to disply the grop reports

		test.log(Status.SKIP, result.getName() + " got Skiped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		String pathOfExtentReport=System.getProperty("user.dir")+"\\screenSort\\"+reportName;
		File extentReport= new File(pathOfExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*try {
			URL url=new URL(reportName);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		*/
	}
	
	
	
	
}
