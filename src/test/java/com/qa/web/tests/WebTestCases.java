package com.qa.web.tests;

import org.testng.annotations.AfterMethod;

/**
 * @author Jalu Ram
 */

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.base.TestBase;
import com.qa.driver.Connection;
import com.qa.environment.Environment;
import com.qa.pages.web.JqueryUiControlGroupPage;
import com.qa.pages.web.JqueryUiDroppablePage;
import com.qa.pages.web.JqueryUiHomePage;
import com.qa.pages.web.JqueryUiSelectablePage;
import com.qa.util.GuiObjectControl;
import com.qa.util.Sleeper;

public class WebTestCases extends TestBase {

	@BeforeClass
	public void beforeClassSetup() {
		Environment env = Environment.valueOf(System.getProperty("env"));
		Connection.getWebDriver().get(env.getUrl());
	}

	@Test(testName = "Droppable functionality Test", enabled = true, priority = 1)
	public void dragAndDropTest() {
		try {
			JqueryUiHomePage homePage = new JqueryUiHomePage();

			homePage.droppableLink.click();
			reporter.info("Clicked on Droppable Link");

			JqueryUiDroppablePage droppablePage = new JqueryUiDroppablePage();

			reporter.info("Switch to Demo-Frame");
			GuiObjectControl.switchToFrame(homePage.frameBy);
			Sleeper.seconds(5, "Waiting for the frame to load");

			GuiObjectControl.dragAndDrop(droppablePage.dragBy, droppablePage.dropBy);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(testName = "Control Group functionality Test", enabled = true, priority = 2)
	public void controlgroupTest() {
		try {
			JqueryUiHomePage homePage = new JqueryUiHomePage();

			homePage.controlgroupLink.click();
			reporter.info("Clicked on ControlGroup Link");
			GuiObjectControl.scrollBy(0, 500);
			GuiObjectControl.switchToFrame(homePage.frameBy);
			Sleeper.seconds(5, "Waiting for the frame to load");

			JqueryUiControlGroupPage controlGroupPage = new JqueryUiControlGroupPage();
			controlGroupPage.carTypeBtn.click();
			reporter.info("Clicked on Horizontal Car Type Button");

			controlGroupPage.carTypeDropdownHorizontalOptions.selectOption("SUV");
			reporter.info("Selected SUV option from dropdown");

			controlGroupPage.automaticRadioBtn.click();
			reporter.info("Selected Horizontal Automatic Radio Button");

			controlGroupPage.insuranceCheckBox1.click();
			reporter.info("Selected Horizontal Insurance Checkbox");

			controlGroupPage.horizontalSpinner.setText("2");
			reporter.info("Entered 2 to Horizontal Spinner");

			controlGroupPage.verticalCarTypeButton.click();
			reporter.info("Clicked on Vertical Car Type Button");

			controlGroupPage.carTypeDropdownVerticalOptions.selectOption("Truck");
			reporter.info("Selected Truck option from dropdown");

			controlGroupPage.standardRadioBtn.click();
			reporter.info("Clicked on Standard Radio Button");

			controlGroupPage.insuranceCheckBox2.click();
			reporter.info("Selected Vertical Insurance Checkbox");

			controlGroupPage.verticalSpinner.setText("1");
			reporter.info("Entered 1 to Vertical Spinner");

			controlGroupPage.bookNowBtn.click();
			reporter.info("Clicked on Book Now Button");

			reporter.pass("Control Group Test Passed");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(testName = "Dropdown Test", enabled = true, priority = 3)
	public void selectItemsFromDropdownTest() {
		try {
			JqueryUiHomePage homePage = new JqueryUiHomePage();

			homePage.selectableLink.click();
			reporter.info("Clicked on Selectable Link");

			GuiObjectControl.scrollBy(0, 300);
			reporter.info("Switch to Demo-Frame");
			GuiObjectControl.switchToFrame(homePage.frameBy);
			Sleeper.seconds(5, "Waiting for the frame to load");

			JqueryUiSelectablePage selectablePage = new JqueryUiSelectablePage();

			selectablePage.dropDownValues.selectOptions("Item 1", "Item 3", "Item 7");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod(alwaysRun = true)
	public void switchToDefaultContent() {
		GuiObjectControl.switchToDefaultContent();
	}
}
