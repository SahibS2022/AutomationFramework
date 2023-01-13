package com.naveenautomation.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.TestBase;

public class AddressBookPage extends TestBase {
	public AddressBookPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#input-city")
	WebElement cityInputField;

	@FindBy(css = "input[type='submit']")
	WebElement continueBtn;

	@FindBy(css = "div.alert-success")
	WebElement successBannerUpdate;

	public void clickToUpdateAddressBookForSelectedCustomer(String customerName, By locator) {
		getElementFromTheTable(customerName).findElement(locator).click();
	}

	public String getSuccessBannerUpdateText() {
		return successBannerUpdate.getText();
	}

	public void updateCityForSelectedCustomer(String city) {
		cityInputField.clear();
		cityInputField.sendKeys(city);
		continueBtn.submit();
	}

	public void deleteSelectedCustomer() {
		driver.switchTo().alert().accept();
	}

	public WebElement getElementFromTheTable(String customerName) {

		List<WebElement> rowsInTable = driver.findElements(By.cssSelector("div.table-responsive table tbody tr"));
		for (WebElement webElement : rowsInTable) {
			List<WebElement> cells = webElement.findElements(By.cssSelector("td"));
			String data = cells.get(0).getText();
			int indexOfCustomerName = data.indexOf(customerName);
			if (indexOfCustomerName >= 0) {
				String name = data.substring(indexOfCustomerName, customerName.length());
				if (name.equals(customerName)) {
					return cells.get(1);
				}
			}

		}
		System.out.println("Customer name was not found!!!");
		return null;
	}

}
