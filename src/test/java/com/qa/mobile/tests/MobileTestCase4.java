package com.qa.mobile.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.base.MobileBaseTest;
import com.qa.pages.mobile.HomePage;
import com.qa.pages.mobile.RegistrationPage;


public class MobileTestCase4 extends MobileBaseTest {
	RegistrationPage regPage;
	HomePage home;
	
	@Test
	public void verifyClickFileLogoAndVerifyRegPageElements() {
		home = new HomePage(appiumDriver);
		regPage = new RegistrationPage(appiumDriver);
		regPage.clickFileLogo();
		regPage.verifyRegPageTitle();
		regPage.verifyRegPageElements();
		String nameTxt = "Mr. Burns";
		String langTxt = "Ruby";
		Assert.assertEquals(regPage.nameTxtBox.getText(), nameTxt);
		Assert.assertEquals(regPage.programmingLangDropdownValue.getText(), langTxt);
}
	@Test
	public void verifyUserRegistration() {
		home = new HomePage(appiumDriver);
		regPage = new RegistrationPage(appiumDriver);
		String uName = "Test";
		String email = "test@gmail.com";
		String pwd = "Test@123";
		String name = "Mr.Yoyo";
		regPage.fillRegistrationFormAndClickRegister(uName,email ,pwd,name);
		regPage.postRegistrationPage(uName,email ,pwd,name,"Ruby","true");
		regPage.registerButton.click();
		Assert.assertTrue(home.homeTitleElement().isDisplayed());
}
	
	

}
