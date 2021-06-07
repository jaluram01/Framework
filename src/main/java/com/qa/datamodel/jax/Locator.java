/**
 * Copyright (c) Jalu Ram.
 * Confidential
 * All Rights Reserved
 */

package com.qa.datamodel.jax;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Data model to represent locator
 * 
 * @author jalu.ram
 *
 */

@XmlRootElement(name = "locator")
public class Locator {
	private String name;
	private String type;
	private String value;
	
	@XmlAttribute
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@XmlElement
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
	    builder.append("Locator [name=").append(name).append(", type=").append(type).append(", value=").append(value).append("]");
	    return builder.toString();
	}
}
