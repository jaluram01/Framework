package com.qa.mobile.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.base.MobileBaseTest;
import com.qa.pages.mobile.HomePage;
import com.qa.pages.mobile.RegistrationPage;
import com.qa.util.Sleeper;

public class MobileTestCase4 extends MobileBaseTest {
	RegistrationPage regPage;
	HomePage home;

	String regUserPageTitle = "Welcome to register a new User";
	String name = "Mr. Burns";
	String lang = "Ruby";
	String userName = "Test";
	String email = "test@gmail.com";
	String password = "Test@123";

	@Test(testName = "Registration Page Test", enabled = true)
	public void verifyClickFileLogoAndVerifyRegPageElements() {
		home = new HomePage(appiumDriver);

		home.getFileIconButton().click();

		regPage = new RegistrationPage(appiumDriver);
		
		reporter.info("Verifying registration page Title");
		Assert.assertEquals(regPage.getWelcomeLabel().getText(), regUserPageTitle, "Test Failed:: Title is incorrect");
		
		reporter.info("Verifying Elements of Registration page");
		Assert.assertTrue(regPage.getUserNameTextBox().isDisplayed());
		Assert.assertTrue(regPage.getEmailTextBox().isDisplayed());
		Assert.assertTrue(regPage.getPasswordTextBox().isDisplayed());
		Assert.assertTrue(regPage.getNameTxtBox().isDisplayed());
		Assert.assertTrue(regPage.gettNCCheckbox().isDisplayed());
		appiumDriver.hideKeyboard();
		Assert.assertTrue(regPage.getRegUserBtn().isDisplayed());
		Assert.assertEquals(regPage.getNameTxtBox().getText(), name);
		Assert.assertEquals(regPage.getProgrammingLangDropdownValue().getText(), lang);
		
		reporter.info("Entering details to Registration fields");
		regPage.fillRegistrationFormAndClickRegister(userName, email, password, name);
		
		reporter.info("Verifying entered values with test data");
		Assert.assertEquals(regPage.getNameField().getText(), name);
		Assert.assertEquals(regPage.getUserNameField().getText(), userName);
		Assert.assertEquals(regPage.getPasswordField().getText(), password);
		Assert.assertEquals(regPage.getEmailField().getText(), email);
		Assert.assertEquals(regPage.getpRLangField().getText(), lang);
		Assert.assertEquals(regPage.getiAcceptVal().getText(), "true");

		regPage.getRegisterButton().click();
		reporter.info("Clicked on register button");
		
		Sleeper.seconds(2, "Waiting for the page load");
		home = new HomePage(appiumDriver);
		
		reporter.info("Verifying home page title");
		Assert.assertTrue(home.homeTitleElement().isDisplayed());
	}
}
