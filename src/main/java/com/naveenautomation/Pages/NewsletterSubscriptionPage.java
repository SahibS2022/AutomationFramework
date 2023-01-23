package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class NewsletterSubscriptionPage extends Page {

	public NewsletterSubscriptionPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By yesRadioBtn = By.cssSelector("input[value='1']");
	private static final By noRadioBtn = By.cssSelector("input[value='0']");
	private static final By continueBtn = By.cssSelector("input[value='Continue']");

	public void subscribeNewsletter() {
		((ProxyDriver) wd).click(yesRadioBtn);
	}

	public void unSubscribeNewsletter() {
		((ProxyDriver) wd).click(noRadioBtn);
	}

	public MyAccountPage clickContinueBtnNewsletter() {
		((ProxyDriver) wd).submit(continueBtn);
		return new MyAccountPage(wd, true);
	}

	@Override
	protected void isLoaded() {
		// TODO Auto-generated method stub

	}

}
