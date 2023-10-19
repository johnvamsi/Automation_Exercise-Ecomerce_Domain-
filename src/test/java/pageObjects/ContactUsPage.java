package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class ContactUsPage  extends BasePage{
			public ContactUsPage(WebDriver driver)
			{
				super(driver);
				
			}
			//pageObjects
			@FindBy(xpath="//div[@class='status alert alert-success']")
			WebElement getSucessMsg;
		
			@FindBy(xpath="//a[text()=' Contact us']")
			WebElement click_Contactus;
			
			@FindBy(name="name")
			WebElement name_txt;
			
			@FindBy(name="email")
			WebElement email_txt;
			
			@FindBy(name="subject")
			WebElement subject_txt;
			
			@FindBy(id="message")
			WebElement message_txt;
			
//			@FindBy(name="upload_file")
//			WebElement click_uploadFile;
			By upload_file= By.name("upload_file");
			
			@FindBy(name="submit")
			WebElement click_submit;
			
		
			
			//actionMethods
			public void clickContact()
			{
				click_Contactus.click();
			}
			public void setName(String name)
			{
				name_txt.sendKeys(name);
			}
			public void setEmail(String email)
			{
				email_txt.sendKeys(email);
			}
			public void setSubject(String sub)
			{
				subject_txt.sendKeys(sub);
			}
			public void setMessage(String message)
			{
				message_txt.sendKeys(message);
			}
			
			public void uploadFile(String file) throws Exception
			{
				Actions aa= new Actions(driver);
				aa.moveToElement(ExplicitlyWait(upload_file)).click().perform();
				Thread.sleep(4000);
				
				//click_uploadFile.click();
					StringSelection ss=new StringSelection(file);
				     Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
				     
				    //Robot class
				     Robot rb=new Robot();
				     rb.delay(300);
				     
				     //CTRL+V
				     rb.keyPress(KeyEvent.VK_CONTROL);
				     rb.keyPress(KeyEvent.VK_V);
				        
				     rb.keyRelease(KeyEvent.VK_CONTROL);
				     rb.keyRelease(KeyEvent.VK_V);
				     rb.delay(2000);
				     
				     //press Enter key
				     rb.keyPress(KeyEvent.VK_ENTER);
				     rb.keyRelease(KeyEvent.VK_ENTER);
				
			}
		
			public void clickSubmit()
			{
				click_submit.click();
				
			}
			public void closeAlert()
			{
				driver.switchTo().alert().accept();
			}
			public String getConfirmMsg()
				{
							try
							{
								 return(getSucessMsg.getText());
					
							}
							catch(Exception e)
							{
								 return(e.getMessage());
							}
				}
	     
			
	
	
	
	
	

}
