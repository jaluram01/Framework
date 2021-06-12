package com.qa.mobile.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.MobileBaseTest;
import com.qa.pages.mobile.ChromeBrowserPage;
import com.qa.pages.mobile.HomePage;

public class MobileTestCase3 extends MobileBaseTest {
	// Adding Test data in class as scope of test data is considered low
	String name = "TestTest";
	String carName = "mercedes";
	String preferedCarDefaultValue = "Volvo";
	
	HomePage homePage;
	ChromeBrowserPage chromePage;

	@Test(testName ="Chrome Page Test", enabled = true)
	public void chromePageTest() {
		homePage = new HomePage(appiumDriver);
		homePage.getChromeLogoBtn().click();
		
		chromePage = new ChromeBrowserPage(appiumDriver);
		
		reporter.info("Verifying Web view Title");
		Assert.assertEquals(chromePage.getwebViewTitle(), "Web View Interaction");
		
		reporter.info("Verifying Hello, can you please tell me your name? text");
		Assert.assertEquals(chromePage.getHeaderText(), "Hello, can you please tell me your name?");
		
		reporter.info("Clearing name text field");
		chromePage.getNameTxtBox().clear();
		
		reporter.info("Entering name");
		chromePage.getNameTxtBox().sendKeys(name);
		
		reporter.info("Selecting prefered car");
		chromePage.selectOption(carName);
		
		chromePage.getSendMeNameBtn().click();
		reporter.info("Clicked on Send Me your name button");
		
		reporter.info("Verifying My way of saying hello text");
		Assert.assertTrue((chromePage.getMyWayOfSayingHelloText().isDisplayed()));
		
		reporter.info("Verifying submitted name with test data");
		Assert.assertTrue(chromePage.enteredNameText().contains(name),
				"Test Failed:: Your entered name is not matching");
		
		reporter.info("Verifying selected car");
		Assert.assertTrue(chromePage.getSelectedCarText().contains(carName),
				"Test Failed:: Your selected car is not matching");
		
		chromePage.clickOnclickHereLink();
		reporter.info("Clicked on click here link");
		
		reporter.info("Verifying prefered car default value");
		Assert.assertEquals(chromePage.getPreferedCarDropdownDefaultValue(), preferedCarDefaultValue,
				"Test Failed:: Prefered car default value is not matching");
	}
}
