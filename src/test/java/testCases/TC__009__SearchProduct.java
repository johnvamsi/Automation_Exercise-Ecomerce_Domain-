package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AllProductsPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC__009__SearchProduct   extends BaseClass{
	
	@Test
	public void Test__SearchProduct()
	{
		try
		{
				HomePage  hp = new HomePage(driver);
				hp.clickProducts();
				AllProductsPage ap= new AllProductsPage(driver);
				ap.setProductName("Men Tshirt");
				ap.clickSearchButton();
				boolean Boolean =ap.isProductDisplayed("Men Tshirt");
						if(Boolean==true)
						{
							System.out.println("TestCase got Passed");
							Assert.assertTrue(true);
						}
						else
						{
							System.out.println("TestCase got Failed");
							Assert.assertTrue(false);
						}
		}
		catch(Exception e )
		{
			System.out.println(e.getMessage());
			Assert.fail();
		}
		
	}

}
