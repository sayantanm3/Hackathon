package testObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import libraries.DriverSetup;
import libraries.Highlight;

public class cabPageSearchResult extends DriverSetup{

	public WebDriver driver; 
	
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'SUV')]")
	 public WebElement SUV;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'(Lowest to Highest)')]")
	 public WebElement filterPrice;
	@FindBy(how = How.XPATH, using = "//div[@class='sortOptionUnit']")
	 public WebElement selectLowToHighFilter;
	@FindBy(how = How.XPATH, using = "//*[@id='List']/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]")
	 public WebElement name1;
	@FindBy(how = How.XPATH, using = "//*[@id='List']/div[1]/div/div[3]/div/div[2]/div/p[1]")
	 public WebElement price1;
	@FindBy(how = How.XPATH, using = "//*[@id='List']/div[4]/div/div[2]/div[1]/div[1]/span[1]")
	 public WebElement name2;
	@FindBy(how = How.XPATH, using = "//*[@id='List']/div[4]/div/div[3]/div/div[2]/div/p[1]")
	 public WebElement price2;
	@FindBy(how = How.XPATH, using = "//*[@id='List']/div[5]/div/div[2]/div[1]/div[1]/span[1]")
	 public WebElement name3;
	@FindBy(how = How.XPATH, using = "//*[@id='List']/div[5]/div/div[3]/div/div[2]/div/p[1]")
	 public WebElement price3;
	
	
	public cabPageSearchResult(WebDriver driver)
	{
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	
	public WebElement selectSUV()
	{
		return SUV;
	}
	
	public WebElement filterPrice()
	{
		return filterPrice;
	}
	
	public WebElement selectLowToHighFilter()
	{
		return selectLowToHighFilter;
	}
	
	public String carInfo()
	{
		String[] carPrice1 = price1.getText().split(" ");
		String carName1 = name1.getText();
		//System.out.println("Car Name: "+carName1+"Type: SUV "+"Price: Rs. "+carPrice1[1]);
		
		String[] carPrice2 = price2.getText().split(" ");
		String carName2 = name2.getText();
		//System.out.println("Car Name: "+carName2+"Type: SUV "+"Price: Rs. "+carPrice2[1]);
		
		String[] carPrice3 = price3.getText().split(" ");
		String carName3 = name3.getText();
		//System.out.println("Car Name: "+carName3+"Type: SUV "+"Price: Rs. "+carPrice3[1]);
		
		return ("\n"+("Car Name: "+carName1+"Type: SUV "+"Price: Rs. "+carPrice1[1])+"\n"+
				"Car Name: "+carName2+"Type: SUV "+"Price: Rs. "+carPrice2[1]+"\n"+
				"Car Name: "+carName3+"Type: SUV "+"Price: Rs. "+carPrice3[1]);
	}
	
	public String lowestPrice()
	{
		String[] carPrice1 = price1.getText().split(" ");
		String carName1 = name1.getText();
		Highlight.highLighterMethod(driver, name1);
		Highlight.highLighterMethod(driver, price1);
		return ("The Lowest Price: "+"\n"+"Car Name: "+carName1+"Type: SUV "+"Price: Rs. "+carPrice1[1]) ;
	}
	
}
