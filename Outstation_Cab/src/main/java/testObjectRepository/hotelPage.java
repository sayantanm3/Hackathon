package testObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import libraries.DriverSetup;

public class hotelPage extends DriverSetup{

	public WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//a[@class='chMmtLogo']")
	 public WebElement Home;
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[1]/div/div/div/nav/ul/li[2]/a")
	 public WebElement hotelHome;
	@FindBy(how = How.XPATH, using = "//div[@class='hsw_inputBox selectHtlCity  ']")
	 public WebElement city;
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter city/ Hotel/ Area/ Building']")
	 public WebElement enterCity;
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Manali, Himachal Pradesh, India')]")
	 public WebElement selectFromList;
	@FindBy(how = How.XPATH, using = "//div[@class='hsw_inputBox dates inactiveWidget activeWidget']")
	 public WebElement checkIn;
	@FindBy(how = How.XPATH, using = "//span[@aria-label='Next Month']")
	 public WebElement calendarNextMonth;
	@FindBy(how = How.XPATH, using = "//div[@aria-label='Thu Aug 19 2021']")
	 public WebElement pickDate;
	@FindBy(how = How.XPATH, using = "//div[@aria-label='Sun Aug 22 2021']")
	 public WebElement returnPickDate;
	@FindBy(how = How.XPATH, using = "//div[@class='hsw_inputBox roomGuests  ']")
	 public WebElement rooms;
	@FindBy(how = How.XPATH, using = "//ul[@class='guestCounter font12 darkText']")
	 public WebElement adults;
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'APPLY')]")
	 public WebElement apply;
	@FindBy(how = How.XPATH, using = "//span[@class='appendRight10']")
	 public WebElement guests;
	
	
	public hotelPage(WebDriver driver)
	{
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	
	public  void homePage()
	{
		Home.click();
	}
	
	public WebElement hotelTab()
	{
		return hotelHome;
	}
	
	public WebElement city()
	{
		return city;
	}
	
	public WebElement enterCity()
	{
		return enterCity;
	}
	
	public WebElement selectFromList()
	{
		return selectFromList;
	}
	
	public void checkIn()
	{
		checkIn.click();
	}
	
	public WebElement nextMonth()
	{
		return calendarNextMonth;
	}
	
	public WebElement pickDate()
	{
		return pickDate;
	}
	
	public WebElement returnPickDate()
	{
		return returnPickDate;
	}
	
	public WebElement rooms()
	{
		return rooms;
	}
	
	public WebElement adults()
	{
		return adults;
	}
	
	public WebElement apply()
	{
		return apply;
	}
	
	public WebElement Guests()
	{
		return guests;
	}
}
