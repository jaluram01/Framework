package com.qa.mobile.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.base.MobileBaseTest;
import com.qa.pages.mobile.HomePage;

public class MobileTestCase1 extends MobileBaseTest {
	HomePage home;
	String appTitle = "selendroid-test-app";
	
	@Test(testName= "Verify User Title Test", enabled = true, priority = 1)
	public void verifyUserTitle() {
		home = new HomePage(appiumDriver);
		
		reporter.info("Verifying home tab title");
		Assert.assertEquals(home.getTitle(), appTitle, "Test Failed:: Title is not as expected");
	}
	
	@Test(testName = "Verify Elements Test", enabled = true, priority = 2)
	public void userVerifyElementsOnApplication() {
		home = new HomePage(appiumDriver);
		home = new HomePage(appiumDriver);
		
		reporter.info("Verifying Test Button");
		Assert.assertTrue(home.getTestBtn().isDisplayed(), "Test Failed:: Test Btn is not present");
		
		reporter.info("Verifying Text Field");
		Assert.assertTrue(home.getTextField().isDisplayed(),"Test Failed:: Text Field is not present");
		
		reporter.info("Verifying Show Progress bar Button");
		Assert.assertTrue(home.getProgressBar().isDisplayed(),"Test Failed:: Show Progress Bar is not present");
		
		reporter.info("Verifying Show Toast Button");
		Assert.assertTrue(home.getDisplayToastBtn().isDisplayed(),"Test Failed:: Toast Display is not present");
		
		reporter.info("Verifying Show Display view Button");
		Assert.assertTrue(home.getDisplayTestView().isDisplayed(),"Test Failed:: Test View Display is not present");
		
	}
}
