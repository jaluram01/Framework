/**
 * Copyright (c) Jalu Ram.
 * Confidential
 * All Rights Reserved
 */

package com.qa.datamodel.jax;

import java.io.File;
import java.util.HashMap;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import org.openqa.selenium.By;
import com.qa.exceptions.TestCodeException;
import com.qa.util.Loader;

/**
 * Parses locators from files
 * 
 * @author jalu.ram
 *
 */

public class LocatorParser {

	/**
	 * Handles transformation of XML to POJO
	 * 
	 * @param filePath
	 * @return locators
	 */
	public static Locators parseXml(String filePath) {
		try {
			File file = new File(filePath);
			JAXBContext jaxbContext = JAXBContext.newInstance(Locators.class);

			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Locators locators = (Locators) unmarshaller.unmarshal(file);
			return locators;
		} catch (Exception e) {
			throw new TestCodeException(e);
		}
	}

	public static HashMap<String, By> getLocators(String file) {
		HashMap<String, By> bys = new HashMap<String, By>();
		String filePath = Loader.findAbsolutePath("locators" + "/" + file);
		Locators locators = parseXml(filePath);

		for (Locator locator : locators.getLocators()) {
			By by;
			String type = locator.getType();
			switch (type) {
			case "xpath":
				by = By.xpath(locator.getValue());
				break;
			case "className":
				by = By.className(locator.getValue());
				break;

			case "name":
				by = By.name(locator.getValue());
				break;

			case "id":
				by = By.id(locator.getValue());
				break;

			case "linkText":
				by = By.linkText(locator.getValue());
				break;

			case "cssSelector":
				by = By.cssSelector(locator.getValue());
				break;

			default:
				throw new TestCodeException("Unknown locator type: " + type);
			}
			
			bys.put(locator.getName(), by);
		}
		return bys;
	}

}
