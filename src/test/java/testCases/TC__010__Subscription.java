package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC__010__Subscription extends BaseClass {
	
	
		@Test
		public void Test__Subscription()
		{
			try
			{
				HomePage  hp = new HomePage(driver);
				hp.setSubscriptionMail(randomAlphabets(15)+"@gmail.com");
				hp.clickSubscribe();
				boolean b =hp.getSubscriptionSucessMessage();
						if(b==true)
						{
									Assert.assertTrue(true);
						}
						else
						{
									Assert.assertTrue(false);
						}
			}
			catch(Exception e)
			{
				Assert.fail();
			}
			
		}

}
