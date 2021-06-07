/**
 * Copyright (c) Jalu Ram.
 * Confidential
 * All Rights Reserved
 */

package com.qa.ui.elements.define;

import java.util.List;

/**
 * Contract to define dropdown functionality.
 * 
 * @author Jalu Ram
 *
 */
public interface IDropdown extends IClickable {
	
	/**
	 * Expand the dropdown if needed and select the given option option
	 * 
	 * @param option - string value of the option
	 * @return itself if successful
	 */
	public IDropdown selectOption(String option);
	
	/**
	 * Get a list of all the option values
	 * 
	 * @return option values
	 */
	public List<String> getOptions();
	
	/**
	 * Get the selected value
	 * 
	 * @return the selected value
	 */
	public String getSelected();
	
	/**
	 * Expand the dropdown if needed and mouse hover on the given option 
	 * 
	 * @param option - string value of the option
	 * @return itself if successful
	 */

}
