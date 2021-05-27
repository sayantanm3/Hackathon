package testScenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import libraries.Highlight;
import testObjectRepository.giftCard;


public class TS2_navigateToGiftCards extends Main{
	
public giftCard gift;
public static ExtentTest logger;
	
	@BeforeTest
	public void initiateGiftCard() {
		gift = new giftCard(driver);
	}
	
	@Test(priority=19, groups="Smoke")
	public void navigateToGiftCard() throws InterruptedException
	{
		gift = new giftCard(driver);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scroll(0,1800)");
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(gift.giftCardHome()));
		
		 try {
			 Highlight.highLighterMethod(driver, gift.giftCardHome());
			 gift.giftCardHome().click();
	         } catch (Exception e) {
	            JavascriptExecutor executor = (JavascriptExecutor) driver;
	            executor.executeScript("arguments[0].click();", gift.giftCardHome());
	         }
		logger= report.createTest("Navigate to GiftCard Section");
		String title = driver.getTitle();
		if(title.contains("Gift"))
		logger.log(Status.PASS, "Navigated to Gift Card section");
		else
		logger.log(Status.FAIL, "Unsuccessful Navigation");
	}
	
	
	
}
