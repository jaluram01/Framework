/**
 * Copyright (c) Jalu Ram.
 * Confidential
 * All Rights Reserved
 */

package com.qa.datamodel.jax;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Data Model to represent a Locators
 * 
 * @author Jalu Ram
 *
 */

@XmlRootElement(name = "locators")
@XmlAccessorType
public class Locators {
	private List<Locator> locators = new ArrayList<>();
	
	@XmlElement(name = "locator")
	public List<Locator> getLocators() {
		return locators;
	}

	public void setLocators(List<Locator> locators) {
		this.locators = locators;
	}

}
