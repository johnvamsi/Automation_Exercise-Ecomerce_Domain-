package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	//pageObjects
	@FindBy(how=How.XPATH,using="//a[normalize-space()='Logout']")
	WebElement logout_btn;
	
	@FindBy(how=How.NAME,using="email")
	WebElement email_txt;
	
	@FindBy(how=How.NAME,using="password")
	WebElement password_txt;
	
	@FindBy(how=How.XPATH,using="//button[normalize-space()='Login']")
	WebElement login_btn;
	
	@FindBy(how=How.XPATH,using="//li[10]//a[1]")
	WebElement getConfirmMsg;
	
	//actionMethods
	public void clickLogout()
	{
		logout_btn.click();
	}
	public void setEmail(String email)
	{
		email_txt.sendKeys(email);
	}
	public void setPassword(String pwd)
	{
		password_txt.sendKeys(pwd);
	}
	public void clickLogin()
	{
		login_btn.click();
	}
	public boolean getConfirmMsg()
	{
			try
			{
				return(getConfirmMsg.isDisplayed());
			}
			catch(Exception e)
			{
				return(false);
			}
		
		
	}
	
	

}
