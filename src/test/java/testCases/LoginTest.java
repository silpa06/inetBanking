package testCases;
import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class LoginTest extends BaseClass {

	
	@Test
	public void loginTest()
	{

	LoginPage lp = new LoginPage(driver);
	lp.setUserName(userName);
	lp.setPassword(passWord);
	lp.clickLogin();
	if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
	{
		Assert.assertTrue(true);
		
		
	}
	else
	{
		Assert.assertTrue(false);
		
		
	}
	
	
	
	}
	

}
