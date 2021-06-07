package com.qa.mobile.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.MobileBaseTest;

import io.appium.java_client.MobileElement;

public class MobileTestCase8 extends MobileBaseTest {
	@Test
	public void clickOnExceptionBtnAndVerifyHomescreenTitle() {
		MobileElement eButton = appiumDriver.findElement(By.id("io.selendroid.testapp:id/exceptionTestButton"));
		eButton.click();
		MobileElement title = appiumDriver.findElement(By.id("android:id/title"));
		Assert.assertEquals(title.getText(), "selendroid-test-app");
	}


}
