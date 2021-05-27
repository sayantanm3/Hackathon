package testObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import libraries.DriverSetup;

public class giftCard extends DriverSetup{

	public WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Gift Vouchers')]")
	 public WebElement giftCardHome;
	@FindBy(how = How.XPATH, using = "//header/div[1]/div[1]/ul[1]/li[5]/a[1]")
	 public WebElement groupGifting;
	
	
	public giftCard(WebDriver driver)
	{
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	
	public WebElement giftCardHome()
	{
		return giftCardHome;
	}
	
	public WebElement groupGifting()
	{
		return groupGifting;
	}
	
	
	
	
}
