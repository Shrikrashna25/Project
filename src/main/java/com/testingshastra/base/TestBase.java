package com.testingshastra.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.testingshastra.utils.App;


/**
 * This class is no longer in use. Instead you can use {@code Hooks}
 * class as we are writing test cases in Cucumber.
 */
public class TestBase {

	@BeforeMethod
	public void setUp() throws Exception {
		Keyword.openBrowser(App.getBrowserName());
		Keyword.launchUrl(App.getAppUrl("qa"));
		System.out.println("Browser and Url is launched");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Keyword.driver.quit();
	}
}
