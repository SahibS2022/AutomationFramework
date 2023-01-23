package com.naveenautomation.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountCreatedPage;
import com.naveenautomation.Pages.HomePage;
import com.naveenautomation.Pages.RegisterAccountPage;
import com.naveenautomation.Utils.Utils;

public class AccountCreatedTest extends TestBase {

	HomePage homePage;
	SoftAssert sf;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		homePage = new HomePage(driver, true).get();
		sf = new SoftAssert();
	}

	@Test
	public void VerifyUserIsAbleToSignUpSuccessFully() {
		homePage.clickOnMyAccount();
		RegisterAccountPage registerAccountPage = homePage.clickOnRegister();
		sf.assertEquals(registerAccountPage.getTitleOfRegisterAccountPage(), "Register Account", "Invalid Page");
		AccountCreatedPage accountCreatedPage = registerAccountPage.register("Sahibs", "New", Utils.getRandomEmail(),
				"5146214785", "Admin@123", "Admin@123");

		sf.assertEquals(accountCreatedPage.getSuccessAccountCreatedTxt(), "Your Account Has Been Created!",
				"Account not created");
		sf.assertAll();

	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}
}
