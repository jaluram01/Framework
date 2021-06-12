package com.qa.mobile.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.base.MobileBaseTest;
import com.qa.pages.mobile.HomePage;

public class MobileTestCase9 extends MobileBaseTest {
	HomePage homePage;
	String testText = "test";

	@Test(testName = "Enter Text Exception Test", enabled = true)
	public void enterTextInExceptionFieldAndVerifyHomePageTitle() {
		try {
			homePage = new HomePage(appiumDriver);
			homePage.getExceptionTestField().sendKeys(testText);
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test Failed :: App Crashed");
		}
	}
}
