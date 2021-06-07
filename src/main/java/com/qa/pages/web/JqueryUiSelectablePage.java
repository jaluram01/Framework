package com.qa.pages.web;

import java.util.HashMap;

import org.openqa.selenium.By;

import com.qa.datamodel.jax.LocatorParser;
import com.qa.ui.elements.Dropdown;
import com.qa.util.APageObject;

public class JqueryUiSelectablePage extends APageObject {
	
	private static HashMap<String, By> locators = LocatorParser.getLocators("web-jqueryui-selectablePage.xml");
	public By frameLocator = locators.get("demoFrame");
	public Dropdown dropDownValues;
	
	public JqueryUiSelectablePage() {
		dropDownValues = new Dropdown(locators.get("dropdownOptions"), "Selectable Dropdown");
	}

}
