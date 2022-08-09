package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import utilities.XLUtils;

public class LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd,String result) throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		lp.setPassword(pwd);
		lp.clickLogin();
		Thread.sleep(10);
		
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertEquals(result,"Invalid","invalid data test failed");
		}
		else
		{
			Assert.assertEquals(result, "Valid","valid data test passed");
			lp.clickLogout();
			Thread.sleep(10);
			
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
		}
		
		
	}
	
	public boolean isAlertPresent()
	{
		try {
		driver.switchTo().alert();
		return true;
	}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src/test/java/TestData/loginmngr.xlsx";
	    xlUtil = new XLUtils(path);
		
		int rownum = xlUtil.getRowCount("Sheet1");
		int colcount = xlUtil.getCellCount("Sheet1",1);
		System.out.println("number of rows "+rownum);
		System.out.println("number of columns "+colcount);
		String logindata[][] = new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j] = xlUtil.getCellData("Sheet1", i, j);
				
			}
		}
		return logindata;
	}

}
