package com.qa.finder;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.base.Function;
import com.qa.driver.Connection;
import com.qa.exceptions.TestCodeException;

/**
 * Locates WebElement(s) from the DOM given a locator.
 * 
 * @author Jalu Ram
 *
 */
public class Finder {

	private static Logger logger = LogManager.getLogger(Finder.class);

	public static Wait<WebDriver> DEFAULT_WAIT = new WebDriverWait(Connection.getWebDriver(), 20);

	private Finder() {

	}
	
	public static WebElement findElem(By locator) {
		return DEFAULT_WAIT.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	public static WebElement find(By locator) {
		return find(locator, DEFAULT_WAIT);
	}

	public static WebElement find(By locator, Wait<WebDriver> wait) {
		return find(locator, wait, ExpectedConditions.presenceOfElementLocated(locator));
	}

	public static WebElement find(By locator, Wait<WebDriver> wait, Function<WebDriver, WebElement> expectedCondition) {
		logger.debug("Finding WebElement for locator {}", locator);
		try {
			WebElement result = wait.until(expectedCondition);
			logger.debug("Found WebElement for locator {}", locator);
			return result;
		} catch (TimeoutException e) {
			String exceptionString = String.format("No Such Element found for locator: %s", locator);
			logger.debug(exceptionString);
			throw new TestCodeException(exceptionString, e);
		}
	}

	/**
	 * This method is for negative case check of an element
	 * 
	 * With NO_WAIT
	 * 
	 * @param locator of an element
	 * @return true if found else false
	 */
	public static Boolean doesThisWebElementExist(By locator) {
		logger.debug("Checking WebElement for locator {} exists", locator);
		try {
			find(locator, DEFAULT_WAIT);
			return true;
		} catch (TimeoutException | NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * This method is used to find all the elements for locator
	 * 
	 * @param locator
	 * @return the list of elements found for locator
	 */
	public static List<WebElement> findAll(By locator) {
		return findAll(locator, DEFAULT_WAIT);
	}

	public static List<WebElement> findAll(By locator, Wait<WebDriver> wait) {
		return findAll(locator, wait, ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	public static List<WebElement> findAll(By locator, Wait<WebDriver> wait,
			Function<WebDriver, List<WebElement>> expectedCondition) {
		logger.trace("Finding All WebElement(s) for locator {}" + locator);
		List<WebElement> elements;
		try {
			elements = wait.until(expectedCondition);
		} catch (TimeoutException e) {
			elements = new ArrayList<WebElement>();
		}
		if (elements.isEmpty()) {
			logger.trace("Found No WebElement(s) for locator {}", locator);
		} else {
			logger.trace("Found WebElement(s) for locator {}", locator);
		}
		return elements;
	}

}
