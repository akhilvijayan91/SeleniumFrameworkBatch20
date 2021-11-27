package utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentUtilities {
	
	public WebDriver driver;
	public static ExtentReports reports;
	public static ExtentTest logger;
	
	public static void createExtentInstance(String classname)
	{
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss_SSS");
		Date now = new Date();
		String timeStamp = sdf.format(now);
		  
		ExtentSparkReporter reporter = new ExtentSparkReporter("./Extent_Reports/" + classname + timeStamp + "report.html");
		
		
		 // ExtentSparkReporter reporter = new ExtentSparkReporter("./Extent_Reports/report1.html");
		 
		
		reporter.config().setDocumentTitle("ExtentReportDocument");
		reporter.config().setReportName("ExtendReportName");
		
		reports = new ExtentReports();
		reports.setSystemInfo("OS", "Windows");
		reports.setSystemInfo("Env", "QA");
		reports.setSystemInfo("Reporter", "Gokul");
		
		reports.attachReporter(reporter);	
		
		logger = reports.createTest(classname); 
	}
	
	public static void writeExtentReport(ITestResult result,WebDriver driver) throws IOException
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
		logger.log(Status.PASS,MarkupHelper.createLabel("URL Matching", ExtentColor.GREEN));
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
		logger.log(Status.SKIP,MarkupHelper.createLabel("URL Matching", ExtentColor.ORANGE));
		}
		else
		{
		logger.log(Status.FAIL, MarkupHelper.createLabel("URL Mismatch", ExtentColor.RED));
		logger.fail("URL Mismatch",MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotUtilities.GetScreenshot(driver)).build());
		}
		reports.flush();
	}
}
