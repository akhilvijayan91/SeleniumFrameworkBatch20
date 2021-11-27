package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenshotUtilities {
	
		public static String GetScreenshot(WebDriver driver) throws IOException
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			String image = ts.getScreenshotAs(OutputType.BASE64);
			return image;
			/*
			 * File Source = ts.getScreenshotAs(OutputType.FILE); File Destination = new
			 * File("./Screenshots/scn.jpg"); FileUtils.copyFile(Source, Destination);
			 */

		}

}
