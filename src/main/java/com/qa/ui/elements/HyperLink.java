package com.qa.ui.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.qa.exceptions.TestCodeException;
import com.qa.ui.elements.define.IClickable;
import com.qa.ui.elements.define.IHyperLink;
import com.qa.util.GuiObjectControl;
import com.qa.util.Waiter;

public class HyperLink extends AGuiObject implements IHyperLink {

	public HyperLink(By locator, String description) {
		super(locator, description);
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
	public String getText() {
		return GuiObjectControl.getText(webElement);
	}

}
