package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.naveenautomation.Browsers.ProxyDriver;

public class MyAccountPage extends Page {

	Actions action;

	public MyAccountPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
		action = new Actions(wd);
	}

	private static final By laptopsAndNotebooksLink = By.xpath("//a[text() = 'Laptops & Notebooks']");
	private static final By showAllLaptopsAndNotebooksLink = By.xpath("//a[text() = 'Show All Laptops & Notebooks']");
	private static final By addressBookLink = By.cssSelector("aside#column-right a:nth-of-type(4)");
	private static final By myAccountText = By.xpath("//h2[text()='My Account']");
	private static final By changePasswordLink = By.id("column-right a:nth-of-type(3)");
	private static final By editAccountInfoLink = By.xpath("//a[text()='Edit your account information']");
	private static final By subscribeOrUnsubscribeToNewsletterLink = By
			.xpath("//a[text()='Subscribe / unsubscribe to newsletter']");
	private static final By logoutLink = By.cssSelector("aside#column-right a:last-of-type");
	private static final By passwordChangesSuccessBanner = By.cssSelector("div.alert-success");
	private static final By telephoneChangesSuccessBanner = By.cssSelector("div.alert-success");
	private static final By newsletterSubscriptionSuccessBanner = By.cssSelector("div.alert-success");

	// Method to get the MyAccountPage Title
	public String getMyAccountText() {
		return ((ProxyDriver) wd).getText(myAccountText);
	}

	public String getMyAccountPageTitle() {
		return ((ProxyDriver) wd).getTitle();
	}

	public void actionMoveTolaptopsAndNotebooksLink() {
		((ProxyDriver) wd).click(laptopsAndNotebooksLink);
	}

	public String getTelephoneChangesSuccessMessage() {
		return ((ProxyDriver) wd).getText(telephoneChangesSuccessBanner);
	}

	public String getNewsletterSubscriptionSuccessMessage() {
		return ((ProxyDriver) wd).getText(newsletterSubscriptionSuccessBanner);
	}

	public NewsletterSubscriptionPage clickSubscribeOrUnsubscribeNewsletterLink() {
		((ProxyDriver) wd).click(subscribeOrUnsubscribeToNewsletterLink);
		return new NewsletterSubscriptionPage(wd, true);
	}

	public AccountLogoutPage clickLogoutLink() {
		((ProxyDriver) wd).click(logoutLink);
		return new AccountLogoutPage(wd, true);
	}

	public LaptopsAndNotebooksPage clickShowAllLaptopsAndNoteBooksLink() {
		((ProxyDriver) wd).click(showAllLaptopsAndNotebooksLink);
		return new LaptopsAndNotebooksPage(wd, true);
	}

	// Method to click the EditYourAccountInfo Link
	public MyAccountInfoPage clickEditYourAccountInfoLink() {
		((ProxyDriver) wd).click(editAccountInfoLink);
		return new MyAccountInfoPage(wd, true);
	}

	public AddressBookPage clickAddressBookLink() {
		((ProxyDriver) wd).click(addressBookLink);
		return new AddressBookPage(wd, true);
	}

	@Override
	protected void isLoaded() {
		// TODO Auto-generated method stub

	}

}
