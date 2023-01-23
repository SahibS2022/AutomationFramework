package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class MyAccountInfoPage extends Page {

	public MyAccountInfoPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By firstNameInputField = By.cssSelector("input[id = 'input-firstname']");
	private static final By lastNameInputField = By.cssSelector("input[id = 'input-lastname']");
	private static final By emailInputField = By.cssSelector("input[id = 'input-email']");
	private static final By telephoneInputField = By.cssSelector("input[id = 'input-telephone']");
	private static final By telephone = By.cssSelector("input[name='telephone']");
	private static final By continueBtn = By.cssSelector("input[value='Continue']");

	public MyAccountPage updateUserTelephone() {
		((ProxyDriver) wd).clear(telephone);
		((ProxyDriver) wd).sendKeys(telephone, "5146217769");
		((ProxyDriver) wd).submit(continueBtn);
		return new MyAccountPage(wd, true);
	}

	// Method to get MyAccountInfo Page Title
	public String getMyAccountInfoPageTitle() {
		return ((ProxyDriver) wd).getTitle();
	}

	// Method to get FirstNameInputField value
	public String getFirstNameInputFieldValue() {
		return ((ProxyDriver) wd).getAttribute(firstNameInputField, "value");
	}

	// Method to get LastNameInputField value
	public String getLastNameInputFieldValue() {
		return ((ProxyDriver) wd).getAttribute(lastNameInputField, "value");
	}

	// Method to get EmailInputField value
	public String getEmailInputFieldValue() {
		return ((ProxyDriver) wd).getAttribute(emailInputField, "value");
	}

	// Method to getTelephoneInputFieild value
	public String getTelephoneInputFieldValue() {
		return ((ProxyDriver) wd).getAttribute(telephoneInputField, "value");
	}

	@Override
	protected void isLoaded() {
		// TODO Auto-generated method stub

	}

}
