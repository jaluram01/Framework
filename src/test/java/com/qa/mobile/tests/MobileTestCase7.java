package com.qa.mobile.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.MobileBaseTest;
import com.qa.pages.mobile.HomePage;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class MobileTestCase7 extends MobileBaseTest {
	HomePage homePage;

	@Test(testName = "Popup functionality Test", enabled = true)
	public void clickonDisplayPopupAndDismiss() {
		try {
			homePage = new HomePage(appiumDriver);
			
			homePage.getShowPopupWindowButton().click();
			reporter.info("Clicked on show popup button");
			
			new TouchAction<>(appiumDriver).tap(PointOption.point(600, 1100)).perform();
			reporter.info("Clicked on Dismiss button");
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test Failed :: Unable to Dismiss pop-up");
		}
	}
}
