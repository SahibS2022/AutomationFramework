package com.naveenautomation.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naveenautomation.Browsers.ProxyDriver;

public class MyWishListPage extends Page {

	public MyWishListPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final By successBannerForProductDeleted = By.cssSelector("div.alert-success");

	public void removeProduct(String productName, MyWishList column, By locator) {
		getElementFromTheTable(productName, column).findElement(locator).click();
	}

	public String getTextForProductDeletedSuccessfully() {
		return ((ProxyDriver) wd).getText(successBannerForProductDeleted);
	}

	public String getMyWishListPageTitle() {
		return ((ProxyDriver) wd).getTitle();
	}

	public WebElement getElementFromTheTable(String ProductName, MyWishList column) {

		int columnIndex = getIndexForColumn(column);
		List<WebElement> rowsInTable = wd.findElements(By.cssSelector("table.table tbody tr"));
		for (WebElement webElement : rowsInTable) {
			List<WebElement> cells = webElement.findElements(By.cssSelector("td"));
			String productName = cells.get(1).getText();
			if (productName.equals(ProductName)) {
				return cells.get(columnIndex);
			}
		}
		System.out.println("Column name was not found!!!");
		return null;
	}

	public int getIndexForColumn(MyWishList column) {
		List<WebElement> tableHeaders = wd.findElements(By.cssSelector("table.table thead tr td"));
		for (WebElement webElement : tableHeaders) {
			if (webElement.getText().equals(column.getName())) {
				return tableHeaders.indexOf(webElement);
			}
		}
		System.out.println("column does not exist");
		return -1;
	}

	public enum MyWishList {

		IMAGE("Image"), PRODUCTNAME("Product Name"), MODEL("Model"), STOCK("Stock"), UNITPRICE("Unit Price"),
		ACTION("Action");

		String name;

		private MyWishList(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

	}

	@Override
	protected void isLoaded() {
		// TODO Auto-generated method stub

	}

}
