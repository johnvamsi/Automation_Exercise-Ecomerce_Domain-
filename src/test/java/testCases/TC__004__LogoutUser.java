package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC__004__LogoutUser extends BaseClass{
		@Test
	   public void Test__Logout()
	   {
		   LoginPage lp = new LoginPage(driver);
		 
		   lp.setEmail(rb.getString("email"));
		   lp.setPassword(rb.getString("password"));
		   lp.clickLogin();
		     HomePage hp = new HomePage(driver);
		    String name= hp.getUserName();
		     if(name.equals("vamsi"))
		     {
		    	 Assert.assertTrue(true);
		     }
		     else
		     {
		    	 Assert.assertTrue(false);
		     }
		   lp.clickLogout();
	   }
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
