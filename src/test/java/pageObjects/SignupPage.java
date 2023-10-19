package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasePage{
	
	public SignupPage(WebDriver driver)
	{
		super(driver);
	}
    
	
	//pageObjects
	@FindBy(xpath="//button[normalize-space()='Signup']")
	WebElement click_loginOrsignup;
	
	@FindBy(name="name")
	WebElement name_txt;
		// or
		By setName=By.name("name");
		public void setName1(String name)
		{
			WebElement name_txt=BasePage.FluentWait(setName);
			 name_txt.sendKeys(name);
		}
		
	
	@FindBy(xpath="//input[@data-qa='signup-email']")
	WebElement Email_txt;
	
	@FindBy(xpath="//button[normalize-space()='Signup']")
	WebElement click_signup_btn;
	
	@FindBy(xpath="//b[normalize-space()='Enter Account Information']")
	WebElement Success_ele;
	
	@FindBy(xpath="//*[text()='Email Address already exist!']")
	WebElement error_msg;
	
	
	//actionMethods
	public void clickSignupButton()
	{
		click_loginOrsignup.click();
	}
	public void setName(String name)
	{
		name_txt.sendKeys(name);
	}
	public void setEmail(String email)
	{
		Email_txt.sendKeys(email);
	}
	public void clickSignup()
	{
		click_signup_btn.click();
	}
	 public boolean getConfirmMsg()
	 {
			 try
			 {
				return (Success_ele.isDisplayed());
			 }
			 catch(Exception e)
			 {
				 return( Success_ele.isDisplayed());
			 }
	 }
	 //error_msg
	 public boolean getErrorMsg()
	 {
					 try
					 {
						return (error_msg.isDisplayed());
					 }
					 catch(Exception e)
					 {
						 return(false);
					 }
	 }
	
	
	
	
	
}
