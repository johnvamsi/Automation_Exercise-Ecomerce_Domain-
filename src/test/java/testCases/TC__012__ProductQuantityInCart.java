package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ProductQuantityPage;
import testBase.BaseClass;

public class TC__012__ProductQuantityInCart  extends BaseClass{
	int productQuantity=5;
	@Test
	public void Test___ProductQuantity()
	{
		ProductQuantityPage pq= new ProductQuantityPage(driver);
		pq.clickProductsPage();
		pq.clickViewProduct();
		//pq.increaseQuantitySize(3);
		pq.setProductQuantity(productQuantity);
		pq.clickAddToCart();
		pq.clickViewCart();
		int qunatity=pq.getProductQuantity();
		
			if(qunatity==productQuantity)
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
	}

}
