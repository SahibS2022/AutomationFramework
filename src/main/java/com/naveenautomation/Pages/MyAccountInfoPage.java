package com.naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.TestBase;

public class MyAccountInfoPage extends TestBase {

	public MyAccountInfoPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[id = 'input-firstname']")
	WebElement firstNameInputField;

	@FindBy(css = "input[id = 'input-lastname']")
	WebElement lastNameInputField;

	@FindBy(css = "input[id = 'input-email']")
	WebElement emailInputField;

	@FindBy(css = "input[id = 'input-telephone']")
	WebElement telephoneInputField;

	@FindBy(css = "input[name='telephone']")
	WebElement telephone;

	@FindBy(css = "input[value='Continue']")
	WebElement continueBtn;

	public MyAccountPage updateUserTelephone() {
		telephone.clear();
		telephone.sendKeys("5146217769");
		continueBtn.submit();
		return new MyAccountPage();
	}

	// Method to get MyAccountInfo Page Title
	public String getMyAccountInfoPageTitle() {
		return driver.getTitle();
	}

	// Method to get FirstNameInputField value
	public String getFirstNameInputFieldValue() {
		return firstNameInputField.getAttribute("value");
	}

	// Method to get LastNameInputField value
	public String getLastNameInputFieldValue() {
		return lastNameInputField.getAttribute("value");
	}

	// Method to get EmailInputField value
	public String getEmailInputFieldValue() {
		return emailInputField.getAttribute("value");
	}

	// Method to getTelephoneInputFieild value
	public String getTelephoneInputFieldValue() {
		return telephoneInputField.getAttribute("value");
	}

}
