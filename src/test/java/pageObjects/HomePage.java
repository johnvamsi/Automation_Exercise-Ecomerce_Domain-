package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	public HomePage(WebDriver driver)
	{
				super(driver);
	}
	
	//pageObjects
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement logout_btn;
	
	@FindBy(xpath="//b[normalize-space()='vamsi']")
	WebElement getLoggedInName;
	
	@FindBy(xpath="//ul[@class='nav navbar-nav']/child::li[5]/child::a")
	WebElement TestCase_btn;
	
	@FindBy(xpath="//h2[@class='title text-center']/b")
	WebElement TestCase_Text_ele;
	
	//products 
	@FindBy(xpath="//ul[@class='nav navbar-nav']/child::li[2]/a")
	WebElement products_btn;
	
	//subscriptionEmail
	@FindBy(id="susbscribe_email")
	WebElement subScribe_email;
	
	//SubscriptionSucessMessage
	@FindBy(xpath="//div[text()='You have been successfully subscribed!']")
	WebElement Subscription_sucess_msg;
	
	//subscription Button
	@FindBy(id="subscribe")
	WebElement subscribe_click;
	
	
	//actionMethods
	public void clickLogout()
	{
		logout_btn.click();
	}
			public String  getUserName()
			{
								try
								{
									String text=getLoggedInName.getText();
									return(text);
								}
								catch(Exception e)
								{
									return(e.getMessage());
								}
			}
			
			public void clickTestCase()
			{
				TestCase_btn.click();
			}
			public boolean getTestCaseText()
			{
								try
								{
									return(TestCase_Text_ele.isDisplayed());
									
								}
								catch(Exception e)
								{
									return(false);
								}
					
			}
			public void clickProducts()
			{
				products_btn.click();
			}
			
			public void setSubscriptionMail(String email)
			{
				subScribe_email.sendKeys(email);
			}
			
			public void clickSubscribe()
			{
				subscribe_click.click();
			}
			
			public boolean getSubscriptionSucessMessage()
			{
						if(Subscription_sucess_msg.isDisplayed())
								{
									return (true);
								}
						else
						{
							return (false);
						}
			}
}
