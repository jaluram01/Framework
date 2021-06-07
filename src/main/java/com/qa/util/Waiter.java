package com.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.qa.driver.Connection;

public class Waiter {
	public static Wait<WebDriver> DEFAULT_WAIT = new WebDriverWait(Connection.getWebDriver(), 20);
	public static void doWait(By locator) {
		WebDriverWait wait = new WebDriverWait(Connection.getWebDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));	
	}
	
	public static void waitUntil(Function<WebDriver, WebElement> expectedCondition) {
		DEFAULT_WAIT.until(expectedCondition);
	}
}

