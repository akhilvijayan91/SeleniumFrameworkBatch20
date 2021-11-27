package commonMethods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CommonMethods {
	
	public void verifyurl(String ActualURL, String ExpectedURL)
	{
		Assert.assertEquals(ActualURL, ExpectedURL);
	}
	
	public void selectDropDownValue(WebElement ele, String value)
	{
		Select sle=new Select(ele);
		sle.selectByVisibleText(value);
	}
	
	public void clickElementFromWebTable(List<WebElement> ls, String value)
	{
		for(WebElement we:ls)
		{
			String date=we.getText();
			if(date.equalsIgnoreCase(value))
			{
				we.click();
				break;
			}
		}
	}

}
