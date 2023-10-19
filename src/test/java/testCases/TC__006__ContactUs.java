package testCases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ContactUsPage;
import testBase.BaseClass;

public class TC__006__ContactUs  extends BaseClass{
	
	@Test
	public void Test__ContactUs() throws Exception
	{
		logger.info("Starting testExecution");
		try
		{
			ContactUsPage cp= new ContactUsPage(driver);
			cp.clickContact();
			logger.info("Clicked on Contact");
			
			cp.setName("Vamsi");
			logger.info("Entered Name");
			
			cp.setEmail("Testvamsi@yopmail.com");
			logger.info("Email is Entered");
			
			cp.setSubject("TestAutomation");
			logger.info("Subject is entered");
			
			cp.setMessage("WelCome to Automation Testing");
			logger.info("Message is entered");
			
			cp.uploadFile("C:\\Users\\HP\\Documents\\ManualTesting_Questions.docx");
			logger.info("File is Uploaded");
			Thread.sleep(4000);
			
		
			cp.clickSubmit();
			logger.info("Clicked on submit");
			
			cp.closeAlert();
			logger.info("Alert is closed");
			
			String confirmMsg =cp.getConfirmMsg();
			logger.info("Retreiving  confirmMsg");
			
			if(confirmMsg.equals("Success! Your details have been submitted successfully."))
			{
				logger.info("Got sucess Message");
				Assert.assertTrue(true);
				System.out.println("TestCase got Passed");
			}
			else
			{
				logger.info("not Got sucess Message");
				System.out.println("TestCase got Failed");
				Assert.assertTrue(false);
			}
		}
		catch(Exception e)
		{
			logger.info("Exception is Thrown");
			Assert.fail();
		}
		logger.info("Finished testExecution");
		
	}

}
