package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.XLUtils;

public class TC__002__LoginDDT extends BaseClass{
	String Xlpath="C:\\Users\\HP\\Downloads\\TestCases.xlsx";
	@Test(dataProvider="login_data")
	public void Test___Login(String email,String password,String status,String rownum) throws Exception
	{
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLogin();
		Thread.sleep(4000);
		boolean bb=lp.getConfirmMsg();
		if(status.equals("Valid"))
		{
			if(bb==true)
			{
				XLUtils.setCellData(Xlpath, "sheet1", Integer.parseInt(rownum), 4, "Passed");
				lp. clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				XLUtils.setCellData(Xlpath, "sheet1", Integer.parseInt(rownum), 4, "failed");
				CaptureScreen(driver,"LoginDDT");
				Assert.assertTrue(false);
			}
		}
		if(status.equals("INValid"))
		{
			if(bb==true)
			{
				
				XLUtils.setCellData(Xlpath, "sheet1", Integer.parseInt(rownum), 4, "failed");
				CaptureScreen(driver,"LoginDDT");
				lp. clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				XLUtils.setCellData(Xlpath, "sheet1", Integer.parseInt(rownum), 4, "Passed");
				Assert.assertTrue(true);
			}
		}
		 driver.navigate().refresh();
	   
		
	}
	
	@DataProvider(name="login_data")
	public String[][] getData() throws IOException
	{
		String Xlpath="C:\\Users\\HP\\Downloads\\TestCases.xlsx";
		int rowCount=XLUtils.getRowCount(Xlpath, "sheet1");
		int colCount=XLUtils.getCellCount(Xlpath, "sheet1", 1);
		String[][] Login_data= new String[rowCount][colCount];
		for(int r=1;r<=rowCount;r++)
		{
			for(int c=0;c<colCount;c++)
			{
				Login_data[r-1][c]=XLUtils.getCellData(Xlpath, "sheet1", r, c);
			}
		}
		return Login_data;
	}
	

}
