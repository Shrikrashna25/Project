package com.testingshastra.stepdefinitions;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.google.common.collect.Multiset.Entry;
import com.testingshastra.base.Keyword;
import com.testingshastra.pages.HomePage;
import com.testingshastra.pages.StorePage;
import com.testingshastra.utils.App;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class First {
	private static final Logger LOG = Logger.getLogger(First.class);

	@Given("Browser is opend and app url is launched")
	public void browserIsOpenedAndAppUrlLaunched() throws MalformedURLException {
		Keyword.openBrowser(App.getBrowserName());
		Keyword.launchUrl(App.getAppUrl("qa"));
	}

	@When("User hovers on Kids Menu")
	public void hoverOnKidsMenu() throws InterruptedException {
		HomePage homepage = new HomePage();
		homepage.hoverOnKidsMenu();
		homepage.waitForFlyout();
		homepage.clickOnFlyoutMenuItem("T-Shirts");
		LOG.info("Clicked on T-Shirts Menu");
	}

	@And("Click on T-Shirt")
	public void clickOnTShirt() throws InterruptedException {
		HomePage homepage = new HomePage();

	}

	@Then("Wait for T-Shirt page to launch")
	public void waitForTShirtsPage() {
		StorePage storepage = new StorePage();
		storepage.waitForTShirtsCategoryToBeClickable();
	}

	@And("Verify the category count and title count to be equal")
	public void verifyCatCountAndTitleCount() {
		StorePage storepage = new StorePage();
		String titleCount = storepage.getTitleCount();
		String categoryCount = storepage.getCategoryCount();
		Assert.assertEquals(titleCount, categoryCount, "Title count and Category count are not same");
	}

	int x, y, result = 0;

	@Given("I have numbers {int} and {int}")
	public void acceptNumbers(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@When("I add them")
	public void addNumbers() {
		result = x + y;
	}

	@Then("verify if result is prime")
	public void checkIfAdditionIsPrime() {
		int count = 1;
		for (int i = 2; i < result / 2; i++) {
			if (result % i == 0) {
				count++;
				if (count >= 2) {
					break;
				}
			}
		}

		if (count >= 2) {
			System.out.println(result + " is NOT Prime");
		} else {
			System.out.println(result + " is Prime");
		}
	}

	Map<String, List> fruits;

	@Given("I have following fruits:")
	public void accpetListOfFruits(DataTable fruits) {
		this.fruits = fruits.asMap(String.class, List.class);
	}

	@Then("print them one by one")
	public void printFruitList() {
		for (Map.Entry<String, List> fruit : fruits.entrySet()) {
			System.err.println(fruit.getKey() + "=" + fruit.getValue());
		}
		System.out.println("=====================================");
	}

	public void collectionOfCollection() {
		ArrayList fname = new ArrayList();

		fname.add("Shreya");
		fname.add("Shekhar");
		fname.add("Gita");
		fname.add("Rupali");
		fname.add("Yash");

		ArrayList lname = new ArrayList();
		lname.add("Mote");
		lname.add("Ghorwade");
		lname.add("Kumbhar");
		lname.add("Mahajan");
		HashMap<Integer, ArrayList> m = new HashMap<Integer, ArrayList>();

		m.put(1, fname);
		m.put(2, lname);

	}

	String pincode;

	@Given("I have {string}")
	public void acceptPincode(String pincode) {
		this.pincode = pincode;
	}

	@Then("print the pincode")
	public void printPinCode() {
		System.err.println(this.pincode);
	}

}
