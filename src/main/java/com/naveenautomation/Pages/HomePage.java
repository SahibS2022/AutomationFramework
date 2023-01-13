package com.naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.TestBase;

public class HomePage extends TestBase {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a[title='My Account']")
	WebElement myAccountLink;

	@FindBy(xpath = "//a[text()='Register']")
	WebElement registerLink;

	@FindBy(xpath = "//a[text()='Login']")
	WebElement loginLink;

	public void clickOnMyAccount() {
		myAccountLink.click();
	}

	public RegisterAccountPage clickOnRegister() {
		registerLink.click();
		return new RegisterAccountPage();
	}

	public AccountLoginPage clickOnLogin() {
		loginLink.click();
		return new AccountLoginPage();
	}

	public String getHomePageTitle() {
		return driver.getTitle();
	}

}
