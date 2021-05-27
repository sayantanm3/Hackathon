package testObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import libraries.DriverSetup;

public class cabPage extends DriverSetup{

	public WebDriver driver; 
	
	@FindBy(how = How.XPATH, using = "//*[@id='SW']/div[1]/div[2]/div/div/nav/ul/li[8]/a")
	 public WebElement cabHome;
	@FindBy(how = How.XPATH, using = "//*[@id='root']/div/div[2]/div/div/div[1]/ul/li[1]/span")
	 public WebElement radio;
	@FindBy(how = How.XPATH, using = "//input[@id='fromCity']")
	 public WebElement fromCity;
	@FindBy(how = How.XPATH, using = "//*[@id='root']/div/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div/div/input")
	 public WebElement fromCityText;
	@FindBy(how = How.XPATH, using = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]")
	 public WebElement toCity;
	@FindBy(how = How.XPATH, using = "//*[@id='root']/div/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/div/div/div/input")
	 public WebElement toCityText2;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Delhi, India')]")
	 public WebElement selectFromList;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Manali, Himachal Pradesh, India')]")
	 public WebElement selectFromList2;
	@FindBy(how = How.XPATH, using = "//*[@id='root']/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div/input")
	 public WebElement toCityText;
	@FindBy(how = How.XPATH, using = "//span[@class='lbl_input latoBold appendBottom10']")
	 public WebElement fromDate;
	@FindBy(how = How.XPATH, using = "//*[@id='root']/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[3]/div[5]")
	 public WebElement fromDatePicker;
	@FindBy(how = How.XPATH, using = "//*[@id='root']/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[2]")
	 public WebElement calendarRightArrow;
	@FindBy(how = How.XPATH, using = "//*[@id='root']/div/div[2]/div/div/div[2]/div[1]/div[5]")
	 public WebElement pickupTime;
	@FindBy(how = How.XPATH, using = "//*[@id='root']/div/div[2]/div/div/div[2]/div[1]/div[5]/ul/li[21]")
	 public WebElement pickupTimeList;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Search')]")
	 public WebElement search;
	@FindBy(how = How.XPATH, using = "//*[@id='SW']/div[1]/div[1]/ul/li[5]/div[2]")
	 public WebElement pop;
	
	
	public cabPage(WebDriver driver)
	{
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	
	public WebElement cabTab()
	{
		return cabHome;
	}
	
	public WebElement radioButton()
	{
		return radio;
	}
	
	public WebElement fromCity()
	{
		return fromCity;
	}
	
	public WebElement fromCityText()
	{
		return fromCityText;
	}
	
	public WebElement toCity()
	{
		return toCity;
	}
	
	public WebElement toCityText()
	{
		return toCityText;
	}
	
	public WebElement toCityText2()
	{
		return toCityText2;
	}
	
	public WebElement selectfromList()
	{
		return selectFromList;
	}
	
	public WebElement selectFromList2()
	{
		return selectFromList2;
	}
	
	public WebElement fromDate()
	{
		return fromDate;
	}
	
	public WebElement fromDatePicker()
	{
		return fromDatePicker;
	}
	
	public WebElement calendarRightArrow()
	{
		return calendarRightArrow;
	}
	
	public WebElement pickupTime()
	{
		return pickupTime;
	}
	
	public WebElement pickUpTimeList()
	{
		return pickupTimeList;
	}
	
	public WebElement search()
	{
		return search;
	}
	
	public void dealWithPopups()
	{

		if(pop.isDisplayed())
		{
			pop.click();
			System.out.println("Popup occured");
		}
		else 
		{
			System.out.println("No Popup");
		}
	}
	
}
