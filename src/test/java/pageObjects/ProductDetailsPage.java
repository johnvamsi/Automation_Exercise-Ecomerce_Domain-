package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage{
	public ProductDetailsPage(WebDriver driver)
	{
			super(driver);
	}
	//pageObjects
	
    By prodcutName= By.xpath("//div[@class='product-information']//h2");
    By category= By.xpath("//p[normalize-space()='Category: Women > Tops']");
    By price =By.xpath("//div[@class='product-information']/child::span/span");
    By availability =By.xpath("//b[normalize-space()='Availability:']");
    By condition = By.xpath("//b[text()='Condition:']");
    By brand = By.xpath("//b[normalize-space()='Brand:']");
    		
	
	
	
	//actionMethods
    //productname
       public String getProductName()
       {
			    	   try
			    	   {
						    		   String text=driver.findElement(prodcutName).getText();
						    		   return(text);
			    	   }
			    	   catch(Exception e)
			    	   {
			    		   				return(e.getMessage());
			    	   }
    	   		
       }
       
       //category
       public boolean isCategoryDisplayed()
       {
    	    	boolean Boolean=driver.findElement(category).isDisplayed();
    	    				if(Boolean)
			    	    	{
			    	    					return(true);
			    	    	}
			    	    	else
			    	    	{
			    	    					return(false);
			    	    	}
			
    	    }
       //price
       public boolean isPriceDisplayed()
       {
    	    	boolean Boolean=driver.findElement(price).isDisplayed();
			    	    	if(Boolean)
			    	    	{
			    	    					return(true);
			    	    	}
			    	    	else
			    	    	{
			    	    					return(false);
			    	    	}
    	    }
       //Availability
       public boolean isAvailabilityDisplayed()
       {
    	    	boolean Boolean=driver.findElement(availability).isDisplayed();
			    	    	if(Boolean)
			    	    	{
			    	    					return(true);
			    	    	}
			    	    	else
			    	    	{
			    	    					return(false);
			    	    	}
    	    }
       
       public boolean isConditionDisplayed()
       {
    	    	boolean Boolean=driver.findElement(condition).isDisplayed();
			    	    	if(Boolean)
			    	    	{
			    	    					return(true);
			    	    	}
			    	    	else
			    	    	{
			    	    					return(false);
			    	    	}
    	    }
       public boolean isBrandDisplayed()
       {
    	    	boolean Boolean=driver.findElement(brand).isDisplayed();
			    	    	if(Boolean)
			    	    	{
			    	    					return(true);
			    	    	}
			    	    	else
			    	    	{
			    	    					return(false);
			    	    	}
    	    }
       
       public boolean isAllProductsDisplayed(By xpath)
       {
    	    	boolean Boolean=driver.findElement(xpath).isDisplayed();
			    	    	if(Boolean)
			    	    	{
			    	    					return(true);
			    	    	}
			    	    	else
			    	    	{
			    	    					return(false);
			    	    	}
    	    }
       
       
          public boolean isAllProductDetailDisplayed(String pname)
       {
        	  boolean bb=true;
    	    String text=getProductName();
    	    if(text.equals(pname))
    	    {
		    	    	     if(isCategoryDisplayed() && isPriceDisplayed()  &&  isAvailabilityDisplayed() &&  isConditionDisplayed() &&isBrandDisplayed())
		    	    	     {
		    	    	    	 bb=true;
		    	    	     }
		    	    	     else
		    	    	     {
		    	    	    	 bb=false;
		    	    	     }
    	    	   
    	    }
    	    else
    	    {
    	    	System.out.println("Product is Not displayed ");
    	    	bb=false;
    	    }
    	    return(bb);
    	 
			
       }
	

}
