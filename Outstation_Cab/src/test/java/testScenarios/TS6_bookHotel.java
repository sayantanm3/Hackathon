package testScenarios;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import libraries.Highlight;
import libraries.ScreenshotManager;
import testObjectRepository.hotelPage;

public class TS6_bookHotel extends Main{
	
public hotelPage hotel;
public static ExtentTest logger;
	
	@BeforeTest
	public void initiateHotels() {
		hotel = new hotelPage(driver);
	}
	
	//Selecting City
	@Test(priority=15, groups="Regression")
	public void selectCity() throws InterruptedException
	{
		hotel = new hotelPage(driver);
		Highlight.highLighterMethod(driver, hotel.city());
		hotel.city().click();
		//Entering city as Manali
		hotel.enterCity().sendKeys("Manali, Himachal Pradesh");
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(hotel.selectFromList()));
		Highlight.highLighterMethod(driver, hotel.selectFromList());
		//Selecting Manali from suggested list
		hotel.selectFromList.click();
		logger= report.createTest("Book Hotel and get Adult List");
		logger.log(Status.INFO, "City Search menu is clickable");
		logger.log(Status.INFO, "Search box appears on click");
		logger.log(Status.INFO, "Manali is entered");
		logger.log(Status.PASS, "Manali is accepted as City");
	}
	
	//Selecting a CheckIn date
	@Test(priority=16, groups="Regression")
	public void enterCheckInDate() throws InterruptedException
	{
		hotel = new hotelPage(driver);
		hotel.checkIn();
		int j=0;
		
		WebDriverWait wait = new WebDriverWait(driver,3);
		wait.until(ExpectedConditions.elementToBeClickable(hotel.nextMonth()));
		//Navigating calendar to display August 
		while(j<2)
		{	
			Highlight.highLighterMethod(driver, hotel.nextMonth());
			hotel.nextMonth().click();
			j++;
		}
		Highlight.highLighterMethod(driver, hotel.pickDate());
		//Selecting Checkout date in august
		hotel.pickDate().click();
		logger.log(Status.INFO, "CheckIn Date is clickable");
		logger.log(Status.INFO, "Calendar menu is visible on clicking");
		logger.log(Status.PASS, "19 AUG 2021 is selected as CheckIn Date");
	}
	
	//Selecting a Checkout date in August
	@Test(priority=17, groups="Regression")
	public void enterCheckOutDate()
	{
		hotel = new hotelPage(driver);
		Highlight.highLighterMethod(driver, hotel.returnPickDate());
		hotel.returnPickDate().click();
		logger.log(Status.INFO, "Auto Redirected to select CheckOut Date after entering CheckIn date");
		logger.log(Status.PASS, "22 AUG 2021 is selcted as CheckOut Date");
	}
	
	//Getting Details of adults in one room
	@Test(priority=18, groups="Regression")
	public void enterRooms() throws IOException
	{
		hotel = new hotelPage(driver);
		Highlight.highLighterMethod(driver, hotel.rooms());
		hotel.rooms().click();
		
		//getting the list of adults available to select and storing in a list
		List<WebElement> allOptions= hotel.adults().findElements(By.tagName("li"));
		 for(WebElement selectAdults: allOptions)
		    {
			 	//Displaying the list
		    	String count = selectAdults.getText();
		        System.out.println(count);
		    }
		 
		 //Clicking on Apply 
		 hotel.apply().click();
		
		 //Validating the no of Adults selected in a room
		 Assert.assertEquals(hotel.Guests().getText(), "1 Rooms 2 Guests");
		 
		 ScreenshotManager.screenshot(driver, "HotelAdults");
		 logger.log(Status.INFO, "Room Selection button is clickable");
		 logger.log(Status.INFO, "Room Selection buttom expands on click");
		 logger.log(Status.PASS, "Number of Adults is selected: "+hotel.Guests().getText());
	}
	
	
}
