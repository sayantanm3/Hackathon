package libraries;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotManager{
	
	public static void screenshot(WebDriver driver, String name) throws IOException{ 
		String filepath = "C:\\Users\\mitra\\eclipse-workspace\\Cab_Booking\\Screenshots\\";
		//creating src file instance for storing the screenshot using TakesScreenshot interface
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  
		File dest = new File(filepath + name + ".png");
		FileUtils.copyFile(src, dest);
	}
	
}
