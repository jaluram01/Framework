package com.qa.ui.elements;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.driver.Connection;
import com.qa.exceptions.TestCodeException;
import com.qa.finder.Finder;
import com.qa.ui.elements.define.IClickable;
import com.qa.ui.elements.define.IDropdown;
import com.qa.util.GuiObjectControl;
import com.qa.util.Waiter;

public class Dropdown extends AGuiObject implements IDropdown {

	public enum Type {
		TEXT, // Option name stored as innerText
		TITLE, // Option name stored as title attribute
		VALUE // Option name stored as value attribute
	}

	protected By optionsLocator;
	protected Type type;

//	public Dropdown(By optionsLocator, String description) {
//		super(optionsLocator, description);
//	}
	
	 public Dropdown(By optionsLocator, String description) {
		this.optionsLocator = optionsLocator;
		this.description = description;
		this.type = Type.TEXT;
	}

	@Override
	public IClickable click() {
		if(isClickable()) {
			logger.debug("Clicking on {}", description);
			GuiObjectControl.click(webElement);
			return this;
		}
		throw new TestCodeException("Element is not clickable");
	}
	
	@Override
	public Boolean isClickable() {
		try {
			Waiter.waitUntil(ExpectedConditions.elementToBeClickable(webElement));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public IDropdown selectOption(String option) {

		List<WebElement> elements = getOptionsElements();
		System.err.println(elements.size());
		for (WebElement element : elements) {
			if (option.equalsIgnoreCase(getValue(element))) {
				logger.debug("Clicking on {} option {}", description, option);
				GuiObjectControl.moveMouseTo(element);
				element.click();
				return this;
			}
		}

		throw new TestCodeException(String.format("Option %s is not available for selection", option));
	}
	/**
	 * This method is used to select multiple values from dropdown
	 * @param strings
	 * @return
	 */
	public IDropdown selectOptions(String...strings) {
		Actions actions = new Actions(Connection.getWebDriver());
		for (String option : strings) {
			actions.keyDown(Keys.CONTROL).pause(500).build().perform();
			selectOption(option);
			actions.release().perform();
		}
			
		return this;
	}

	@Override
	public List<String> getOptions() {
		ArrayList<String> options = new ArrayList<>();
		List<WebElement> elements = getOptionsElements();
		for (WebElement element : elements) {
			options.add(getValue(element));
		}

		return options;
	}

	@Override
	public String getSelected() {

		return getValue(webElement);
	}

	/**
	 * Retrieve all WebElements located by optionsLocator
	 * 
	 * @return
	 */
	protected List<WebElement> getOptionsElements() {
		return Finder.findAll(optionsLocator);
	}

	protected String getValue(WebElement element) {
		String value = null;
		switch (type) {
		case TEXT:
			value = GuiObjectControl.getText(element);
			break;
		case VALUE:
			value = GuiObjectControl.getValue(element);
			break;
		case TITLE:
			value = GuiObjectControl.getTitle(element);
			break;
		default:
			throw new TestCodeException("Unrecognized Type: " + type);
		}

		return value;
	}
}
