package com.qa.mobile.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.MobileBaseTest;
import com.qa.pages.mobile.ChromeBrowserPage;

public class MobileTestCase3 extends MobileBaseTest{
	
	ChromeBrowserPage chromePage;

	@Test
	public void user_verifies_the_title() {
		chromePage = new ChromeBrowserPage(appiumDriver);
		String name = "TestTest";
		chromePage.tapChromeIconAndEnterDetails(name);
		Assert.assertTrue((chromePage.getMyWayElement().isDisplayed()));
		Assert.assertEquals(chromePage.enteredName().getText(), name);
		Assert.assertEquals(chromePage.selectedCar().getText(), "mercedes");
		chromePage.ClickclickHereLink();
		Assert.assertEquals(chromePage.verifySelectedCar(), "volvo");
}}
