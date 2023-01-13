package com.naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.TestBase;

public class MyAccountPage extends TestBase {
	Actions action;

	public MyAccountPage() {
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
	}

	@FindBy(xpath = "//a[text() = 'Laptops & Notebooks']")
	WebElement laptopsAndNotebooksLink;

	@FindBy(xpath = "//a[text() = 'Show All Laptops & Notebooks']")
	WebElement showAllLaptopsAndNotebooksLink;

	@FindBy(css = "#column-right a:nth-of-type(4)")
	WebElement addressBookLink;

	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement myAccountText;

	@FindBy(css = "#column-right a:nth-of-type(3)")
	WebElement changePasswordLink;

	@FindBy(xpath = "//a[text()='Edit your account information']")
	WebElement editAccountInfoLink;

	@FindBy(xpath = "//a[text()='Subscribe / unsubscribe to newsletter']")
	WebElement subscribeOrUnsubscribeToNewsletterLink;

	@FindBy(css = "aside#column-right a:last-of-type")
	WebElement logoutLink;

	@FindBy(css = "div.alert-success")
	WebElement passwordChangesSuccessBanner;

	@FindBy(css = "div.alert-success")
	WebElement telephoneChangesSuccessBanner;

	@FindBy(css = "div.alert-success")
	WebElement newsletterSubscriptionSuccessBanner;

	// Method to get the MyAccountPage Title
	public String getMyAccountText() {
		return myAccountText.getText();
	}

	public String getMyAccountPageTitle() {
		return driver.getTitle();
	}

	public void actionMoveTolaptopsAndNotebooksLink() {
		action.moveToElement(laptopsAndNotebooksLink).perform();
	}

	public String getTelephoneChangesSuccessMessage() {
		return telephoneChangesSuccessBanner.getText();
	}

	public String getNewsletterSubscriptionSuccessMessage() {
		return newsletterSubscriptionSuccessBanner.getText();
	}

	public NewsletterSubscriptionPage clickSubscribeOrUnsubscribeNewsletterLink() {
		subscribeOrUnsubscribeToNewsletterLink.click();
		return new NewsletterSubscriptionPage();
	}

	public AccountLogoutPage clickLogoutLink() {
		logoutLink.click();
		return new AccountLogoutPage();
	}

	public LaptopsAndNotebooksPage clickShowAllLaptopsAndNoteBooksLink() {
		showAllLaptopsAndNotebooksLink.click();
		return new LaptopsAndNotebooksPage();
	}

	// Method to click the EditYourAccountInfo Link
	public MyAccountInfoPage clickEditYourAccountInfoLink() {
		editAccountInfoLink.click();
		return new MyAccountInfoPage();
	}

	public AddressBookPage clickAddressBookLink() {
		addressBookLink.click();
		return new AddressBookPage();
	}

}
