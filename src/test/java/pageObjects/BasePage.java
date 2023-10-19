package pageObjects;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.FluentWait ;

public class BasePage {
				static WebDriver driver;
				BasePage(WebDriver driver)
				{
						this.driver=driver;
					PageFactory.initElements(driver,this);
				}
				
				
				//allWaits
				public static WebElement ExplicitlyWait(By ele)
				{
								WebDriverWait mywait = new WebDriverWait(driver,(Duration.ofSeconds(10)));
								WebElement element =mywait.until(ExpectedConditions.visibilityOfElementLocated(ele));
								return element;
					
				}
				
				public static WebElement FluentWait(By ele)
				{
						FluentWait wait=new FluentWait(driver);
						wait.withTimeout(Duration.ofSeconds(30));
						wait.pollingEvery(Duration.ofSeconds(5));
						wait.ignoring(NoSuchElementException.class);
					    WebElement element =(WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
					    return element;
					
				}
				//javascriptMethods
				public static void JavaScriptClick(WebElement Element)
				{
					JavascriptExecutor js =(JavascriptExecutor)driver;
					js.executeScript("arguments[0].click();", Element);
					
				}
				public static void ScrollDownPagebyPixel()
				{
					JavascriptExecutor js =(JavascriptExecutor)driver;
					js.executeScript("window.scrollBy(0,1000)", "");
					long value = (Long) js.executeScript("return window.pageYOffset;");
					System.out.println("Number of pixels moved:" + value);
				}
				public static void ScrollDownPageUptoElement(By element)
				{
					JavascriptExecutor js =(JavascriptExecutor)driver;
					WebElement flag=driver.findElement(element);
					js.executeScript("arguments[0].scrollIntoView();",flag);
					long value=(Long)js.executeScript("return window.pageYOffset;");
					System.out.println("Number of pixels moved:"+value);
				}
				
				public static void ScrollDownPageToTheEnd()
				{
							JavascriptExecutor js =(JavascriptExecutor)driver;
							 js.executeScript("window.scrollBy(0,document.body.scrollHeight)"); 
							 long  value=(Long)js.executeScript("return window.pageYOffset;"); 
							  System.out.println("Number of pixels moved:"+value); 
				}
				public static void ScrollDownPageToTheTop()
				{
							JavascriptExecutor js =(JavascriptExecutor)driver;
							 js.executeScript("window.scrollBy(0,-document.body.scrollHeight)"); 
							 long  value=(Long)js.executeScript("return window.pageYOffset;"); 
							  System.out.println("Number of pixels moved:"+value); 
				}
				public static void SetValueToInputBox(By element,String values)
				{
					JavascriptExecutor js =(JavascriptExecutor)driver;
					WebElement inputbox=driver.findElement(element);
					js.executeScript("arguments[0].setAttribute('value',values)", inputbox);
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				

}
