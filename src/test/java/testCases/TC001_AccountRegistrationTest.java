package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBAse.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups = { "Regression", "Master" })
	public void verify_account_registration() {

		logger.info("***************************** Starting TC001_AccountRegistrationTest ");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyaccount();

			logger.info("Clicked on MyAccount Link");

			hp.clickRegister();

			logger.info("Click on Register Link");

			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

			logger.info("Providing Customer Details");

			regpage.setFirstName(randomeString().toUpperCase());
			regpage.setLastName(randomeString().toUpperCase());
			regpage.setEmail(randomeString() + "@gmail.com"); // randomly genearted the email
			regpage.setTelephone(randomeNumber());

			String password = randomeAlphaNumeric();
			regpage.setPassword(password);
			regpage.setConfirmPassword(password);

			regpage.setPrivacyPolicy();
			regpage.ClickContinue();

			logger.info("Validating Expected Message");

			String confmsg = regpage.getConfirmationMsg();

			if (confmsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);

			} else {
				logger.error("Test Failed.......");
				logger.debug("Debug Logss");
				Assert.assertTrue(false);

			}

			// Assert.assertEquals(confmsg, "Your Account Has Been Created!!!");
		} catch (Exception e) {

			Assert.fail();
		}
		logger.info("Test Finishh......!!!!!!!!!!!!!!");
	}

}
