package com.naveenautomation.tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.AddressBookPage;
import com.naveenautomation.Pages.HomePage;
import com.naveenautomation.Pages.MyAccountPage;

public class AddressBookTest extends TestBase {

	MyAccountPage myAccountPage;
	SoftAssert sf;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		sf = new SoftAssert();
		HomePage homePage = new HomePage(driver,true).get();
		homePage.clickOnMyAccount();
		AccountLoginPage accountLoginPage = homePage.clickOnLogin();
		sf.assertEquals(accountLoginPage.getLoginPageTitle(), "Account Login", "Invalid Page!");
		myAccountPage = accountLoginPage.login("sg1@gmail.com", "Admin@123");
	}

	@Test
	public void verifyIfUserIsAbleToEditMyAdressBookSuccessfully() {
		AddressBookPage addressBookPage = myAccountPage.clickAddressBookLink();

		// edit city for selected customer using Customer Name
		addressBookPage.clickToUpdateAddressBookForSelectedCustomer("Navjot Singh", By.cssSelector("a:first-of-type"));
		addressBookPage.updateCityForSelectedCustomer("Montreal");
		sf.assertEquals(addressBookPage.getSuccessBannerUpdateText(), "Your address has been successfully updated",
				"Updation Failed!");

		// edit city for selected customer using Customer Name
		addressBookPage.clickToUpdateAddressBookForSelectedCustomer("Sahib Gill", By.cssSelector("a:first-of-type"));
		addressBookPage.updateCityForSelectedCustomer("Toronto");
		sf.assertEquals(addressBookPage.getSuccessBannerUpdateText(), "Your address has been successfully updated",
				"Updation Failed!");

		// delete selected customer using Customer Name
		addressBookPage.clickToUpdateAddressBookForSelectedCustomer("Daman Singh", By.cssSelector("a:last-of-type"));
		addressBookPage.deleteSelectedCustomer();
		sf.assertEquals(addressBookPage.getSuccessBannerUpdateText(), "Your address has been successfully deleted",
				"Deletion Failed!");
		sf.assertAll();

	}

	@AfterMethod
	public void tearDown() {
		 quitBrowser();
	}

}
