package com.naveenautomation.Browsers;

import java.net.URL;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProxyDriver implements WebDriver, JavascriptExecutor, TakesScreenshot {

	private static final int DEFAULT_TIME_FOR_SELENIUM_ACTIONS = 30;
	private WebDriver driver;

	public ProxyDriver(WebDriver wd) {
		this.driver = wd;

	}

	public String getText(By Locator) {
		return this.getText(Locator, DEFAULT_TIME_FOR_SELENIUM_ACTIONS);
	}

	public void click(By locator) {
		this.waitForElementToBeClickable(locator, DEFAULT_TIME_FOR_SELENIUM_ACTIONS).click();
	}

	public Object executeScript(String script, Object... args) {
		return ((JavascriptExecutor) driver).executeScript(script, args);
	}

	public Object executeAsyncScript(String script, Object... args) {
		// TODO Auto-generated method stub
		return null;
	}

	public void get(String url) {
		ProxyDriver.this.driver.get(url);

	}

	public String getCurrentUrl() {
		return ProxyDriver.this.driver.getCurrentUrl();
	}

	public String getTitle() {
		return ProxyDriver.this.driver.getTitle();
	}

	public List<WebElement> findElements(By by) {
		return ProxyDriver.this.driver.findElements(by);
	}

	public WebElement findElement(By by) {
		return ProxyDriver.this.driver.findElement(by);
	}

	public String getPageSource() {
		return ProxyDriver.this.driver.getPageSource();
	}

	public void close() {
		driver.close();

	}

	public void quit() {
		driver.quit();

	}

	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}

	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	public TargetLocator switchTo() {
		// TODO Auto-generated method stub
		return null;
	}

	public Navigation navigate() {
		return new Navigation() {

			public void to(URL url) {
				ProxyDriver.this.driver.navigate().to(url);

			}

			public void to(String url) {
				ProxyDriver.this.driver.navigate().to(url);

			}

			public void refresh() {
				ProxyDriver.this.driver.navigate().refresh();

			}

			public void forward() {
				ProxyDriver.this.driver.navigate().forward();

			}

			public void back() {
				ProxyDriver.this.driver.navigate().back();

			}
		};
	}

	public String getText(By locator, int waitforElementToBeVisibleInSeconds) {
		try {

			WebElement element = this.waitForElementToBeVisible(locator, waitforElementToBeVisibleInSeconds);
			return element.getText().trim();
		} catch (NullPointerException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Options manage() {
		return driver.manage();
	}

	public void sendKeys(By by, String keysInput) {
		new WebDriverWait(driver, DEFAULT_TIME_FOR_SELENIUM_ACTIONS)
				.until(ExpectedConditions.visibilityOf(driver.findElement(by))).sendKeys(keysInput);
	}

	public String getAttribute(By by, String attribute) {
		return new WebDriverWait(driver, DEFAULT_TIME_FOR_SELENIUM_ACTIONS)
				.until(ExpectedConditions.visibilityOf(driver.findElement(by))).getAttribute(attribute);
	}

	public void clear(By by) {
		new WebDriverWait(driver, DEFAULT_TIME_FOR_SELENIUM_ACTIONS)
				.until(ExpectedConditions.visibilityOf(driver.findElement(by))).clear();
	}

	public boolean isDisplayed(By by) {
		try {
			waitForElementToBeVisible(by, DEFAULT_TIME_FOR_SELENIUM_ACTIONS);
			return this.findElement(by).isDisplayed();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	public boolean isEnabled(By by) {
		try {
			waitForElementToBeVisible(by, DEFAULT_TIME_FOR_SELENIUM_ACTIONS);
			return this.findElement(by).isEnabled();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	/*
	 * public void selectFromDropDown(WebElement element, String value) {
	 * waitForElementToBeSelectable(element); Select sc = new Select(element); try {
	 * sc.selectByValue(value); } catch (Exception e) {
	 * sc.selectByVisibleText(value); } }
	 */

	public void selectFromDropDownByVisibleText(By by, String value) {
		Select sc = new Select(driver.findElement(by));
		sc.selectByVisibleText(value);
	}

	public void switchToNewTab(By element) {
		String parentHandle = this.getWindowHandle();
		waitForElementToBeClickable(element, 5);

		Set<String> allWindowHandles = this.getWindowHandles();
		for (String windowHandle : allWindowHandles) {
			if (!windowHandle.equals(parentHandle)) {
				this.switchTo().window(windowHandle);
			}
		}

	}

//	public void switchToAlert() {
//		
//	}

	public void acceptAlert() {
		//new WebDriverWait(this, 10).until(ExpectedConditions.alertIsPresent());
		this.driver.switchTo().alert().accept();
	}
	
//	public void actionMoveToElement(By by, Actions action) {
//		action.mov
//	}

	public void dismissAlert() {
		new WebDriverWait(this, 10).until(ExpectedConditions.alertIsPresent()).dismiss();
	}

	public WebElement waitForElementToBeClickable(By locator, int timeOutInSeconds) {
		return new WebDriverWait(this, timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(locator));
	}

	public WebElement waitForElementToBeVisible(By Locator, int timeOutInSeconds) {
		return new WebDriverWait(this, timeOutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(Locator));
	}

	public void waitForElementToBeSelectable(By by) {
		new WebDriverWait(this, DEFAULT_TIME_FOR_SELENIUM_ACTIONS)
				.until(ExpectedConditions.elementSelectionStateToBe(by, true));
	}

	@Override
	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		// TODO Auto-generated method stub
		return ((TakesScreenshot) driver).getScreenshotAs(target);
	}

	public void submit(By by) {
		WebElement element = this.waitForElementToBeClickable(by, 10);
		element.submit();
	}

}
