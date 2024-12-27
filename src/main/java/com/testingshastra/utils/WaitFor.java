package com.testingshastra.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testingshastra.base.Keyword;

public class WaitFor {

	private static WebDriverWait wait = null;

	static {
		wait = new WebDriverWait(Keyword.driver, Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofMillis(500));
		wait.ignoring(NoSuchElementException.class);
	}

	/**
	 * @author Framework Architect
	 * @param locator
	 */
	public static void elementToBeClickable(String locator) {
		WebElement element = Keyword.getWebElement(locator);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void elementToBePresent(String locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(Keyword.getBy(locator))); // By class object
	}

	public static void elementNotToBeStale(String locator) {
		WebElement element = Keyword.getWebElement(locator);
		wait.until(ExpectedConditions.stalenessOf(element));
	}

	public static void elementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
