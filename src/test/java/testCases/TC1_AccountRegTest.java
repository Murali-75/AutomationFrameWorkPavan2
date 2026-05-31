package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC1_AccountRegTest extends BaseClass {

	
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		
		logger.info("******Starting TC1_AccountRegTest  ******");
		
		try
		{
		//creating object for the HomePage page object class
		HomePage hp = new HomePage(driver);
		hp.register();
		logger.info("Clicked on register");
		
		
		
		//creating object for the AccountRegPage page object class
		
		AccountRegPage regpage = new AccountRegPage(driver);
		
		logger.info("Providing customer details....");
		regpage.genderSelection();
		regpage.firstName(randomString().toUpperCase());
		regpage.lastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		
		String pass=randomAlphanumeric();
		regpage.setPassword(pass);
		regpage.confirmPassword(pass); //randomly generated  email
		
		regpage.registerBtn();
		
		
		logger.info("Validating expected message....");
		String confmsg=regpage.getConfirmationMsg();
		
		Assert.assertEquals(confmsg, "Your registration completed");
		
		}
		catch(Exception e)
		{
			logger.error("Test failed..");
			logger.debug("Debug logs..");
			Assert.fail();
		}
		
		logger.info("******Finished TC1_AccountRegTest  ******");
		
	}
	
}
