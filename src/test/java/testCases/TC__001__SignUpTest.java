package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SignupPage;
import testBase.BaseClass;
import testBase.CrossBrowser__BaseClass;

public class TC__001__SignUpTest extends BaseClass{
	
	@Test
	public void Test__Signup()
	{
		logger.info("TestCase is started");
				try 
				{
								SignupPage sp= new SignupPage(driver);
								sp.clickSignupButton();
								logger.info("Clicking on signup button");
								
								//sp.setName(rb.getString("name"));
								sp.setName("VamsiFluentWait");
								logger.info("Entered name");
								
								sp.setEmail(rb.getString("email"));
								logger.info("Entered email id");
								
								sp.clickSignup();
								logger.info("Clicked on signup");
								
								boolean bb=sp.getConfirmMsg();
								logger.info("Getting confirmation msg");
											if(bb==true)
											{
														logger.info("Title is true");
														System.out.println("TestCase passed");
														Assert.assertTrue(true);
											}
											else
											{
														logger.info("Title is false");
														System.out.println("TestCase failed");
														Assert.assertTrue(false);
											}
				}
				
		     catch(Exception e)
				{
					Assert.fail();
				}
		logger.info("TestCase is Ended");
	}

}
