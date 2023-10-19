package testCases;

import org.testng.annotations.Test;

import pageObjects.AllProductsPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC__011__AddToCart  extends BaseClass{
	
	@Test
	public void Test__AddToCart() throws Exception
	{
		HomePage hp = new HomePage(driver);
		hp.clickProducts();
		AllProductsPage ap= new AllProductsPage(driver);
		ap.setProduct(ap.firstProduct_viewCart_btn);
		ap.addToCart(ap.addToCart_1stProd);
		//driver.wait();
		Thread.sleep(10000);
		System.out.println("TestCase is executed");
	}

}
