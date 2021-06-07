package com.qa.mobile.tests;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.MobileBaseTest;
import com.qa.base.TestBase;

import io.appium.java_client.MobileElement;


public class MobileTestCase9 extends MobileBaseTest {

	@Test()
	public void enterTextInExceptionFieldAndVerifyHomePageTitle() throws MalformedURLException {
		String text = "test";
		MobileElement field = appiumDriver.findElement(By.id("io.selendroid.testapp:id/exceptionTestField"));
		field.sendKeys(text);
		beforeSuiteSetup();	
		MobileElement title = appiumDriver.findElement(By.id("android:id/title"));
		Assert.assertEquals(title.getText(), "selendroid-test-app");
	}
}
