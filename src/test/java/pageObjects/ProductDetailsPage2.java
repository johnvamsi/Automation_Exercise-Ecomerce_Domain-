package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage2 extends BasePage{
	public ProductDetailsPage2(WebDriver driver)
	{
			super(driver);
	}
	//pageObjects
	
    
    @FindBy(xpath="//div[@class='product-information']//h2")
    WebElement prodcutName;
    
 
    @FindBy(xpath="//p[normalize-space()='Category: Women > Tops']")
    WebElement category;
    
    @FindBy(xpath="//div[@class='product-informaprodcutNametion']/child::span/span")
    WebElement price;
    
    By price1 =By.xpath("//div[@class='product-informaprodcutNametion']/child::span/span");
    
   
    @FindBy(xpath="//b[normalize-space()='Availability:']")
    WebElement availability;
    
    @FindBy(xpath="//b[text()='Condition:']")
    WebElement condition;

    @FindBy(xpath="//b[normalize-space()='Brand:']")
    WebElement brand;
    		
	
	
	
	//actionMethods
    //productname
       public String getProductName()
       {
			    	   try
			    	   {
						    		   String text=prodcutName.getText();
						    		   return(text);
			    	   }
			    	   catch(Exception e)
			    	   {
			    		   				return(e.getMessage());
			    	   }
    	   		
       }
       
       //category
       public boolean isallProductdetailsDisplayed()
       {
    	   								boolean Boolean=true;
						    	         boolean bb=category.isDisplayed();
						    	         boolean bb1=ExplicitlyWait(price1).isDisplayed();
						    	         boolean bb2=availability.isDisplayed();
						    	         boolean bb3=condition.isDisplayed();
						    	         boolean bb4=brand.isDisplayed();
						    	         if(bb==bb1==bb2==bb3==bb4)
						    	         {
						    	        	 Boolean =true;
						    	         }
						    	         else
						    	         {
						    	        	 Boolean =false;
						    	         }
										return (Boolean);
								
			
    	}
       //price
     
          public boolean isAllProductDetailDisplayed(String pname)
       {
        	  boolean Boolean=true;
    	    String text=getProductName();
    	    if(text.equals(pname))
    	    {
			    	    
			   	         boolean bb=category.isDisplayed();
			   	         boolean bb1=price.isDisplayed();
			   	         boolean bb2=availability.isDisplayed();
			   	         boolean bb3=condition.isDisplayed();
			   	         boolean bb4=brand.isDisplayed();
			   	         if(bb==bb1==bb2==bb3==bb4)
			   	         {
			   	        	 Boolean =true;
			   	         }
		   	         else
		   	         {
		   	        	 Boolean =false;
		   	         }
				return (Boolean);
    	    	   
    	    }
    	    else
    	    {
    	    	System.out.println("Product is Not displayed ");
    	    	Boolean=false;
    	    }
    	    return(Boolean);
    	 
			
       }
	

}
