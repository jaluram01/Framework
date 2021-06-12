package com.qa.mobile.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.MobileBaseTest;
import com.qa.pages.mobile.HomePage;
import com.qa.pages.mobile.RegistrationPage;
import com.qa.util.Sleeper;

public class MobileTestCase5 extends MobileBaseTest {
	HomePage homePage;
	RegistrationPage regPage;

	@Test(testName = "Show Progress Bar Test", enabled = true)
	public void clickOnProgressBarAndVerifyRegPageElements() {
		homePage = new HomePage(appiumDriver);
		
		homePage.getProgressBar().click();
		reporter.info("Clicked on show progress bar button");
		Sleeper.seconds(15, "Waiting for the alert to disappear");
		regPage = new RegistrationPage(appiumDriver);
		appiumDriver.hideKeyboard();
		
		reporter.info("Verifying the elements of registration page");
		Assert.assertTrue(regPage.getUserNameTextBox().isDisplayed());
		Assert.assertTrue(regPage.getEmailTextBox().isDisplayed());
		Assert.assertTrue(regPage.getPasswordTextBox().isDisplayed());
		Assert.assertTrue(regPage.getNameTxtBox().isDisplayed());
		Assert.assertTrue(regPage.gettNCCheckbox().isDisplayed());
		Assert.assertTrue(regPage.getRegUserBtn().isDisplayed());
	}
}
