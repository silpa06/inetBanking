package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage {
	
	public static WebDriver driver;
	public DeleteCustomerPage(WebDriver rdriver)
	{
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}

	//Delete customer page objects
	@FindBy(xpath="//a[text()='Delete Customer']")
	WebElement deleteCustLnk;
	
	@FindBy(name="cusid")
	WebElement custId;
	
	@FindBy(name="AccSubmit")
	WebElement submitBtn;
	
	//Action Methods
	public void clickDeleteCust()
	{
		deleteCustLnk.click();
	}
	public void setCustomerId(int custID)
	{
		custId.sendKeys(String.valueOf(custID));
	}
	
	public void clickSubmit()
	{
		submitBtn.click();

	}

}
