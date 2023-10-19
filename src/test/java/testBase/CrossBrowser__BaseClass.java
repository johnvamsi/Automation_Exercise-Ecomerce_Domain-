package testBase;

import java.time.Duration;

import org.apache.commons.collections4.Get;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class CrossBrowser__BaseClass {
	//Global Variables
	public static WebDriver driver;
	public Logger logger;
	
	
	
	@BeforeClass
	@Parameters("browser")
	public void SetUp(String br)
	{
				logger =LogManager.getLogger(getClass());
				
				if(br.equals("chrome"))
				{
					driver=new ChromeDriver();
				}
				else if(br.equals("edge"))
				{
					driver=new EdgeDriver();
				}
				else if(br.equals("firefox"))
				{
					driver=new FirefoxDriver();
				}
		
		
		driver.get("https://automationexercise.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	
	
	@AfterClass
	public void TearDown()
	{
			driver.quit();
			driver.close();
	}
  
	//reUsableMethods
	public String randomAlphabets(int count)
	{
		String alphabets=RandomStringUtils.randomAlphabetic(count);
		return  alphabets;
	}
	
	
}
