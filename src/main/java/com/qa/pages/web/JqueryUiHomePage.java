package com.qa.pages.web;

import java.util.HashMap;

import org.openqa.selenium.By;

import com.qa.datamodel.jax.LocatorParser;
import com.qa.ui.elements.HyperLink;
import com.qa.util.APageObject;

public class JqueryUiHomePage extends APageObject {

	private static HashMap<String, By> locators = LocatorParser.getLocators("web-jqueryui-homepage.xml");

	public final HyperLink droppableLink;
	public final HyperLink selectableLink;
	public final HyperLink controlgroupLink;
	public final By frameBy = locators.get("demoFrame");
	

	public JqueryUiHomePage() {
		droppableLink = new HyperLink(locators.get("droppableLink"), "Droppable Link");
		selectableLink = new HyperLink(locators.get("selectableLink"), "Selectable Link");
		controlgroupLink = new HyperLink(locators.get("controlgroupLink"), "Control Group Link");
	}
}
