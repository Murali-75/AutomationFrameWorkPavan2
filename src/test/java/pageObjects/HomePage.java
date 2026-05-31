package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement registerAccount;
	
	@FindBy(xpath="//a[normalize-space()='Log in']") 
	WebElement linkLogin;             //Login link added in step 5
	
	
	
	
	
	public void register()
	{
		registerAccount.click();
	}
	
	public void clickLogin()
	{
		linkLogin.click();
	}

}
