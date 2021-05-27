package testScenarios;

import java.io.IOException;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import libraries.ExcelData;
import libraries.Highlight;
import libraries.ScreenshotManager;
import testObjectRepository.cabPageSearchResult;

public class TS4_searchResultCabs extends Main{
	
public cabPageSearchResult res;
public static ExtentTest logger;
ExcelData ex = new ExcelData();
	
	@BeforeTest
	public void initiateCabs() {
		res = new cabPageSearchResult(driver);
	}
	
	//Filtering car type as SUV only
	@Test(priority=9, groups="Regression")
	public void selectCarType() throws InterruptedException
	{
		res = new cabPageSearchResult(driver);
		Highlight.highLighterMethod(driver, res.selectSUV());
		//Clicking on SUV checkbox to filter search results
		res.selectSUV().click();
		Reporter.log("SUV is selected");
		logger= report.createTest("Cab Booking Search Results");
		logger.log(Status.INFO, "SUV option is visible");
		logger.log(Status.PASS, "SUV is selected");
	}
	
	//Filtering Price
	@Test(priority=10, groups="Regression")
	public void filterPrice() throws InterruptedException
	{
		Highlight.highLighterMethod(driver, res.filterPrice());
		//Clicking filter Price to select a filter
		res.filterPrice().click();
		Highlight.highLighterMethod(driver, res.selectLowToHighFilter());
		//Selecting Low to High filter from dropdown
		res.selectLowToHighFilter().click();
		Reporter.log("Filter is set to show Price Low to High");
		logger.log(Status.INFO, "Filter option is visible");
		logger.log(Status.PASS, "Price Low to High is selected");
	}
	
	//Displaying top 3 available Cabs
	@Test(priority=11, groups="Regression")
	public void displayAvailableCars() throws IOException
	{
		System.out.println(res.carInfo());
		Reporter.log(res.carInfo());
		logger.log(Status.INFO, res.carInfo());
		
		ex.WriteData(1, 1,res.carInfo());
		
	}
	
	//Displaying the cab details with the lowest price
	@Test(priority=12, groups="Regression")
	public void displayLowestPrice() throws IOException, InterruptedException
	{
		System.out.println(res.lowestPrice());
		Reporter.log(res.lowestPrice());
		ex.WriteData(5,3,res.lowestPrice());
		logger.log(Status.PASS, res.lowestPrice());
		ScreenshotManager.screenshot(driver, "cabSearchResults");
		Thread.sleep(2000);
	}
	
	
}
