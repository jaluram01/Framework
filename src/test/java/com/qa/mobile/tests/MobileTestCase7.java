package com.qa.mobile.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.base.MobileBaseTest;
import io.appium.java_client.MobileElement;

public class MobileTestCase7 extends MobileBaseTest {
	@Test
	public void clickonDisplayPopupAndDismiss() {
		try {
		MobileElement pButton = appiumDriver.findElement(By.id("io.selendroid.testapp:id/showPopupWindowButton"));
		pButton.click();
		MobileElement dismissBtn = appiumDriver.findElement(By.id("io.selendroid.testapp:id/showPopupWindowButton"));
		Alert alert = appiumDriver.switchTo().alert();
		alert.accept();		
		Assert.assertEquals(dismissBtn.isDisplayed(), false);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
