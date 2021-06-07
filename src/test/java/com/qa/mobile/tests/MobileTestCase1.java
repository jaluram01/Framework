package com.qa.mobile.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.base.MobileBaseTest;
import com.qa.pages.mobile.HomePage;

public class MobileTestCase1 extends MobileBaseTest {
	HomePage home;

	@Test
	public void userUerifiesTitle() {
		home = new HomePage(appiumDriver);
		Assert.assertEquals(home.getTitle(), "selendroid-test-app", "Verifying Title");
	}
	
	@Test
	public void userVerifyElementsOnApplication() {
		home = new HomePage(appiumDriver);
		Assert.assertEquals(home.getTestBtn().isDisplayed(), true,"Verifying Test Btn");
		Assert.assertEquals(home.getTextField().isDisplayed(), true,"Verifying Text Field");
		Assert.assertEquals(home.getProgressBar().isDisplayed(), true,"Verifying Progress Bar");
		Assert.assertEquals(home.getDisplayToast().isDisplayed(), true,"Verifying Toast Display");
		Assert.assertEquals(home.getDisplayTestView().isDisplayed(), true,"Verifying Test View Display");
	}
}
