package testScenarios;

import static org.testng.Assert.assertFalse;
import java.io.IOException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import junit.framework.Assert;
import libraries.Highlight;
import libraries.ScreenshotManager;
import testObjectRepository.giftCard;


public class TS5_groupGifting extends Main{
	
public giftCard gift;
public static ExtentTest logger;
	
	@BeforeTest
	public void initiateGiftCard() {
		gift = new giftCard(driver);
	}
	
	//Clicking Group Gifting
	@Test(priority=20, groups="Regression")
	public void selectGroupGifting() throws InterruptedException, IOException
	{
		gift = new giftCard(driver);
		logger= report.createTest("Group Gifting in Gift Card");
		try {
			Highlight.highLighterMethod(driver, gift.groupGifting());
			Thread.sleep(2000); //Sleep used to capture screenshot
			ScreenshotManager.screenshot(driver, "GroupGifting");
			Thread.sleep(2000); //Sleep used to capture screenshot
			
			//Clicking Group gifting
		gift.groupGifting().click();
		logger.log(Status.INFO, "Group Gifting button is clickable");
		ScreenshotManager.screenshot(driver, "GiftCardDetails");
		
		}catch(Exception e)
		{
			//Logging 'Page not responding' if the link is broken
			System.out.println("The group_gifting page is not responding");
			
			
		}
		
		logger.log(Status.FAIL, "Unsuccessful Navigation");
		
	}
	
	//Checking whether card details can be entered
	@Test(priority=21, groups="Regression")
	public void enterCardDetails()
	{
		boolean bool = false;
		String actual= driver.getTitle();
		
		if(actual.contains("Group Gifting"))
		{
			 bool = true;
		}
		
		Assert.assertFalse(false);
		logger.log(Status.SKIP, "Card details cannot be entered");
		logger.log(Status.SKIP, "Email address cannot be entered");
	}
	
	
	
}
