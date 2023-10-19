package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllProductsPage extends BasePage{
	public AllProductsPage(WebDriver driver)
	{
		    super(driver);
	}
	
	//pageObjects
	@FindBy(xpath="//h2[normalize-space()='All Products']")
	WebElement allProducts_Text;
	
	@FindBy(xpath="//a[contains(text(),'View Product')]")
	List<WebElement>allProductsList;
	
	// firstProduct_viewCart_btn;
	@FindBy(xpath="(//a[contains(text(),'View Product')])[1]")
	public WebElement firstProduct_viewCart_btn;
	
	// secondProduct_viewCart_btn;
	@FindBy(xpath="(//a[contains(text(),'View Product')])[2]")
	public WebElement secondProduct_viewCart_btn;
	
	//searchBox
	@FindBy(id="search_product")
	WebElement search_product;
	
	//searchButton
	@FindBy(id="submit_search")
	WebElement search_btn;
	
	//productText
	@FindBy(xpath="//div[@class='productinfo text-center']/child::p")
	WebElement getProduct_text;
	
	//addtoCart
	@FindBy(xpath="//a[@class='btn btn-default add-to-cart']")
	List<WebElement>allAddtoCarts;
	
	@FindBy(xpath="(//a[@class='btn btn-default add-to-cart'])[1]")
	public 	WebElement addToCart_1stProd;
	
	
	
	//actionMethods
	public boolean getProductsText()
	{
		    try
		    {
		    		return(allProducts_Text.isDisplayed());
		    }
		    catch(Exception e)
		    {
		    	return(false);
		    }
	}
	
	public void setProduct(WebElement ele)
	{
		   for(WebElement product:allProductsList)
		   {
			   				
   				if(product.equals(ele))
   				{
   						JavaScriptClick(product);
   					//	product.click();
   						break;
   				}
		   }
	}
	
	public void setProductName(String product)
	{
		search_product.sendKeys(product);
	}
	public void clickSearchButton()
	{
		search_btn.click();
	}
	
	public String getProductText()
	{
			 try
			 {
				 String text=getProduct_text.getText();
					return(text);
			 }
			 catch(Exception e)
			 {
				 return(e.getMessage());
			 }
		
	}
	
	public boolean isProductDisplayed(String produtName)
	{
	      if(produtName.equals(getProductText()))
		     {
		    	 return(true);
		     }
	      else
	      {
	    	  return(false);
	      }
					   
				  
	}
	
	public void addToCart(WebElement addProdtoCart)
	{
		    for(WebElement addToCart:allAddtoCarts)
		    {
		    	 if(addToCart.equals(addProdtoCart))
		    	 {
		    		 JavaScriptClick(addToCart);
		    		 break;
		    	 }
		    }
	}
	
	
	
	
	
	
	
	
}
