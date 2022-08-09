package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;
import utilities.XLUtils;

public class BaseClass {
	
	public static WebDriver driver;
	Properties property;
	String userName;
	String passWord;
	LoginPage login;
	XLUtils xlUtil;

	//@Parameters("browser")
	@BeforeClass
	public void setUP() throws IOException
	{
	
				
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Configurations\\config.properties");
		property = new Properties();
		property.load(file);
		
		String browser = property.getProperty("browser");
		userName = property.getProperty("username");
		passWord = (property.getProperty("password"));
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
	
	
		}
		else if(browser.equalsIgnoreCase("FireFox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		
		}
		else
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(property.getProperty("url"));

	}
	
	
	

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public String pageTitle()
	{
		return driver.getTitle();
	}
		
	public String randomString()
	{
		String genneratedString = RandomStringUtils.randomAlphanumeric(6);
		return(genneratedString);
	}
	
	public String randomNumber()
	{
		String genneratednum = RandomStringUtils.randomNumeric(6);
		return(genneratednum);
	}

}
