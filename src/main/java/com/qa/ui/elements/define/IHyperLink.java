/**
 * Copyright (c) Jalu Ram.
 * Confidential
 * All Rights Reserved
 */

package com.qa.ui.elements.define;

/**
 * Contract to define hyper-link functionality.
 * 
 * @author Jalu Ram
 *
 */
public interface IHyperLink extends IClickable{

	/**
	 * Get the display text of the hyper-link
	 * 
	 * @return display text
	 */
	public String getText();
}
