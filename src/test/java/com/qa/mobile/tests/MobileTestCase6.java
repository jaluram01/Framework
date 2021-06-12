package com.qa.mobile.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.MobileBaseTest;
import com.qa.pages.mobile.HomePage;

import io.appium.java_client.MobileElement;

public class MobileTestCase6 extends MobileBaseTest {
	HomePage homePage;

	@Test(testName = "Show Toast Messgae Test", enabled = true)
	public void clickToastBtnAndVerifyToastText() {
		homePage = new HomePage(appiumDriver);
		homePage.getDisplayToastBtn().click();
		reporter.info("Clicked on show Toast button");
		
		reporter.info("Verifying the Toast message");
		MobileElement toastTxt = appiumDriver.findElement(By.xpath("//*[contains(text(),'Hello Selendroid')]"));
		Assert.assertEquals(toastTxt, "Hello Selendroid toast!");
	}
}
