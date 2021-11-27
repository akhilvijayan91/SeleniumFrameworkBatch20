package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.fetchPropertiesUtility;

public class HomePage {
	
public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickLeavebutton() throws IOException
	{
		
		driver.findElement(By.xpath(fetchPropertiesUtility.fetchlocatorvalue("leave_button"))).click();
		
	}

}
