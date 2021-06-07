package com.qa.ui.elements;

import org.openqa.selenium.By;

import com.qa.ui.elements.define.ITextFiled;
import com.qa.util.GuiObjectControl;

public class TextField extends AGuiObject implements ITextFiled {
	
	 /**
     * Constructor
     * 
     * @param locator
     *            - The locator defining the text input field
     */
    public TextField(By locator, String description) {
        super(locator, description);
    }
    
	@Override
	public ITextFiled setText(String text) {
        if (text != null) {
            GuiObjectControl.setText(webElement, text);
        }
        return this;
    }
}
