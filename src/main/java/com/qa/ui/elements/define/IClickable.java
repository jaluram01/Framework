/**
 * Copyright (c) Jalu Ram.
 * Confidential
 * All Rights Reserved
 */

package com.qa.ui.elements.define;


/**
 * An interface for objects which can be clicked.
 * 
 * @author Jalu Ram
 *
 */
public interface IClickable {

	/**
	 * Attempt to click on this object.
	 * 
	 * @return this object.
	 */
	public IClickable click();

	/**
	 * Returns a Waiter that will evaluate to true when this element is able to be clicked.
	 * 
	 * @return
	 */
	public Boolean isClickable();
}
