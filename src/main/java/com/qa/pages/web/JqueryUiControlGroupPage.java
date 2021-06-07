package com.qa.pages.web;

import java.util.HashMap;

import org.openqa.selenium.By;
import com.qa.datamodel.jax.LocatorParser;
import com.qa.ui.elements.Button;
import com.qa.ui.elements.Checkbox;
import com.qa.ui.elements.Dropdown;
import com.qa.ui.elements.TextField;
import com.qa.util.APageObject;

public class JqueryUiControlGroupPage extends APageObject {
	
	private static HashMap<String, By> locators = LocatorParser.getLocators("web-jqueryui-controlGroupPage.xml");
	public Button carTypeBtn;
	public Dropdown carTypeDropdownHorizontalOptions;
	public Button bookNowBtn;
	public Button automaticRadioBtn;
	public Button verticalCarTypeButton;
	public Dropdown carTypeDropdownVerticalOptions;
	public Button standardRadioBtn;
	public Checkbox insuranceCheckBox1;
	public Checkbox insuranceCheckBox2;
	public TextField horizontalSpinner;
	public TextField verticalSpinner;
	
	public JqueryUiControlGroupPage() {
		carTypeBtn = new Button(locators.get("carTypeBtn"), "Car Type Button");
		carTypeDropdownHorizontalOptions = new Dropdown(locators.get("carTypeDropdownHorizontalOptions"), "Horizontal Dropdown Options");
		automaticRadioBtn = new Button(locators.get("automaticRadioBtn"), "Automatic Radio Button");
		standardRadioBtn = new Button(locators.get("standardRadioBtn"), "Standard Radio Button");
		verticalCarTypeButton = new Button(locators.get("verticalCarTypeButton"), "Vertical Car Type Button");
		carTypeDropdownVerticalOptions = new Dropdown(locators.get("carTypeDropdownVerticalOptions"), "Vertical Dropdown Options");
		insuranceCheckBox1 = new Checkbox(locators.get("insuranceCheckBox"), "Isurance CheckBox1");
		insuranceCheckBox2 = new Checkbox(locators.get("insuranceCheckBox_2"), "Isurance CheckBox2");
		bookNowBtn = new Button(locators.get("bookNowBtn"), "Book Now Button");
		horizontalSpinner = new TextField(locators.get("horizontalSpinner"), "Horizontal Spinner");
		verticalSpinner = new TextField(locators.get("verticalSpinner"), "Vertical Spinner");
	}
}
