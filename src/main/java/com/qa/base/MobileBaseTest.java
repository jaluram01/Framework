package com.qa.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileBaseTest {
	public static AppiumDriver<MobileElement> appiumDriver;
	private static final Logger logger = LogManager.getLogger(MobileBaseTest.class);
	
	@BeforeSuite(alwaysRun = true)
	public void beforeSuiteSetup() throws MalformedURLException {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
			capabilities.setCapability(MobileCapabilityType.APP,
					"/Users/jalu.ram/Desktop/Appium-Selenium-RestAssured/selendroid-test-app.apk");
			capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
			capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);

			final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
			URL url = new URL(URL_STRING);
			appiumDriver = new AppiumDriver<MobileElement>(url, capabilities);
			
			logger.debug("Application Started");
	}
	
	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		appiumDriver.closeApp();
		logger.debug("Application Started");
	}
}
