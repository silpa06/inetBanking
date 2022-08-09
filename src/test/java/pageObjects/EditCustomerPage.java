package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {

	public static WebDriver driver;
	public EditCustomerPage(WebDriver rdriver)
	{
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
//Edit Customer Objects
@FindBy(linkText="Edit Customer")
WebElement editCust;

@FindBy(name="cusid")
WebElement custId;

@FindBy(name="AccSubmit")
WebElement submitBtn;

//Edit Customer Entry Objects
@FindBy(name="addr")
WebElement custAddress;


@FindBy(name="city")
WebElement custCity;

@FindBy(name="state")
WebElement custState;

@FindBy(name="pinno")
WebElement custPinno;

@FindBy(name="telephoneno")
WebElement custPhoneNo;

@FindBy(name="emailid")
WebElement custEmail;

@FindBy(name="sub")
WebElement edit_SubmitBtn;

//Edit Customer Object Actions 
public void clickEditCustomer()
{
	editCust.click();
}

public void customerId(int custID)
{
	custId.sendKeys(String.valueOf(custID));
}


public void clickSubmit()
{
	submitBtn.click();

}

//Edit Customer Entry Object Actions
public void custAddr(String addr)
{
	custAddress.clear();
	custAddress.sendKeys(addr); 
}
public void custCity(String city)
{
	custCity.clear();
	custCity.sendKeys(city);
}
public void custState(String state)
{
	custState.clear();
	custState.sendKeys(state);
}
public void custPin(int pin)
{
	custPinno.clear();
	custPinno.sendKeys(String.valueOf(pin));
}
public void custEmail(String email)
{
	custEmail.clear();
	custEmail.sendKeys(email);
}

public void editSubmit()

{
	edit_SubmitBtn.click();
}
}



