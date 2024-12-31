package com.testingshastra.testcases;

import java.sql.Driver;
import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.testingshastra.base.Keyword;
import com.testingshastra.base.TestBase;
import com.testingshastra.locators.Locator;
import com.testingshastra.pages.HomePage;
import com.testingshastra.pages.StorePage;
import com.testingshastra.utils.Format;
import com.testingshastra.utils.WaitFor;

public class ProductTest extends TestBase {
	@Test(description = "Goto T shirt page and verify T shirt count")
	public void verifyCountofItemsForKidsTshirt() throws Exception {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.pollingEvery(Duration.ofMillis(500));
		Actions act = new Actions(driver);
		WebElement KidsMenu = driver.findElement(By.xpath("//a[@href=\"/shop/kids\"]"));
		act.moveToElement(KidsMenu).perform();
		By Tshirt = By.xpath("//a[@href=\"/shop/kids\"]/parent::div/descendant::ul/li[2]/a");
		wait.until(ExpectedConditions.elementToBeClickable(Tshirt));
		driver.findElement(Tshirt).click();
		By titleCnt = (By.xpath("//span[@class=\"title-count\"]"));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(titleCnt));
		String titleCountInTxt = driver.findElement(titleCnt).getText();
		System.out.println(titleCountInTxt);

		String categoryCountInTxt = driver.findElement(By.xpath("(//span[@class=\"categories-num\"])[1]")).getText();
		System.out.println(categoryCountInTxt);

		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(titleCountInTxt);
		int titleCount = 0;
		while (m.find()) {
			titleCount = Integer.parseInt(m.group());
		}
		m = p.matcher(categoryCountInTxt);
		int CatCount = 0;
		while (m.find()) {
			CatCount = Integer.parseInt(m.group());
		}
		Assert.assertEquals(titleCount, CatCount, "title count and cat count not same");
		driver.quit();
	}

	@Test // Test case using Framework
	public void verifyCountofItemForKidsTshirtUsingFramwork() {
		Keyword.hoverOn(Locator.kidsMenu);
		try {
			WaitFor.elementToBeClickable(Locator.tShrts);
		} catch (StaleElementReferenceException e) {
			WaitFor.elementNotToBeStale(Locator.tShrts);
		}
		Keyword.clickOn(Locator.tShrts);
		WaitFor.elementToBePresent(Locator.titleCnt);
		String TitleCountInTxt = Keyword.getTextOf(Locator.titleCnt);
		int titleCount = Format.extractNumberFrom(TitleCountInTxt);
		String categoryCountInTxt = Keyword.getTextOf(Locator.categoryCnt);
		int categoryCount = Format.extractNumberFrom(categoryCountInTxt);
		Assert.assertEquals(titleCount, categoryCount, "Title count and category count are not same");

	}

	@Test /// Test case using Page Object Model
	public void verifyCountOfItemsForKidsTShirtUsingPom() throws InterruptedException {

		HomePage homepage = new HomePage();
		homepage.hoverOnKidsMenu();

		homepage.waitForFlyout();
		homepage.clickOnFlyoutMenuItem("T-Shirt");
		StorePage storepage = new StorePage();
		storepage.waitForTShirtsCategoryToBeClickable();
		String titleCount = storepage.getTitleCount();
		String categoryCount = storepage.getCategoryCount();
		Assert.assertEquals(titleCount, categoryCount, "Title count and category count are not same");

	}

	@Test // To verifying Download Ebooks
	public void verifyDownloadEbooks() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.pollingEvery(Duration.ofMillis(500));
		Actions act = new Actions(driver);
		WebElement resources = driver.findElement(By.xpath("(//a[@class=\"nav-link-hed\"])[3]"));
		act.moveToElement(resources).perform();
		By eBook = By.xpath("//a[@href=\"/en/resources/e-books\"]");
		wait.until(ExpectedConditions.elementToBeClickable(eBook));
		driver.findElement(eBook).click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement Download = driver.findElement(By.xpath("//a[@href=\"/en/resources/e-books/thefutureofhr\"]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(Download).perform();
		Download.click();
		System.out.println("Download click");
		driver.findElement(By.xpath("//input[@type=\"email\"]")).sendKeys("gutte6015@gmail.com", Keys.ENTER);
		System.out.println("mail id enter");
		WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(60));
		driver.findElement(By.xpath("//input[@id=\"Form_getForm_FullName\"]")).sendKeys("Shrikrashna", Keys.ENTER);
		driver.findElement(By.xpath("//select[@name=\"Country\"]")).click();
		driver.findElement(By.xpath("//option[@value=\"India\"]")).click();
		driver.findElement(By.xpath("//div[@class=\"recaptcha-checkbox-checkmark\"]")).click();
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		System.out.println("Submit button click");
		driver.quit();

	}

}
