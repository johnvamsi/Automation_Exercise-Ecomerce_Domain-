package testCases;

import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;
import testBase.CrossBrowser__BaseClass;

public class TC__002__LoginTest extends CrossBrowser__BaseClass{
	@Test
	public void Test___Login() throws InterruptedException
	{
		LoginPage lp= new LoginPage(driver);
		lp.setEmail("TestVamsi123@yopmail.com");
		lp.setPassword("Test@1234");
		lp.clickLogin();
		Thread.sleep(4000);
		boolean bb=lp.getConfirmMsg();
		if(bb==true)
		{
			System.out.println("TestCase is passed");
		}
		else
		{
			System.out.println("TestCase is Failed");
		}
	   lp. clickLogout();
		
	}
	

}
