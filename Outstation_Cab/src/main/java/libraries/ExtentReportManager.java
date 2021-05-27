package libraries;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;


public class ExtentReportManager {
	public static ExtentReports report;
	
	public static ExtentReports getReportInstance(){
		
		if(report == null){
			String reportName = "Cab_Booking.html";
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "//Extent Report//" + reportName);
			report =  new ExtentReports();
			report.attachReporter(htmlReporter);
			
			report.setSystemInfo("OS", "Windows 10");
			report.setSystemInfo("Environment", "UAT");
			report.setSystemInfo("Build Number", "10.8.1");
			report.setSystemInfo("Browser", "Chrome");
			
			htmlReporter.config().setDocumentTitle("Make My Trip Automation Results");
			htmlReporter.config().setReportName("Cab Booking Automation");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
		}
		
		return report;
	}

}
