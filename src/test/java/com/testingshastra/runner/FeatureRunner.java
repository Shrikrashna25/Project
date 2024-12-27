package com.testingshastra.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@Runwith(Cucumber.class) //JUnit
@CucumberOptions(features = "src/test/resources/Features",
glue = "com.testingshastra.stepdefinitions",
dryRun = false,
plugin = {
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
})
public class FeatureRunner extends AbstractTestNGCucumberTests{

	
	@DataProvider(parallel = true)
	@Override
	public Object[][] scenarios() {
		
		return super.scenarios();
	}
}
