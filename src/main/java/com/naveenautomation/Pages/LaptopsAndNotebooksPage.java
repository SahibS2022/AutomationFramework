package com.naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.naveenautomation.Base.TestBase;

public class LaptopsAndNotebooksPage extends TestBase {
	Actions action;

	public LaptopsAndNotebooksPage() {
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
	}

	@FindBy(xpath = "//h2[text()='Laptops & Notebooks']")
	WebElement laptopsAndNotebooksText;

	@FindBy(css = "select[id='input-sort']")
	WebElement sortBySelectBox;

	@FindBy(css = "div.row:nth-of-type(4)>div.product-layout.product-grid:first-of-type button:nth-of-type(2)")
	WebElement firstProductAddToWishListBtn;

	@FindBy(css = "div.row:nth-of-type(4)>div.product-layout.product-grid:nth-of-type(2) button:nth-of-type(2)")
	WebElement secondProductAddToWishListBtn;

	@FindBy(css = "button[onclick=\"wishlist.add('44');\"]")
	WebElement thirdProductAddToWishListBtn;

	@FindBy(css = "#wishlist-total")
	WebElement wishListLink;

	@FindBy(css = "div.alert-success")
	WebElement productAddedScucessBanner;

	public String getLaptopsAndNotebooksText() {
		return laptopsAndNotebooksText.getText();
	}

	public String getProductAddedSuccessMessage() {
		return productAddedScucessBanner.getText();
	}

	public void clickFirstAddToWishListButton() {
		firstProductAddToWishListBtn.click();
	}

	public void clickSecondAddToWishListButton() {
		secondProductAddToWishListBtn.click();
	}

	public void clickThirdAddToWishListButton() {
		thirdProductAddToWishListBtn.click();
	}

	public MyWishListPage clickOnWishListLink() {
		wishListLink.click();
		return new MyWishListPage();

	}

	// Method to select element by visible text
	public void selectRatingHighestByVisibleText() {
		Select sc = new Select(sortBySelectBox);
		sc.selectByVisibleText("Rating (Highest)");
	}
}
