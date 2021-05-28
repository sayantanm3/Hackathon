package testScenarios;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import libraries.Highlight;
import libraries.ScreenshotManager;
import testObjectRepository.cabPage;

public class TS3_bookACab extends Main{
	
public cabPage cab;
public static ExtentTest logger;

	
	@BeforeTest
	public void initiateCabs() {
		cab = new cabPage(driver);
	}
	
	//Radio button One-Way is selected
	
	@Test(priority=2, groups="Regression")
	public void selectOneWayBooking()
	{
		cab = new cabPage(driver);
		Highlight.highLighterMethod(driver, cab.radioButton());
		cab.radioButton().click();
		Reporter.log("One Way Radio button is selected");
		logger= report.createTest("Select One Way Trip");
		logger.log(Status.PASS, "One Way Trip Radio Button is selected");
	}
	
	//Entering Departure city
	@Test(priority=3, groups="Regression")
	public void enterSourceCity() throws IOException
	{
		cab = new cabPage(driver);
		Highlight.highLighterMethod(driver, cab.fromCity());
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(cab.fromCity()));
		cab.fromCity.click();
		wait.until(ExpectedConditions.visibilityOf(cab.fromCityText()));
		//Entering Delhi fetching value from excel
		cab.fromCityText.sendKeys("Delhi");
		Highlight.highLighterMethod(driver, cab.selectfromList());
		wait.until(ExpectedConditions.visibilityOf(cab.selectfromList()));
		//Selecting Delhi from suggested city list
		cab.selectFromList.click();
		Reporter.log("Entered source city as Delhi");
		logger= report.createTest("Book a Cab");
		logger.log(Status.INFO, "From City is clickable and search area is displayed");
		logger.log(Status.INFO, "Delhi is entered");
		logger.log(Status.INFO, "Delhi was selected from List");
		logger.log(Status.PASS, "Delhi was accepted as origin City");
		
	}
	
	//Testing if website accepts same city as departure and arrival
	@Test(priority=4, groups="Regression")
	public void enterSameCity() throws InterruptedException, IOException
	{
		
		cab = new cabPage(driver);
		Highlight.highLighterMethod(driver, cab.toCity());
		cab.toCity().click();
		//Entering destination city as Delhi
		cab.toCityText().sendKeys("Delhi");
		Highlight.highLighterMethod(driver, cab.selectfromList());
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(cab.selectfromList()));
		//Selecting Delhi from suggested city list
		cab.selectFromList.click();
		Reporter.log("Entering Destination city as Delhi");
		logger.log(Status.INFO, "Delhi is entered as Destination City");
		logger.log(Status.INFO, "Delhi is selected from List");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='errorMessage']")));
		
		//Verifying the error message
		WebElement Error = driver.findElement(By.xpath("//div[@id='errorMessage']"));
		Highlight.highLighterMethod(driver, Error);
		//Thread.sleep(2000);
		ScreenshotManager.screenshot(driver, "CityError");
		
		if(Error.getText().contains("The Origin City & Destination City cannot be the same"))
			{
			Reporter.log("ERROR MESSAGE OCCUR: The Origin City & Destination City cannot be the same");
			logger.log(Status.PASS, "ERROR MESSAGE OCCURS: The Origin City & Destination City cannot be the same");
			}
		
	}
	
	//Selecting Manali as Destination city
	@Test(priority=5, groups="Regression")
	public void enterDestinationCity() throws IOException
	{
		cab = new cabPage(driver);
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(cab.toCity()));
		cab.toCity().click();
		wait.until(ExpectedConditions.visibilityOf(cab.toCityText2()));
		//Entering Manali as Destination city
		cab.toCityText2().sendKeys("Manali, Himachal");
		wait.until(ExpectedConditions.visibilityOf(cab.selectFromList2()));
		Highlight.highLighterMethod(driver, cab.selectFromList2());
		//Selecting Manali from suggested city list
		cab.selectFromList2().click();
		Reporter.log("Entering Destination City as Manali, Himachal Pradesh");
		logger.log(Status.INFO, "Destination City is clickable and search area is displayed");
		logger.log(Status.INFO, "Manali is entered");
		logger.log(Status.INFO, "Manali was selected from List");
		logger.log(Status.PASS, "Manali was accepted as origin City");
		
	}
	
	//Selecting the departure date
	@Test(priority=6, groups="Regression")
	public void enterDepartureDate() throws InterruptedException
	{
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(cab.fromDate()));
		Highlight.highLighterMethod(driver, cab.fromDate());
		//Clicking to open calendar menu
		cab.fromDate().click();
		//Clicking calendar next month arrow until august appears
		int j=0;
		while(j<2)
		{
			Highlight.highLighterMethod(driver, cab.calendarRightArrow());
			cab.calendarRightArrow().click();
		j++;
		}	
		Highlight.highLighterMethod(driver,cab.fromDatePicker());
		//Selecting a future date
		cab.fromDatePicker().click();
		Reporter.log("Selecting a future booking Date as 19 Aug 2021");
		logger.log(Status.INFO, "Date Picker is clickable");
		logger.log(Status.INFO, "Calendar Menu is Visible");
		logger.log(Status.PASS, "19 Aug 2021 is selected from Calendar");
	}
	
	//Selecting Pickup time 
	@Test(priority=7, groups="Regression")
	public void selectPickupTime() throws InterruptedException
	{
		
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(cab.pickupTime()));
		Highlight.highLighterMethod(driver, cab.pickupTime());
		//Clicking Pickup time to open dropdown menu
		cab.pickupTime().click();
		wait.until(ExpectedConditions.elementToBeClickable(cab.pickUpTimeList()));
		Highlight.highLighterMethod(driver, cab.pickUpTimeList());
		//Selecting a time from dropdown menu
		cab.pickupTimeList.click();
		Reporter.log("Selecting pick-up time as 10:00 AM");
		logger.log(Status.INFO, "Pick-Up Time dropdown expands on click");
		logger.log(Status.PASS, "10:00AM is selected from Dropdown");
	}
	
	//Clicking on search
	@Test(priority=8, groups="Regression")
	public void clickSearch() throws IOException, InterruptedException
	{
		Highlight.highLighterMethod(driver, cab.search());
		ScreenshotManager.screenshot(driver, "SearchforCabs");
		//Thread.sleep(2000);	//Sleep used to capture screenshot
		cab.search().click();
		Reporter.log("Clicking on Search");
		logger.log(Status.INFO, "Search Menu is clickable");
		logger.log(Status.PASS, "Seach button redirects to Search Results");
	}
	
	
	
	
}
