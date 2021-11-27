package testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseClass.Driver_Instance;
import commonMethods.CommonMethods;
import pages.LoginPage;
import utilities.excelUtility;

public class TC1_LoginValidation extends Driver_Instance {
  @Test(dataProvider="authentication")
  public void Login(String username, String password) throws IOException, InterruptedException 
  {
	  LoginPage lp=new LoginPage(driver);
	  lp.enterUsername(username);
	  lp.enterPassword(password);
	  lp.clickSigninbutton();
	  
	  CommonMethods cm=new CommonMethods();
	  cm.verifyurl(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/dashboard");
	  Thread.sleep(5000);
	  lp.clickWelcomebutton();
	  lp.Logout();
	  
  }
  
  @DataProvider(name="authentication")
  public static Object[][] LoginCredential() throws IOException
		  {
	  			utilities.excelUtility.setExcelFile("./src/test/resources/Test_Data/TestData.xlsx","TestData");
	  			String testCaseName="TC1_LoginValidation";
	  			int testCaseRow=excelUtility.getTestCaseRowNumber(testCaseName, 0);
	  			
	  			Object[][] exceldata=excelUtility.getTableData(testCaseRow);
	  			return exceldata;
		  }
}
