package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;
import utilities.DataProviders;

/*Data is valid-login success-testpass - logout
 * Data is valid --login filed -test fail
 * Data is invalid--login success - test fail-logout
 * Data is invalid --login failed-test pass
 */

public class TC3_LoginDataDrivenTestcase extends BaseClass {
	
	@Test(dataProvider= "LoginData",dataProviderClass= DataProviders.class,groups="Datadriven")//getting data provider from another class
	public void verify_loginDDT(String email,String  password,String exp)
	{
		logger.info("*****Starting TC3_LoginDataDrivenTestcase *****");
	
			
		
		   try
		   {
		    //HomePage
			HomePage hp=new HomePage(driver);
			hp.clickLogin();
			
			//Login 
			LoginPage lp=new LoginPage(driver);
			
			lp.setEmail(email);
			lp.setPassword(password);
			lp.clickLogin();
			
			//MyAccount 
			MyAccount macc = new MyAccount(driver);
			boolean targetPage = macc.isMyAccountPageExists();
			
			
			if(exp.equalsIgnoreCase("valid"))
			{
				if(targetPage==true)
				{
					macc.clickLogout();
					Assert.assertTrue(true);
					
				}
				else {
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("Invalid"))
			{
				
				if(targetPage==true)
				{
					macc.clickLogout();
					Assert.assertTrue(false);
				}
			}
			else 
			{
				
				  Assert.assertTrue(true);
			}
			
		   }catch(Exception e)
		   {
			     Assert.fail();
		   }
			
			logger.info("***** Finished  TC3_LoginDataDrivenTestcase *****");
	}


}
