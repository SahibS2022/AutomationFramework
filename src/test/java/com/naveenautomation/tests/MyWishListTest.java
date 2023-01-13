package com.naveenautomation.tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.HomePage;
import com.naveenautomation.Pages.LaptopsAndNotebooksPage;
import com.naveenautomation.Pages.MyAccountPage;
import com.naveenautomation.Pages.MyWishListPage;
import com.naveenautomation.Pages.MyWishListPage.MyWishList;

public class MyWishListTest extends TestBase {

	MyAccountPage myAccountPage;
	SoftAssert sf;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		sf = new SoftAssert();
		HomePage homePage = new HomePage();
		homePage.clickOnMyAccount();
		AccountLoginPage accountLoginPage = homePage.clickOnLogin();
		sf.assertEquals(accountLoginPage.getLoginPageTitle(), "Account Login", "Invalid Page!");
		myAccountPage = accountLoginPage.login("sg1@gmail.com", "Admin@123");
	}

	@Test
	public void verifyIfUserIsAbleToAddProductsToWishListSuccessfully() {
		myAccountPage.actionMoveTolaptopsAndNotebooksLink();
		LaptopsAndNotebooksPage laptopsAndNotebooksPage = myAccountPage.clickShowAllLaptopsAndNoteBooksLink();
		sf.assertEquals(laptopsAndNotebooksPage.getLaptopsAndNotebooksText(), "Laptops & Notebooks", "InValid Page!");
		laptopsAndNotebooksPage.selectRatingHighestByVisibleText();
		laptopsAndNotebooksPage.clickFirstAddToWishListButton();
		laptopsAndNotebooksPage.clickSecondAddToWishListButton();
		sleep();
		laptopsAndNotebooksPage.clickThirdAddToWishListButton();
		sleep();
		MyWishListPage myWishListPage = laptopsAndNotebooksPage.clickOnWishListLink();
		String firstProductName = myWishListPage.getElementFromTheTable("MacBook Air", MyWishList.PRODUCTNAME)
				.getText();
		String secondProductName = myWishListPage.getElementFromTheTable("MacBook Pro", MyWishList.PRODUCTNAME)
				.getText();
		String thirdProductName = myWishListPage.getElementFromTheTable("Sony VAIO", MyWishList.PRODUCTNAME).getText();
		String firstProductPrice = myWishListPage.getElementFromTheTable("MacBook Air", MyWishList.UNITPRICE).getText();
		String secondProductPrice = myWishListPage.getElementFromTheTable("MacBook Pro", MyWishList.UNITPRICE)
				.getText();
		String thirdProductPrice = myWishListPage.getElementFromTheTable("Sony VAIO", MyWishList.UNITPRICE).getText();
		sf.assertEquals(firstProductName, "MacBook Air", "Invalid Product!");
		sf.assertEquals(secondProductName, "MacBook Pro", "Invalid Product!");
		sf.assertEquals(thirdProductName, "Sony VAIO", "Invalid Product!");
		sf.assertEquals(firstProductPrice, "$1,202.00", "Invalid Product!");
		sf.assertEquals(secondProductPrice, "$2,000.00", "Invalid Product!");
		sf.assertEquals(thirdProductPrice, "$1,202.00", "Invalid Product!");
		myWishListPage.removeProduct(thirdProductName, MyWishList.ACTION, By.cssSelector("a"));
		sf.assertEquals(myWishListPage.getTextForProductDeletedSuccessfully(),
				"Success: You have modified your wish list!", "Deletion Failed!");
		sf.assertAll();

	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}

	public void sleep() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
