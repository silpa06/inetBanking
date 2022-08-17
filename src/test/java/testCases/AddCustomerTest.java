package testCases;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import utilities.XLUtils;

public class AddCustomerTest extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		login  = new LoginPage(driver);
		login.setUserName(userName);
		login.setPassword(passWord);
		login.clickLogin();

		Thread.sleep(3000);
		
	
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		Thread.sleep(3000);
		addcust.custName("Silpa");
		addcust.custGender("female");
		addcust.custDOB("13","jul","1982");
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
		String path = System.getProperty("user.dir")+"\\src\\test\\java\\testData\\register_cust.xlsx";
		xlUtil =new XLUtils(path);
		//write header in excel sheet
		//String Sheet1 ="Customer_Details";
		xlUtil.setCellData("Customer_Details_sheet", 0, 0,"Customer ID");
		xlUtil.setCellData("Customer_Details_sheet", 0, 1,"Customer Name");
		xlUtil.setCellData("Customer_Details_sheet", 0, 2,"Gender");
		xlUtil.setCellData("Customer_Details_sheet", 0, 3,"Birthdate");
		xlUtil.setCellData("Customer_Details_sheet", 0, 4,"Address");
		xlUtil.setCellData("Customer_Details_sheet", 0, 5,"City");
		xlUtil.setCellData("Customer_Details_sheet", 0, 6,"State");
		xlUtil.setCellData("Customer_Details_sheet", 0, 7,"Pin");
		xlUtil.setCellData("Customer_Details_sheet", 0, 8,"Mobile No");
		xlUtil.setCellData("Customer_Details_sheet", 0, 9,"Email");

		//capture table data from application
		List<WebElement> custDetails = driver.findElements(By.xpath("//tbody/tr[3]/following-sibling::tr/td[2]"));
		int size = custDetails.size();
		int rowCount = xlUtil.getRowCount("Customer_Details_sheet");
		rowCount=rowCount+1;
		int i=0;
		for(WebElement custData:custDetails)
		{
			String data = custData.getText();
			System.out.println(data);
			
			xlUtil.setCellData("Customer_Details_sheet", rowCount, i,data);
			i++;
		}
	}
	

}
