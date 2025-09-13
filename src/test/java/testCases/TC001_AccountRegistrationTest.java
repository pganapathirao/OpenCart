package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

		
	@Test(groups="sanity")
	public void verify_account_registration()
	{
		logger.info("****Starting Test Case********");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("****Clicked on Myaccount********");
		hp.clickRegister();
		logger.info("****Clicked on Registration********");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info("****Providing Registration Information********");
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");
		regpage.setTelephone(randomenumber());
		
		String password=randomealphanumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		String confmsg=regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		logger.info("****Ended on Registration********");
		}
		catch(Exception e)
		{
			logger.error("Test Failed");
			logger.debug("Debug Logs..");
			Assert.fail();
		}
		
		
	}
	

}
