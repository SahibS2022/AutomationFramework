package com.naveenautomation.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.HomePage;
import com.naveenautomation.Pages.MyAccountInfoPage;
import com.naveenautomation.Pages.MyAccountPage;
import com.naveenautomation.Utils.ExcelUtils;

public class MyAccountInfoTest extends TestBase {

	SoftAssert sf;
	AccountLoginPage accountLoginPage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		sf = new SoftAssert();
		HomePage homePage = new HomePage(driver,true).get();
		homePage.clickOnMyAccount();
		accountLoginPage = homePage.clickOnLogin();
	}

	@Test(dataProvider = "LoginDataProvider")
	public void verifyUserAccountInfoIsPrefilled(String userName, String password, String firstName, String lastName,
			String telephone) {
		MyAccountPage myAccountPage = accountLoginPage.login(userName, password);
		sf.assertEquals(myAccountPage.getMyAccountPageTitle(), "My Account");
		MyAccountInfoPage myAccountInfoPage = myAccountPage.clickEditYourAccountInfoLink();
		sf.assertEquals(myAccountInfoPage.getMyAccountInfoPageTitle(), "My Account Information");
		sf.assertEquals(myAccountInfoPage.getFirstNameInputFieldValue(), firstName);
		sf.assertEquals(myAccountInfoPage.getLastNameInputFieldValue(), lastName);
		sf.assertEquals(myAccountInfoPage.getEmailInputFieldValue(), userName);
		sf.assertEquals(myAccountInfoPage.getTelephoneInputFieldValue(), telephone);
		sf.assertAll();
	}

	@DataProvider(name = "LoginDataProvider")
	public String[][] provideLoginData() throws IOException {
		String filePath = "./Test Data\\LoginDetails.xlsx";
		int rowCount = ExcelUtils.getRowCount(filePath, "Sheet1");
		int colCount = ExcelUtils.getColumnCount(filePath, "Sheet1", rowCount);
		String[][] loginData = new String[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				loginData[i - 1][j] = ExcelUtils.getCellValue(filePath, "Sheet1", i, j);
			}
		}
		return loginData;

	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}

}
