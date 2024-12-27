package com.testingshastra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testingshastra.base.Keyword;
import com.testingshastra.utils.WaitFor;

public class HomePage {

	@FindBy(xpath="//a[@href=\"/shop/kids\"]")
	private WebElement kidsMenu; 
	
	@FindBy(xpath = "//div[@class=\"desktop-backdropStyle\"]")
	private WebElement flyout; 
	
	
	public HomePage() {
		PageFactory.initElements(Keyword.driver,this);
	}
	
	public void hoverOnKidsMenu() {
		Keyword.hoverOn(kidsMenu);
	}
	
	public void waitForFlyout() {
		WaitFor.elementToBeClickable(flyout);
	}
	
	public void clickOnFlyoutMenuItem(String itemName) {
		flyout.findElement(By.xpath("//*[contains(text(),'"+itemName+"')]")).click();
	}
	
}
