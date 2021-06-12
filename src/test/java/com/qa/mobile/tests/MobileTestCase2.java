package com.qa.mobile.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.base.MobileBaseTest;
import com.qa.pages.mobile.HomePage;

public class MobileTestCase2 extends MobileBaseTest {
	HomePage home;

	@Test(testName = "Verify Button Screen Test", enabled = true)
	public void clickEN_BtnAndVerify() {
		home = new HomePage(appiumDriver);
		
		home.clickEN_Btn();
		reporter.info("Clicked on EN Button");
		
		reporter.info("Waiting for message");
		home.waitForMsg();
		
		home.clickNoBtn();
		reporter.info("Clicked on No Button");
		
		reporter.info("Verifying Home Page Title");
		Assert.assertTrue(home.homeTitleElement().isDisplayed());
	}
}
