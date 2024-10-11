package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBAse.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups={"Sanity","Master"})
	
	public void verify_login() {
		logger.info("***********Starting login************");
		
		
		// Home PAge
		
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyaccount();
		hp.clickLogin();
		// Login Page
		LoginPage lp = new LoginPage(driver);

		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();

		// MyAccount
		MyAccountPage myacct = new MyAccountPage(driver);

		boolean target = myacct.isMyAccountPageExist();

		//Assert.assertEquals(target, true, "Login failed");
		Assert.assertTrue(target);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
	
		
		logger.info("***************************** Finish TC002_LoginTest***************** ");

	}
}
