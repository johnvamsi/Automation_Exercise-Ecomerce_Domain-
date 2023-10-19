package testCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AllProductsPage;
import pageObjects.HomePage;
import pageObjects.ProductDetailsPage;
import pageObjects.ProductDetailsPage2;
import testBase.BaseClass;

public class TC__008__AllProdctsandProductDetails  extends BaseClass{
	
	@Test()
	public void Test__allProductsDisplayed()
	{
							HomePage hp = new HomePage(driver);
							hp.clickProducts();
							AllProductsPage ap= new AllProductsPage(driver);
							boolean bb=ap.getProductsText();
							if(bb==true)
							{
								ap.setProduct(ap.firstProduct_viewCart_btn);
								Assert.assertTrue(true);
							}
							else
							{
								Assert.assertTrue(false);
							}
			
	}
	
	@Test(dependsOnMethods= {"Test__allProductsDisplayed"})
	public void Test__ProductDetailsPage()
	{
		ProductDetailsPage pdp= new ProductDetailsPage(driver);
		boolean bb=pdp.isAllProductDetailDisplayed("Blue Top");
//		ProductDetailsPage2 pdp2 = new ProductDetailsPage2(driver);
//		boolean bb=pdp2.isAllProductDetailDisplayed("Blue Top");
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
