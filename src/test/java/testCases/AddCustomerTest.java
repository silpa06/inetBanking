package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

public class AddCustomerTest extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		lp.setPassword(passWord);
		lp.clickLogin();
		Thread.sleep(3000);
		
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		Thread.sleep(6000);
		addcust.custName("Silpa");
		addcust.custGender("female");
		addcust.custDOB("13","Apr","1982");
		Thread.sleep(5000);
		addcust.custAddress("Singapore");
		addcust.custCity("singapore");
		addcust.custState("Compassvalelink");
		String pinno = randomNumber();
		addcust.custPinno(pinno);
		addcust.custTelephoneno("98734568");
		String email = randomString()+"@gmail.com";
		addcust.custEmailid(email);
		Thread.sleep(10);
		addcust.custPassword("abcdef");
		addcust.custSubmit();
		Thread.sleep(3000);
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res == true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
	}
	
	
	
	

}
