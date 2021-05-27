package testScenarios;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;

import libraries.DriverSetup;
import libraries.ExtentReportManager;

public class Main extends DriverSetup{
	
	public static WebDriver driver;
	public static ExtentReports report;
	
	@BeforeSuite
	public void startTest() throws IOException											
	{
		driver= initializeDriver();	
		report=ExtentReportManager.getReportInstance();	
	}
	
	@AfterSuite
	public void exitBrowser()
	{
		report.flush();
		driverClose();
	}
	
}
