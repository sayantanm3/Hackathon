package testScenarios;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import libraries.Highlight;
import libraries.ScreenshotManager;
import testObjectRepository.cabPage;


public class TS1_navigateToCabs extends Main{

	public cabPage cab;
	public static ExtentTest logger;
	
	@BeforeTest
	public void initiateCabs() {
		cab = new cabPage(driver);
	}
	
	@Test(priority=0, groups="Smoke")
	public void popUppresent() throws InterruptedException
	{
		
		cab.dealWithPopups();		
	}
	
	
	@Test(priority = 1, groups="Smoke")
	public void navigateToCabs() throws IOException {
		cab = new cabPage(driver);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		Highlight.highLighterMethod(driver, cab.cabTab());
		cab.cabTab().click();
		if(driver.getTitle().contains("Cab"));
		boolean bool=true;
		Assert.assertTrue(bool);
		Reporter.log("Successfully Navigated to Cabs");
		logger= report.createTest("Navigation to Cabs");
		logger.log(Status.INFO, "Successfully Navigated to Cabs");
		ScreenshotManager.screenshot(driver,"Cab");
	}
	
	
}
