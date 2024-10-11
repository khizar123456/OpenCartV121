package testCases;
// data is valid --login success-test pass-logout--positive testing

// data is valid--login failed --test fail---negative testing

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBAse.BaseClass;
import utilities.DataProviders;

//data is invalid --login success---test fail----logout---negative
//data is imvalid --login failed --test pass--positve 

public class TC_003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "datadriven") // getting
																										// dataprovider
																										// from diff
																										// vlass
	public void verify_loginddt(String email, String pwd, String exp) {
		// Homepage

		logger.info("***************************starting TC_003_LoginDDT*******************");

		try {

			HomePage hp = new HomePage(driver);
			hp.clickMyaccount();
			hp.clickLogin();

			// Login Page
			LoginPage lp = new LoginPage(driver);

			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();

			// MyAccount
			MyAccountPage myacct = new MyAccountPage(driver);

			boolean target = myacct.isMyAccountPageExist();
			// data is valid --login success-test pass-logout--positive testing

			// data is valid--login failed --test fail---negative testing

			if (exp.equalsIgnoreCase("Valid")) {
				// login success
				if (target == true) {
					myacct.clicklogout();
					Assert.assertTrue(true);

				} else {

					Assert.assertTrue(false);

				}

			}

			// data is invalid --login success---test fail----logout---negative
			// data is imvalid --login failed --test pass--positve
			if (exp.equalsIgnoreCase("Invalid")) {
				// login success
				if (target == true) {
					myacct.clicklogout();
					Assert.assertTrue(false);

				} else {

					Assert.assertTrue(true);

				}

			}
		} catch (Exception e) {

			Assert.fail();

		}
		logger.info("******************* finshed TC_003_LoginDDT******************");

	}
}
