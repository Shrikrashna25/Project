package com.testingshastra.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testingshastra.base.Keyword;
import com.testingshastra.utils.Format;
import com.testingshastra.utils.WaitFor;

public class StorePage {
	@FindBy(xpath = "(//a[@href=\"/shop/kids\"]/parent::div/descendant::ul[@class=\"desktop-navBlock\"])[1]/li[2]/a")
	private WebElement tShirtsMenu;
	
	@FindBy(xpath = "//span[@class=\"title-count\"]")
	private WebElement titleCount;
	
	@FindBy(xpath = "//span[text()='Categories']/parent::div/descendant::li[1]/label/span")
	private WebElement categoryCount;

	public StorePage() {
		PageFactory.initElements(Keyword.driver, this);
	}
	public void waitForTShirtsCategoryToBeClickable() {
		WaitFor.elementToBeClickable(tShirtsMenu);
	}
	
	public String getTitleCount() {
		String titleCnt = titleCount.getText();
		int count = Format.extractNumberFrom(titleCnt);
		return count+"";
	}
	
	public String getCategoryCount() {
		String categoryCnt = categoryCount.getText();
		int count = Format.extractNumberFrom(categoryCnt);
		return count+"";
	}
}
