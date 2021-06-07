package com.qa.mobile.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.base.MobileBaseTest;


import io.appium.java_client.MobileElement;

public class MobileTestCase6 extends MobileBaseTest {
	
	@Test
	public void clickToastBtnAndVerifyToastText() {
		MobileElement toastButton = appiumDriver.findElement(By.id("io.selendroid.testapp:id/showToastButton"));
		toastButton.click();
		MobileElement toastTxt = appiumDriver.findElement(By.xpath("*//[contains(text(),'Hello Selendroid')]"));
		Assert.assertEquals(toastTxt, "Hello Selendroid toast!");
		}


}
