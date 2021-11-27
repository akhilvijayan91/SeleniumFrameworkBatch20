package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class excelUtility {
	
	private static XSSFWorkbook excelworkbook;
	private static XSSFSheet excelsheet;
	private static XSSFRow excelsheetrow;
	private static XSSFCell excelsheetcell;


  public static void setExcelFile(String excelfilepath, String sheetname)
  {
	  try
	  {
	  FileInputStream file = new FileInputStream(excelfilepath);
	  excelworkbook = new XSSFWorkbook(file);
	  excelsheet=excelworkbook.getSheet(sheetname);
	  }
	  catch(Exception e)
	  {
		  System.out.println(e);
	  }
  }
	  
  public static int getTestCaseRowNumber(String testcasename, int columnnumber)
  {
	  int i;
	  try
	  {
		  int rownum = excelsheet.getLastRowNum();
		  
		  for(i=1;i<=rownum;i++)
		  {
			  if(getcelldata(i, columnnumber).equalsIgnoreCase(testcasename))
			  {
				  break;
			  }
		  }
		  return i;
	  }
	  catch(Exception e)
	  {
		  return 0;	
	  }
  }
  
  public static String getcelldata(int rownumber, int columnnumber)
  {
	  String celldata=null;
	  try 
	  {
		  return excelsheet.getRow(rownumber).getCell(columnnumber).getStringCellValue();
	  }
	  catch(Exception e)
	  {
		  System.out.println(e);
		  return "";
	  }	  
  	}
  
  public static Object[][] getTableData(int testCaseRow)
  	{
	  try
	  {
		  int totalrowcount=excelsheet.getLastRowNum();
		  int nextdatarownumber=nextTestCaseRowCount(testCaseRow,totalrowcount);
		  int numberofcolumns=excelsheet.getRow(testCaseRow).getLastCellNum()-1;
		  int numberofrows=nextdatarownumber-testCaseRow;
		  
		  String[][] exceldata=new String[numberofrows][numberofcolumns];
		  int ci=0;
		  
		  while(testCaseRow<nextdatarownumber)
		  {
			  int cj=0;
			  for(int j=1;j<=numberofcolumns;j++,cj++)
			  {
				  exceldata[ci][cj]=getcelldata(testCaseRow, j);
			  }
			  ci++;
			  testCaseRow++;
		  }
		  return exceldata;
	  }
	  catch(Exception e)
	  {
		  System.out.println(e);
		  throw e;
	  }	  
  	}
  
  public static int nextTestCaseRowCount(int testcaserow,int totalrowcount)
  	{
	  int i;
	  try
	  {
		  for(i=testcaserow+1;i<=totalrowcount;i++)
		  {
			  if(getcelldata(i,0)!="")
			  {
				  break;
			  }
		  }
		  return i;
	  }
	  catch(Exception e)
	  {
		  throw e;
	  }	  
  	}
  }

