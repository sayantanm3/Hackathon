package testScenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import libraries.Highlight;
import testObjectRepository.cabPage;
import testObjectRepository.hotelPage;

public class TS2_navigateToHotels extends Main{

	public hotelPage hotel;
	public cabPage cab;
	public static ExtentTest logger;
	
	@BeforeTest
	public void initiateHotels() {
		hotel = new hotelPage(driver);
		cab = new cabPage(driver);
	}
	
	@Test(priority = 13, groups="Smoke")
	public void navigateToHotels() {
		hotel = new hotelPage(driver);
		Highlight.highLighterMethod(driver, hotel.hotelTab());
		hotel.hotelTab().click();
		if(driver.getTitle().contains("Hotel"))
			Reporter.log("Navigated to Hotels");
		logger= report.createTest("Navigate to Hotels");
		logger.log(Status.INFO, "Browser redirected to hotel page");
		logger.log(Status.PASS, "Successfully landed on hotel Page");
		
	}
	@Test(priority=14, groups="Smoke")
	public void checkforPopUps() 
	{
		driver.manage().deleteAllCookies();
		cab.dealWithPopups();
	}
}
