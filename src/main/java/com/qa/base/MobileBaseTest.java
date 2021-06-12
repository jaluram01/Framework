package com.qa.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.util.Camera;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileBaseTest {
	public static AppiumDriver<MobileElement> appiumDriver;
	private static final Logger logger = LogManager.getLogger(MobileBaseTest.class);
	public ExtentReports report;
	public ExtentTest reporter;

	// Variables
	private static final String REPORT_PATH = "/Users/jalu.ram/eclipse-workspace/Framework/Reports/%s.html";
	private static final String APP_PATH = "/Users/jalu.ram/eclipse-workspace/Framework/src/main/resources/selendroid-test-app.apk";
	public static final String PLATFORM_NAME = "ANDROID";
	public static final String PLATFORM_VERSION = "10";
	public static final String DEVICE_NAME = "DEVICE_NAME";
	public static final String AUTOMATION_NAME = "UiAutomator2";
	private static final String URL_STRING = "http://127.0.0.1:4723/wd/hub";

	@BeforeSuite(alwaysRun = true)
	public void beforeSuiteSetup() throws MalformedURLException {
		ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(new File(String.format(REPORT_PATH, this.getClass().getSimpleName())));
		report = new ExtentReports();
		report.attachReporter(extentHtmlReporter);

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
		capabilities.setCapability(MobileCapabilityType.APP, APP_PATH);
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AUTOMATION_NAME);
		capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);

		URL url = new URL(URL_STRING);
		appiumDriver = new AppiumDriver<MobileElement>(url, capabilities);

		logger.debug("Application Started");
	}

	@BeforeMethod(alwaysRun = true)
	public void configureExtendReport(Method method) {
		reporter = report.createTest(method.getAnnotation(Test.class).testName());
	}

	public void createImageForLog(Status status, String details, String path) {
		try {
			reporter.log(status, details, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult result) {
		Method method = result.getMethod().getConstructorOrMethod().getMethod();
		String testCaseName = method.getAnnotation(Test.class).testName();
		if (result.isSuccess()) {
			reporter.pass(testCaseName + " :: Passed");
			createImageForLog(Status.PASS, testCaseName, Camera.takeMobileScreenshot(method.getName()));
		} else {
			reporter.fail(testCaseName + " :: Failed");
			createImageForLog(Status.FAIL, testCaseName, Camera.takeMobileScreenshot(method.getName()));
		}
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		appiumDriver.closeApp();
		logger.debug("Application Started");
		report.flush();
	}
}
