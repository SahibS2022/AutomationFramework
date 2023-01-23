package com.naveenautomation.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naveenautomation.Browsers.ProxyDriver;

public class AddressBookPage extends Page {

	public AddressBookPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By cityInputField = By.id("input-city");
	private static final By continueBtn = By.cssSelector("input[type='submit']");
	private static final By successBannerUpdate = By.cssSelector("div.alert-success");

	public void clickToUpdateAddressBookForSelectedCustomer(String customerName, By locator) {
		getElementFromTheTable(customerName).findElement(locator).click();
	}

	public String getSuccessBannerUpdateText() {
		return ((ProxyDriver) wd).getText(successBannerUpdate);
	}

	public void updateCityForSelectedCustomer(String city) {
		((ProxyDriver) wd).clear(cityInputField);
		((ProxyDriver) wd).sendKeys(cityInputField, city);
		((ProxyDriver) wd).submit(continueBtn);
	}

	public void deleteSelectedCustomer() {
//		((ProxyDriver) wd).switchToAlert();
		((ProxyDriver) wd).acceptAlert();
	}

	public WebElement getElementFromTheTable(String customerName) {

		List<WebElement> rowsInTable = ((ProxyDriver) wd)
				.findElements(By.cssSelector("div.table-responsive table tbody tr"));
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

	@Override
	protected void isLoaded() {
		// TODO Auto-generated method stub

	}

}
