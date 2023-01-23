package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class AccountLoginPage extends Page {

	public AccountLoginPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
		// TODO Auto-generated constructor stub
	}

	private static final By emailInputField = By.cssSelector("form div.form-group:first-of-type input");
	private static final By passwordInputField = By.cssSelector("form div.form-group:last-of-type input");
	private static final By loginBtn = By.cssSelector("input[type='submit']");
	// private static final By continueBtn = By.xpath("//a[text()='Continue']");

	// Method to enter Email Input Field Value
	public void enterEmailInputField(String email) {
		((ProxyDriver) wd).sendKeys(emailInputField, email);
	}

	public String getLoginPageTitle() {
		return ((ProxyDriver) wd).getTitle();
	}

	// Method to enter Password Input Field Value
	public void enterPasswordInputField(String password) {
		((ProxyDriver) wd).sendKeys(passwordInputField, password);
	}

	// Method for User Login
	public MyAccountPage login(String email, String password) {
		enterEmailInputField(email);
		enterPasswordInputField(password);
		((ProxyDriver) wd).submit(loginBtn);
		return new MyAccountPage(wd, true);

	}

	@Override
	protected void isLoaded() {
		// TODO Auto-generated method stub

	}

}
