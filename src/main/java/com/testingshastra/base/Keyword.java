package com.testingshastra.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.testingshastra.exceptions.InvalidBrowserNameException;
import com.testingshastra.utils.App;

public abstract class Keyword {
	public static RemoteWebDriver driver = null;
	private static final Logger LOG = Logger.getLogger(Keyword.class);

	public static RemoteWebDriver openBrowser(String browserName) throws MalformedURLException {
		boolean isOnGrid = App.isOnGrid();
		if (isOnGrid) {
			FirefoxOptions option = new FirefoxOptions();
			driver = new RemoteWebDriver(new URL("http://192.168.1.33:4444"),option);
		} else if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		} else {
			throw new InvalidBrowserNameException(browserName);
		}
		driver.manage().window().maximize();
		return driver;
	}

	public static void launchUrl(String url) {
		driver.get(url);
		LOG.info("Launched url: " + url);
	}

	public static void hoverOn(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		;
	}

	public static void hoverOn(String element) {
		Actions act = new Actions(driver);
		WebElement ele = getWebElement(element);
		act.moveToElement(ele).perform();
	}

	public static void enterText(String locator, String textToEnter) {
		getWebElement(locator).sendKeys(textToEnter);
	}

	public static By getBy(String locator) {
		By by = null;
		String locatorType = locator.split("##")[0];
		String locatorValue = locator.split("##")[1];
		if (locatorType.equalsIgnoreCase("id")) {
			by = By.id(locatorValue);
		} else if (locatorType.equalsIgnoreCase("name")) {
			by = By.name(locatorValue);
		} else if (locatorType.equalsIgnoreCase("className")) {
			by = By.className(locatorValue);
		} else if (locatorType.equalsIgnoreCase("tagName")) {
			by = By.tagName(locatorValue);
		} else if (locatorType.equalsIgnoreCase("linkText")) {
			by = By.linkText(locatorValue);
		} else if (locatorType.equalsIgnoreCase("partialLinkText")) {
			by = By.partialLinkText(locatorValue);
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			by = By.xpath(locatorValue);
		} else if (locatorType.equalsIgnoreCase("css")) {
			by = By.cssSelector(locatorValue);
		} else {

		}

		return by;
	}

	public static WebElement getWebElement(String locator) {
		String locatorType = locator.split("##")[0];
		String locatorValue = locator.split("##")[1];
		WebElement element = null;
		if (locatorType.equalsIgnoreCase("id")) {
			element = driver.findElement(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			element = driver.findElement(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("name")) {
			element = driver.findElement(By.name(locatorValue));
		} else if (locatorType.equalsIgnoreCase("className")) {
			element = driver.findElement(By.className(locatorValue));
		} else if (locatorType.equalsIgnoreCase("tagName")) {
			element = driver.findElement(By.tagName(locatorValue));
		} else if (locatorType.equalsIgnoreCase("linkText")) {
			element = driver.findElement(By.linkText(locatorValue));
		} else if (locatorType.equalsIgnoreCase("partialLinkText")) {
			element = driver.findElement(By.partialLinkText(locatorValue));
		} else if (locatorType.equalsIgnoreCase("css")) {
			element = driver.findElement(By.cssSelector(locatorValue));
		}
		return element;
	}

	public static void clickOn(String locator) {
		getWebElement(locator).click();

	}

	public static String getTextOf(String locator) {
		String value = null;
		value = getWebElement(locator).getText();
		return value;
	}
}
