package com.testingshastra.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.testingshastra.base.TestBase;

public class TestCaseOrangeHRM {

	@Test
	public void toVerifyLogin() {

		ChromeDriver driver = new ChromeDriver();

		try {

			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().window().maximize();

			// Define an explicit wait
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			// Wait for the username field to be visible
			WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
			usernameField.sendKeys("Admin");

			// Wait for the password field to be visible and input password
			WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
			passwordField.sendKeys("admin123");

			// Wait for the login button to be clickable and then click
			WebElement loginButton = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
			loginButton.click();

			// Wait for the dashboard or confirmation element to verify successful login
			WebElement dashboardElement = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Dashboard']")));

			// Assert that the dashboard is displayed
			Assert.assertTrue(dashboardElement.isDisplayed(), "Login failed: Dashboard not displayed");

			System.out.println("Login functionality verified successfully!");

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test failed due to an exception: " + e.getMessage());
		} finally {

			// driver.quit();
		}
	}

	@Test
	public void veriFyingMyLeaves() {
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement User = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Username")));
		User.sendKeys("Admin");
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		password.sendKeys("admin123");
		WebElement loginButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
		loginButton.click();
		WebElement Leave = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title=\\\"My Leave\\\"]")));
		Leave.click();

	}

}
