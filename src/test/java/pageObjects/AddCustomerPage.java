package pageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	public static WebDriver driver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		driver = rdriver;
		PageFactory.initElements(rdriver,this); 
	}
	
	@FindBy(how = How.XPATH, using ="//a[text()='New Customer']")
	WebElement lnkAddCustomer;
	
	@FindBy(how = How.NAME, using ="name")
	WebElement txtCustomerName;
	
	@FindBy(how = How.XPATH, using ="//input[@name='rad1']")
	List<WebElement> rdGender;
	
	@FindBy(how = How.ID_OR_NAME, using ="dob")
	WebElement txtdob;
	
	@FindBy(how = How.XPATH, using ="//textarea[@name='addr']")
	WebElement txtAddress;
	
	@FindBy(how = How.NAME, using ="city")
	WebElement txtCity;
	
	@FindBy(how = How.NAME, using ="state")
	WebElement txtState;
	
	@FindBy(how = How.NAME, using ="pinno")
	WebElement txtPinno;
	
	@FindBy(how = How.NAME, using ="telephoneno")
	WebElement txtTelephoneno;
	
	@FindBy(how = How.NAME, using ="emailid")
	WebElement txtEmailid;
	
	@FindBy(how = How.NAME, using ="password")
	WebElement txtPassword;
	
	@FindBy(how = How.NAME, using ="sub")
	WebElement btnSubmit;
	
	
	public void clickAddNewCustomer()
	{
		lnkAddCustomer.click();
	}
	
	public void custName(String cname)
	{
		txtCustomerName.sendKeys(cname);
	}
	
	public void custGender(String cgrnder)
	{
		for(WebElement radio:rdGender) {
			String str = radio.getAttribute("value");
			System.out.println(str);
			if(str.equals("m") && cgrnder == "male" )
			{
				radio.click();
				break;
			}
			else if(str.equals("f") && cgrnder == "female")
			{
				radio.click();
				break;
			}
			else
				continue;
			
	
			
		}
	
		//System.out.println(str);
		//rdGender.click();	
	
	}
	
	public void custDOB(String dd,String mmm,String yyyy)
	{
		txtdob.sendKeys(dd);
		txtdob.sendKeys(mmm);
		txtdob.sendKeys(Keys.TAB);
		txtdob.sendKeys(yyyy);
	
		
	}
	
	public void custAddress(String caddress)
	{
		txtAddress.sendKeys(caddress);
	}
	
	public void custCity(String ccity)
	{
		txtCity.sendKeys(ccity);
	}
	
	public void custState(String cstate)
	{
		txtState.sendKeys(cstate);
	}
	
	public void custPinno(String cpinno)
	{
		txtPinno.sendKeys(String.valueOf(cpinno));
	}
	
	public void custTelephoneno(String ctelephoneno)
	{
		txtTelephoneno.sendKeys(ctelephoneno);
	}
	
	public void custEmailid(String cemailid)
	{
		txtEmailid.sendKeys(cemailid);
	}
	
	public void custPassword(String cpassword)
	{
		txtPassword.sendKeys(cpassword);
	}
	
	public void custSubmit()
	{
		btnSubmit.click();
	}
	
	
}
