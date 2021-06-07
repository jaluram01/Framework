/**
 * Copyright (c) Jalu Ram.
 * Confidential
 * All Rights Reserved
 */

package com.qa.ui.elements.define;

/**
 * Contract to define text field functionality.
 * 
 * @author Jalu Ram
 *
 */
public interface ITextFiled {

	/**
	 * Clears the text field if needed and sets the text field to the provided text
	 * 
	 * @param text
	 * @return itself if successful
	 */
	public ITextFiled setText(String text);
}
