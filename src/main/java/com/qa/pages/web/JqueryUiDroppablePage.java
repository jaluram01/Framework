package com.qa.pages.web;

import java.util.HashMap;

import org.openqa.selenium.By;

import com.qa.datamodel.jax.LocatorParser;
import com.qa.util.APageObject;

public class JqueryUiDroppablePage extends APageObject {

	private static HashMap<String, By> locators = LocatorParser.getLocators("web-jqueryui-droppablePage.xml");
	
	 public By dragBy = locators.get("draggableArea");
	 public By dropBy = locators.get("droppableArea");
	 public By frameBy = locators.get("demoFrame");
}
