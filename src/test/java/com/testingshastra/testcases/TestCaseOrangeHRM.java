package com.testingshastra.testcases;



import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCaseOrangeHRM {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Initialize the WebDriver
        driver = new ChromeDriver();

        try {
            // Open the login page
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            driver.manage().window().maximize();

            // Explicit wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            // Perform login
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
            usernameField.sendKeys("Admin");

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
            passwordField.sendKeys("admin123");

            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
            loginButton.click();

            // Wait for the dashboard
            WebElement dashboardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Dashboard']")));
            Assert.assertTrue(dashboardElement.isDisplayed(), "Login failed: Dashboard not displayed");

            System.out.println("Login functionality verified successfully!");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Setup failed due to an exception: " + e.getMessage());
        }
    }

    @Test(priority = 1)
    public void verifyMyLeaves() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

            // Navigate to My Leave
            WebElement leaveMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Leave']")));
            leaveMenu.click();

            WebElement myLeaveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='My Leave']")));
            myLeaveButton.click();

            // Verify My Leave page
            WebElement leavePageHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='My Leave']")));
            Assert.assertTrue(leavePageHeader.isDisplayed(), "My Leave page not displayed");

            System.out.println("Successfully verified My Leave functionality.");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test 'verifyMyLeaves' failed due to: " + e.getMessage());
        }
    }

    @Test(priority = 2)
    public void verifyClaimStatus() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

            // Navigate to Claim Module
            WebElement claimMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Claim']")));
            claimMenu.click();

            // Verify Claim Status page
            WebElement claimPageHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Claims']")));
            Assert.assertTrue(claimPageHeader.isDisplayed(), "Claim Status page not displayed");

            System.out.println("Successfully verified Claim Status functionality.");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test 'verifyClaimStatus' failed due to: " + e.getMessage());
        }
    }
    
    @Test(priority=3)
    public void verifyTimeSheet() {
    	
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    	 WebElement Timehsheet = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title=\"Timesheets\"]")));
    	 Timehsheet.click();
    	
    	 
    	WebElement Employ= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder=\"Type for hints...\"]")));
    			Employ.sendKeys("rishan gohan gotenks");
    			Employ.click();
    			 System.out.println("Successfully verified Timesheet functionality");	
    			
    }

    @AfterMethod
    public void tearDown() {
        // Quit the browser
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed successfully.");
        }
    }
}
