package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.SignupPage;
import testBase.BaseClass;

public class TC__005__RegisterUserWithExistingEmail  extends BaseClass {
	
	
		@Test
		public void Test__RegisterUserWithExistingEmail()
		{
			SignupPage signuppage = new SignupPage(driver);
			signuppage.clickSignup();
			signuppage.setName(rb.getString("name"));
			signuppage.setEmail(rb.getString("email"));
			signuppage.clickSignupButton();
			boolean bb =	signuppage.getErrorMsg();
			if(bb==true)
			{
				 Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
			  
			  
			  
			  
			  
			  
			  
			  
		}
		
		
		

}
