package testBase;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.collections4.Get;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;
	
	
	@BeforeClass
	public void SetUp()
	{
		logger =LogManager.getLogger(getClass());
		rb=ResourceBundle.getBundle("config");
		
		
		driver=new ChromeDriver();
		driver.get(rb.getString("appURL"));
		
		//driver.get("https://automationexercise.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().deleteAllCookies();
	}
	
	@AfterClass
	public void TearDown()
	{
		  driver.quit();
		//driver.close();
	}
	
	
	
	
	
	//reUsableMethods
	
	public String randomNumbers(int count)
	{
		String generatedString=RandomStringUtils.randomNumeric(count);
		return(generatedString);
	}
	public String randomAlphabets(int count)
	{
		String generatedString1=RandomStringUtils.randomAlphabetic(count);
		return(generatedString1);
	}
	public String randomAlphanumeric(int count)
	{
		String generatedString2=RandomStringUtils.randomAlphanumeric(count);
		return(generatedString2);
	}
	
	//CaptureScreen 
	public void CaptureScreen(WebDriver driver,String tcname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
	    File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"\\screenshots\\"+tcname+".png");
		FileUtils.copyDirectory(source, target);
	}
	
	 public String captureScreen(String tname) throws IOException 
		{

			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
					
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
			String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

					try 
					{
						FileUtils.copyFile(source, new File(destination));
					} 
					catch (Exception e) 
					{
						e.getMessage();
					}
					return destination;

		}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
