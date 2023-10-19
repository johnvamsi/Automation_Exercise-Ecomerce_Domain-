package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC__007__TestCases  extends BaseClass{
	
	@Test
	public void Test__TestCases() throws Exception
	{
		HomePage hp = new HomePage(driver);
		hp.clickTestCase();
		boolean text=hp.getTestCaseText();
				if(text==true)
				{
							Assert.assertTrue(true);
				}
				else
				{
					captureScreen("TestCasePage");
					Assert.assertTrue(false);
				}
	}

}
