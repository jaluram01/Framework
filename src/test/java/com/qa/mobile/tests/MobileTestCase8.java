package com.qa.mobile.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.base.MobileBaseTest;
import com.qa.pages.mobile.HomePage;

public class MobileTestCase8 extends MobileBaseTest {
	HomePage homePage;
	
	@Test(testName = "Verify exception test", enabled = true)
	public void clickOnExceptionBtnAndVerifyHomescreenTitle() {
		try {
		homePage = new HomePage(appiumDriver);
		
		homePage.getExceptionTestButton().click();
		reporter.info("Clicked on show exception button");
		
		reporter.info("Verifying home page title");
		Assert.assertEquals(homePage.homeTitleElement().getText(), "selendroid-test-app");
		}catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test Failed :: App Crashed");
		}
	}
}
