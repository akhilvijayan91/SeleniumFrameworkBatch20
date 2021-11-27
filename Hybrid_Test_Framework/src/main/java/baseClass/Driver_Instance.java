package baseClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.extentUtilities;
import utilities.fetchPropertiesUtility;

public class Driver_Instance {

	public WebDriver driver;
	
	public static String browsername=null;
	
	@BeforeClass
	public void initiateDriverInstance() throws IOException
	
	{
		browsername=fetchPropertiesUtility.fetchproperty("browsername");
		switch(browsername) 
		{
			case "chrome":
				WebDriverManager.chromedriver().setup();				
				driver = new ChromeDriver();
				break;
				
			case "firefox":
				WebDriverManager.firefoxdriver().setup();				
				driver = new FirefoxDriver();
				break;
				
			case "IE":
				WebDriverManager.iedriver().setup();				
				driver = new InternetExplorerDriver();
				break;
				
			case "edge":
				WebDriverManager.edgedriver().setup();				
				driver = new EdgeDriver();
				break;
				
			default:
				WebDriverManager.chromedriver().setup();				
				driver = new ChromeDriver();	
				break;
		}
		String classname = this.getClass().getSimpleName();
		
		driver.get(fetchPropertiesUtility.fetchproperty("URL"));
		utilities.extentUtilities.createExtentInstance(classname);
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void closeDriverInstance(ITestResult result) throws IOException
	
	{
		extentUtilities.writeExtentReport(result, driver);
		driver.quit();
	}
}
