/**
 * Copyright (c) Jalu Ram
 * Confidential
 * All Rights Reserved
 */

package com.qa.ui.elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.exceptions.NavigationException;
import com.qa.finder.Finder;


/**
 * Parent class of a@Override
	ll GUI Objects
 * 
 * @author Jalu Ram
 *
 */
public abstract class AGuiObject {

	protected By locator;
	protected String description;

	/**
	 * The {@link org.openqa.selenium.WebElement WebElement} webElement is the
	 * latest result of the {@link #bindToDOM()} method.
	 */
	protected WebElement webElement;
	protected final Logger logger = LogManager.getLogger(AGuiObject.class);
	
	protected AGuiObject() {
		
	}
	protected AGuiObject(By locator, String description) {
		this.locator = locator;
		this.description = description;
		bindToDOM();
	}
	

	protected void bindToDOM() {
		logger.trace("Binding {} with locator {}", description, locator);
		try {
			webElement = Finder.find(locator, Finder.DEFAULT_WAIT, ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (NoSuchElementException e) {
			throw new NavigationException(String.format(
					"Unable to bind %s to the DOM, no displayed elements match locator %s", description, locator), e);
		}
	}


	public String getDescription() {
		return description;
	}
	
	  /**
	   * Returns the Web Element of the Dialog 
	   * 
	   * @return web element for the dialog
	   */
	  public WebElement getGuiWebElement()
	  {
	      return webElement;
	  }
}
