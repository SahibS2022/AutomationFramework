package com.naveenautomation.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.AccountLogoutPage;
import com.naveenautomation.Pages.HomePage;
import com.naveenautomation.Pages.MyAccountInfoPage;
import com.naveenautomation.Pages.MyAccountPage;
import com.naveenautomation.Pages.NewsletterSubscriptionPage;

public class MyAccountTest extends TestBase {
	MyAccountPage myAccountPage;
	SoftAssert sf;
	HomePage homePage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		sf = new SoftAssert();
		homePage = new HomePage();
		homePage.clickOnMyAccount();
		AccountLoginPage accountLoginPage = homePage.clickOnLogin();
		myAccountPage = accountLoginPage.login("sg1@gmail.com", "Admin@123");
	}

	@Test(priority = 1)
	public void verifyUserIsAbleToLoginSuccessfully() {
		sf.assertEquals(myAccountPage.getMyAccountText(), "My Account", "Login Failed");
		sf.assertAll();
	}

	@Test(priority = 2)
	public void verifyUserIsAbleToUpdateTelephoneSuccessfully() {
		MyAccountInfoPage myAccountInformationPage = myAccountPage.clickEditYourAccountInfoLink();
		myAccountInformationPage.updateUserTelephone();
		sf.assertEquals(myAccountPage.getTelephoneChangesSuccessMessage(),
				"Success: Your account has been successfully updated.", "Account Info Updation Failed!");
		sf.assertAll();
	}

	@Test(priority = 3)
	public void verifyUserIsAbleToSubscribeNewsletterSuccessfully() {
		NewsletterSubscriptionPage newsletterSubscriptionPage = myAccountPage
				.clickSubscribeOrUnsubscribeNewsletterLink();
		newsletterSubscriptionPage.subscribeNewsletter();
		newsletterSubscriptionPage.clickContinueBtnNewsletter();
		sf.assertEquals(myAccountPage.getNewsletterSubscriptionSuccessMessage(),
				"Success: Your newsletter subscription has been successfully updated!",
				"Newsletter Subscription Failed!");
		sf.assertAll();
	}

	@Test(priority = 4)
	public void verifyUserIsAbleToLogoutSuccessfully() {
		AccountLogoutPage accountLogoutPage = myAccountPage.clickLogoutLink();
		sf.assertEquals(accountLogoutPage.getAccountLogoutText(), "Account Logout", "Invalid Page!");
		accountLogoutPage.clickContinueBtn();
		sf.assertEquals(homePage.getHomePageTitle(), "Your Store", "Logout Failed!");
		sf.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}
}
