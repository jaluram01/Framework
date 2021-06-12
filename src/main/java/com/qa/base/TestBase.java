package com.qa.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.driver.Connection;
import com.qa.util.Camera;
import com.qa.util.LoggingUtil;
import com.qa.util.Sleeper;



public class TestBase {

	public ExtentReports report;
	public ExtentTest reporter;
	
	private static final String REPORT_PATH = "/Users/jalu.ram/eclipse-workspace/Framework/Reports/%s.html";
	
	protected final Logger logger = LogManager.getLogger(getClass());
	private static final Logger testBaseLogger = LogManager.getLogger(TestBase.class);
	protected static boolean closeBrowserAfterClass = true;
	protected static final String ANNOTATION_LOG_STATEMENT_PATTERN = "**** %s ****";
	

	@BeforeSuite(alwaysRun = true)
	public void beforeTestBaseSuite() {
		LoggingUtil.initializeLoggingLevel();
		testBaseLogger.debug(String.format(ANNOTATION_LOG_STATEMENT_PATTERN, "Before Suite"));
		ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(
				new File(String.format(REPORT_PATH, this.getClass().getSimpleName())));
		report = new ExtentReports();
		report.attachReporter(extentHtmlReporter);
	}
	
	@BeforeClass(alwaysRun = true)
	public void beforeTestBaseClass() {
		testBaseLogger.debug(String.format(ANNOTATION_LOG_STATEMENT_PATTERN, "Before Class"));
		Connection.getWebDriver();
	}
	
	@BeforeMethod(alwaysRun = true)
	public void beforeTestBaseMethod(Method method) {
		testBaseLogger.trace(String.format(ANNOTATION_LOG_STATEMENT_PATTERN, "Before Method"));
		testBaseLogger.info(String.format("**** Test: %s ****", method.getName()));
		reporter = report.createTest(method.getAnnotation(Test.class).testName());
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterTestBaseMethod(ITestResult result, Method method) {
		testBaseLogger.info(String.format(ANNOTATION_LOG_STATEMENT_PATTERN, "After Method"));
		String testCaseName = method.getAnnotation(Test.class).testName();
		if (result.isSuccess()) {
			reporter.pass(testCaseName + " :: Passed");
			createImageForLog(Status.PASS, testCaseName, Camera.takeScreenshot(method.getName()));
		} else {
			reporter.fail(testCaseName + " :: Failed");
			createImageForLog(Status.FAIL, testCaseName, errorSnapshot(method.getName()));
		}
	}
	
	@AfterClass(alwaysRun = true)
	public void afterTestBaseClass() {
		if(closeBrowserAfterClass) {
			report.flush();
			Connection.closeConnection();
		}
	}
	
	
	protected String errorSnapshot(String name) {
		testBaseLogger.info(String.format("Capturing failure snapshot of \"%s\"", name));
		return Camera.takeScreenshot("FAILURE-" + name);
	}
	
	/**
	 * This method is used to switch to new window
	 */
	public void switchToNewWindow() {
		testBaseLogger.debug("Switching to new window");
		Set<String> handles = Connection.getWebDriver().getWindowHandles();
		String[] handleArray = handles.toArray(new String[handles.size()]);
		WebDriver wd = Connection.getWebDriver();
		wd.switchTo().window(handleArray[handles.size() - 1]);
		Sleeper.seconds(2, "Letting window to switch");
		testBaseLogger.debug("Switched to New Window");
		Camera.takeScreenshot("Switched To New Window");
	}
	
	public void createImageForLog(Status status, String details, String path) {
		try {
			reporter.log(status, details, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
