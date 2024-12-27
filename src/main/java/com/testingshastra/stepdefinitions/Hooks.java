package com.testingshastra.stepdefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.testingshastra.base.Keyword;
import com.testingshastra.utils.App;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	private static final Logger LOG = Logger.getLogger(Hooks.class);
	public RemoteWebDriver driver; // static variable

	public ThreadLocal<WebDriver> thread = new ThreadLocal<WebDriver>();

	@Before
	public void setUp() throws Exception {
		this.driver = Keyword.openBrowser(App.getBrowserName());
		Keyword.launchUrl(App.getAppUrl("qa"));
		LOG.info("Browser and Url is launched");
		thread.set(driver);
	}

	@After
	public void tearDown() throws Exception {
		Keyword.driver.quit();
		LOG.info("Browser is closed successfully..!");
		thread.get().quit();
	}
}
