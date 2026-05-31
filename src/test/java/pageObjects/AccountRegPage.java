package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegPage extends BasePage {

	public AccountRegPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	//Locators to identify elements
	
	@FindBy(xpath="//input[@id='gender-male']")
	WebElement maleRadioBtn;
	
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement  txtFirstName;
	
	@FindBy(xpath="//input[@id='LastName']")
	WebElement  txtLastName;
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement  txtEmail;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement  txtPassword;
	
	@FindBy(xpath="//input[@id='ConfirmPassword']")
	WebElement  txtConfPassword;
	
	@FindBy(xpath="//input[@id='register-button']")
	WebElement  registerBtn;
	
	@FindBy(xpath="//*[contains(text(),'Your registration completed')]")
	WebElement msgConfirmation;
	
	
	
	
	//Action methods
	
	public void genderSelection()
	{
		maleRadioBtn.click();
	}
	
	public void firstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void lastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	
	public void setPassword(String pass)
	{
		 txtPassword.sendKeys(pass);
	}
	
	public void confirmPassword(String confimpass )
	{
		txtConfPassword.sendKeys(confimpass);
	}
	
	public void registerBtn( )
	{
		registerBtn.click();
	}
	
	
	 public String getConfirmationMsg()
	    {
	    	try {
				return msgConfirmation.getText();
			} catch (Exception e) {
				
				return e.getMessage();
			}
	    }
	
	
	
	
	
	
	
	
	

}
