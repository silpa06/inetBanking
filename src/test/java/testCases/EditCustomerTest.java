package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EditCustomerPage;
import pageObjects.LoginPage;

public class EditCustomerTest extends BaseClass{
	
	@Test
	public void editCustomer() throws InterruptedException {
		login  = new LoginPage(driver);
		login.setUserName(userName);
		login.setPassword(passWord);
		login.clickLogin();
		Thread.sleep(3000);
		String exp_Title ="Guru99 Bank Manager HomePage";
		String actual_Title = pageTitle();
		Assert.assertEquals(actual_Title, exp_Title,"login success");
		EditCustomerPage editCust = new EditCustomerPage(driver);
		
		//Edit Customer
		
		editCust.clickEditCustomer();
		Thread.sleep(6000);
	String exp_editCust_title ="Guru99 Bank Edit Customer Page";
	String actual_editCust_title =pageTitle();
	Assert.assertEquals(actual_editCust_title,exp_editCust_title, "Edit Customer page");
	//Enter CustomerId and Click on Submit
	editCust.customerId(56503);
	editCust.clickSubmit();
	Thread.sleep(3000);
	
	//Edit Customer Entry 
	String exp_edit_title ="Guru99 Bank Edit Customer Entry Page";
	String actual_edit_title=pageTitle();
	Assert.assertEquals(actual_edit_title,exp_edit_title, "Edit Customer Entry page");
	
	//Edit the Values
	//Edit Address
	editCust.custAddr("Singapore,Buangkok");
	Thread.sleep(3000);
	//Edit needed values
	/*editCust.custCity("");
	editCust.custState("");
	editCust.custPin(0);
	editCust.custEmail("");*/
	
	editCust.editSubmit();
	Thread.sleep(3000);
	driver.switchTo().alert().accept();
	driver.navigate().refresh();
	driver.switchTo().defaultContent();
	Thread.sleep(3000);
	}
	
	

}
