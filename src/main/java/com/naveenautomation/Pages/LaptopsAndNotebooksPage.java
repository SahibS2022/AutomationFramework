package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.naveenautomation.Browsers.ProxyDriver;

public class LaptopsAndNotebooksPage extends Page {
	Actions action;

	public LaptopsAndNotebooksPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
		action = new Actions(wd);
	}

	private static final By laptopsAndNotebooksText = By.xpath("//h2[text()='Laptops & Notebooks']");
	private static final By sortBySelectBox = By.cssSelector("select[id='input-sort']");
	private static final By firstProductAddToWishListBtn = By
			.cssSelector("div.row:nth-of-type(4)>div.product-layout.product-grid:first-of-type button:nth-of-type(2)");
	private static final By secondProductAddToWishListBtn = By
			.cssSelector("div.row:nth-of-type(4)>div.product-layout.product-grid:nth-of-type(2) button:nth-of-type(2)");
	private static final By thirdProductAddToWishListBtn = By
			.cssSelector("div.row:nth-of-type(4)>div.product-layout.product-grid:nth-of-type(3) button:nth-of-type(2)");
	private static final By wishListLink = By.id("wishlist-total");
	private static final By productAddedScucessBanner = By.cssSelector("div.alert-success");

	public String getLaptopsAndNotebooksText() {
		return ((ProxyDriver) wd).getText(laptopsAndNotebooksText);
	}

	public String getProductAddedSuccessMessage() {
		return ((ProxyDriver) wd).getText(productAddedScucessBanner);
	}

	public void clickFirstAddToWishListButton() {
		((ProxyDriver) wd).click(firstProductAddToWishListBtn);
	}

	public void clickSecondAddToWishListButton() {
		((ProxyDriver) wd).click(secondProductAddToWishListBtn);
	}

	public void clickThirdAddToWishListButton() {
		((ProxyDriver) wd).click(thirdProductAddToWishListBtn);
	}

	public MyWishListPage clickOnWishListLink() {
		((ProxyDriver) wd).click(wishListLink);
		return new MyWishListPage(wd, true);

	}

	// Method to select element by visible text
	public void selectRatingHighestByVisibleText() {
		((ProxyDriver) wd).selectFromDropDownByVisibleText(sortBySelectBox, "Rating (Highest)");
	}

	@Override
	protected void isLoaded() {
		// TODO Auto-generated method stub

	}
}
