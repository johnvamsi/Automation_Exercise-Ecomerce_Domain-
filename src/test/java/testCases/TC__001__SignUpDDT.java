package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.SignupPage;
import testBase.BaseClass;
import testBase.CrossBrowser__BaseClass;
import utilities.XLUtils;

public class TC__001__SignUpDDT extends BaseClass{
	String xlpath="C:\\Users\\HP\\Documents\\InsuranceTestData.xlsx";
	@Test(dataProvider="Signup_Regression_data")
	public void Test__Signup(String name,String email,String status,String rownum)
	{
		
		try 
		{
			SignupPage sp= new SignupPage(driver);
			sp.clickSignupButton();
			sp.setName(name);
			sp.setEmail(email);
			sp.clickSignup();
			boolean bb=sp.getConfirmMsg();
			if(status.equals("Valid"))
			{
					if(bb==true)
					{
						XLUtils.setCellData(xlpath, "sheet1", Integer.parseInt(rownum), 4, "TestPassed");
						Assert.assertTrue(true);
					}
					else
					{
						CaptureScreen(driver,"LoginTest");
						XLUtils.setCellData(xlpath, "sheet1", Integer.parseInt(rownum), 4, "TestFailed");
						Assert.assertTrue(false);
					}
			}
			
			
			if(status.equals("InValid"))
			{
					if(bb==true)
					{
						CaptureScreen(driver,"LoginTest");
						XLUtils.setCellData(xlpath, "sheet1", Integer.parseInt(rownum), 4, "TestFailed");
						Assert.assertTrue(false);
					}
					else
					{
						XLUtils.setCellData(xlpath, "sheet1", Integer.parseInt(rownum), 4, "TestPassed");
						Assert.assertTrue(true);
					}
			}
			
		}
		
     catch(Exception e)
		{
			Assert.fail();
		}
		
	}
	
	@DataProvider(name="Signup_Regression_data")
	public String[][] getData() throws IOException
	{
		
		int rowCount=XLUtils.getRowCount(xlpath, "Sheet1");
		int colCount=XLUtils.getCellCount(xlpath, "Sheet1", 1);
		String[][] signUp_data=new String[rowCount][colCount];
		
		
		for(int r=1;r<=rowCount;r++)
		{
			 for(int c=0;c<colCount;c++)
			 {
				 signUp_data[r-1][c]=XLUtils.getCellData(xlpath, "Sheet1", r, c);
			 }
		}
		
		return signUp_data;
		
	}

}
