package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductQuantityPage extends BasePage{
	
	public ProductQuantityPage(WebDriver driver)
	{
		super(driver);
	}
    
	
	//pageObjects
	@FindBy(xpath="(//a[@href='/products'])[1]")
	WebElement products_page;

    @FindBy(linkText="View Product")
    WebElement viewProduct_btn;
    
    @FindBy(id="quantity")
    WebElement quantityIncrease_btn;
    
    @FindBy(xpath="//button[@type='button']")
    WebElement addtoProduct_btn;
    
    @FindBy(xpath="//u[text()='View Cart']")
    WebElement viewCart_btn;
    
    @FindBy(xpath="//tr[1]//td[@class='cart_quantity']/child::button")
    WebElement productQuantity;
	
	
	
	//actionMethods
	public void clickProductsPage() 
	{
		
		products_page.click();
	}
	
	public void clickViewProduct()
	{
		viewProduct_btn.click();
	}
//	public void increaseQuantitySize(int num)
//	{
//		for(int i=0;i<num;i++)
//		{
//			quantityIncrease_btn.click();
//		}
//	}
	
	public void setProductQuantity(int value)
	{
		quantityIncrease_btn.clear();
		quantityIncrease_btn.sendKeys(String.valueOf(value));
	}
	public void clickAddToCart()
	{
		addtoProduct_btn.click();;
	}
	public void clickViewCart()
	{
		viewCart_btn.click();
	}
	
	public int getProductQuantity()
	{
		String num=productQuantity.getText();
		int productQuantity=Integer.parseInt(num);
		return(productQuantity);
	}
	
	
	
	
	
	
	
	
}

