package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DeleteCustomerPage;
import pageObjects.LoginPage;

public class DeleteCustomerTest extends BaseClass{
	
	@Test
	public void deleteCustomer() throws InterruptedException {
		login  = new LoginPage(driver);
		login.setUserName(userName);
		login.setPassword(passWord);
		login.clickLogin();
		Thread.sleep(3000);
		String exp_Title ="Guru99 Bank Manager HomePage";
		String actual_Title = pageTitle();
		Assert.assertEquals(actual_Title, exp_Title,"login success");
		
		DeleteCustomerPage deleteCust = new DeleteCustomerPage(driver);
		deleteCust.clickDeleteCust();
		Thread.sleep(3000);
		String exp_deleteCust_title = "Guru99 Bank Delete Customer Page";
		String actual_deleteCust_title = pageTitle();
		Assert.assertEquals(actual_deleteCust_title,exp_deleteCust_title, "Delete Customer Page");
		deleteCust.setCustomerId(56503);
		deleteCust.clickSubmit();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		driver.navigate().refresh();
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		
	}
}

	
	
	