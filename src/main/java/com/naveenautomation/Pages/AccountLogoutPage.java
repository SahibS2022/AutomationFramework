package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class AccountLogoutPage extends Page {

	public AccountLogoutPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By accountLogoutText = By.cssSelector("h1");
	private static final By continueBtn = By.xpath("//a[text() = 'Continue']");

	public String getAccountLogoutText() {
		return ((ProxyDriver) wd).getText(accountLogoutText);
	}

	public HomePage clickContinueBtn() {
		((ProxyDriver) wd).click(continueBtn);
		return new HomePage(wd, true);
	}

	@Override
	protected void isLoaded() {

	}

}
