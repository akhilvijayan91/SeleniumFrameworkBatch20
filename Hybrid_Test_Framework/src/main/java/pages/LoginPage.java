package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import utilities.extentUtilities;
import utilities.fetchPropertiesUtility;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void enterUsername(String username) throws IOException
	{
		extentUtilities.logger.log(Status.INFO, "Entering Username:");
		driver.findElement(By.xpath(fetchPropertiesUtility.fetchlocatorvalue("username_field"))).sendKeys(username);
		
	}
	
	public void enterPassword(String password) throws IOException
	{
		
		driver.findElement(By.xpath(fetchPropertiesUtility.fetchlocatorvalue("password_field"))).sendKeys(password);
		
	}
	
	public void clickSigninbutton() throws IOException
	{
		
		driver.findElement(By.xpath(fetchPropertiesUtility.fetchlocatorvalue("signin_button"))).click();
		
	}

	public void clickWelcomebutton() throws IOException
	{
		
		driver.findElement(By.xpath(fetchPropertiesUtility.fetchlocatorvalue("Welcome_button"))).click();
		
	}
	
	public void Logout() throws IOException
	{
		
		driver.findElement(By.xpath(fetchPropertiesUtility.fetchlocatorvalue("Logout_click"))).click();
		
	}
}
