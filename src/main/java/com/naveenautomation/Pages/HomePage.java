package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class HomePage extends Page {
	private static final String PAGE_URL = "common/home";

	public HomePage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By myAccountLink = By.cssSelector("a[title='My Account']");
	private static final By registerLink = By.xpath("//a[text()='Register']");
	private static final By loginLink = By.xpath("//a[text()='Login']");

	public void clickOnMyAccount() {
		((ProxyDriver) wd).click(myAccountLink);
	}

	public RegisterAccountPage clickOnRegister() {
		((ProxyDriver) wd).click(registerLink);
		return new RegisterAccountPage(wd, true);
	}

	public AccountLoginPage clickOnLogin() {
		((ProxyDriver) wd).click(loginLink);
		return new AccountLoginPage(wd, true);
	}

	public String getHomePageTitle() {
		return ((ProxyDriver) wd).getTitle();
	}

	@Override
	protected void isLoaded() {

		if (!urlContains(wd.getCurrentUrl())) {
			throw new Error();
		}
	}

	@Override
	protected String getPageUrl() {
		return getDomain() + PAGE_URL;
	}

	@Override
	public HomePage get() {
		// TODO Auto-generated method stub
		return (HomePage) super.get();
	}

}
