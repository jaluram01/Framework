package com.qa.mobile.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.qa.base.MobileBaseTest;
import com.qa.pages.mobile.RegistrationPage;
import com.qa.util.Sleeper;
import io.appium.java_client.MobileElement;

public class MobileTestCase5 extends MobileBaseTest {
	RegistrationPage regPage;

	
	@Test
	public void clickOnProgressBarAndVerifyRegPageElements() {
		regPage = new RegistrationPage(appiumDriver);
		MobileElement pButton = appiumDriver.findElement(By.id("io.selendroid.testapp:id/waitingButtonTest"));
		pButton.click();
		Sleeper.seconds(10, "Waiting for the alert to disappear");
		regPage.verifyRegPageElements();
	}
}
