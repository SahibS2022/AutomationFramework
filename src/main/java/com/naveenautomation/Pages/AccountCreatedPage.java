package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class AccountCreatedPage extends Page {

	public AccountCreatedPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By accountCreationSuccessTxt = By.cssSelector("#content h1");

	public String getSuccessAccountCreatedTxt() {
		return ((ProxyDriver) wd).getText(accountCreationSuccessTxt);
	}

	@Override
	protected void isLoaded() {

	}
}
