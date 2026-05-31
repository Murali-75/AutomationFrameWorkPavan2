//This is mainly used for validations after successful login 


package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage {

	public MyAccount(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//a[normalize-space()='Log out']")  //logout link  heading for login successful validation
	WebElement msgHeading;
	
	
	@FindBy(xpath="//a[normalize-space()='Log out']")  //Added in step number 6
	WebElement linkLogout;

	
	
	public boolean isMyAccountPageExists() {
		
		try
		{
			return	(msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clickLogout()
	{
		linkLogout.click();
	}
	

}
