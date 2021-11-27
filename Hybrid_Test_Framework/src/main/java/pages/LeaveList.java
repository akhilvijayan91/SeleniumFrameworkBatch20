package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonMethods.CommonMethods;
import utilities.fetchPropertiesUtility;

public class LeaveList {
	
public WebDriver driver;
	
	public LeaveList(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickFromDate() throws IOException
	{
		
		driver.findElement(By.xpath(fetchPropertiesUtility.fetchlocatorvalue("FromDate_field"))).click();	
	}
	
	public WebElement Month() throws IOException
	{
		return driver.findElement(By.xpath(fetchPropertiesUtility.fetchlocatorvalue("CalendarMonth_field")));
	}
	
	public void selectMonth() throws IOException
	{
		CommonMethods cm=new CommonMethods();
		cm.selectDropDownValue(Month(), "Dec");
	}
	
	public WebElement Year() throws IOException
	{
		return driver.findElement(By.xpath(fetchPropertiesUtility.fetchlocatorvalue("CalendarYear_field")));
	}

	public void selectYear() throws IOException
	{
		CommonMethods cm=new CommonMethods();
		cm.selectDropDownValue(Year(), "2018");
	}
	
	public List<WebElement> returnFromDateElements() throws IOException
	{
		return driver.findElements(By.xpath(fetchPropertiesUtility.fetchlocatorvalue("CalendarDate_label"))); 
	}
	
	public void selectValueFromDate() throws IOException
	{
		CommonMethods cm=new CommonMethods();
		cm.clickElementFromWebTable(returnFromDateElements(), "25");
	}
}
