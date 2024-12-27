package com.testingshastra.locators;

public interface Locator {

	String kidsMenu = "xpath##//a[@href=\"/shop/kids\"]";
	String tShrts = "xpath##(//a[@href=\"/shop/kids\"]/parent::div/descendant::ul[@class=\"desktop-navBlock\"])[1]/li[2]/a";
	String newLocator = "id##456";
	String titleCnt = "xpath##//span[@class=\"title-count\"]";
	String categoryCnt = "xpath##//span[text()='Categories']/parent::div/descendant::li[1]/label/span";
}
