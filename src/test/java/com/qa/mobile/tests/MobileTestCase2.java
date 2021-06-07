package com.qa.mobile.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.base.MobileBaseTest;
import com.qa.pages.mobile.HomePage;

public class MobileTestCase2 extends MobileBaseTest {
	HomePage home;
	
	@Test
	public void clickEN_BtnAndVerify() {
		home = new HomePage(appiumDriver);
		home.clickEN_Btn();
		home.waitForMsg();
		home.clickNoBtn();
		Assert.assertTrue(home.homeTitleElement().isDisplayed());
	}

}
