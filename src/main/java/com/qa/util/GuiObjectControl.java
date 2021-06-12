package com.qa.util;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.qa.driver.Connection;
import com.qa.finder.Finder;




public class GuiObjectControl {

	private static final Logger logger = LogManager.getLogger(GuiObjectControl.class);
	
    public static void click(WebElement element) {
        logger.debug("Clicking on '{}' with class '{}'", element.getTagName(), element.getAttribute("class"));
        element.click();
    }
    
    public static void setText(WebElement element, String characters) {
    	element.sendKeys(characters);
    }
    
    public static String getText(WebElement element) {
        logger.debug("Getting text from '{}' with class '{}'", element.getTagName(), element.getAttribute("class"));
        String text = element.getText();
        logger.debug("Retrieved text: '{}'", text);
        return text;
    }
    
    /**
     * Moves mouse to element
     * 
     * @param element
     */
    public static void moveMouseTo(WebElement element) {
        new Actions(Connection.getWebDriver()).moveToElement(element).build().perform();
    }
    
    public static String getValue(WebElement element) {
        return getAttribute(element, "value");
    }
    
    public static String getTitle(WebElement element) {
        return getAttribute(element, "title");
    }
    
    /**
     * Used to remove redundant code from get methods.
     * 
     * @param element
     * @param attribute
     * @return
     */
    public static String getAttribute(WebElement element, String attribute) {
        logger.trace("Getting {} from '{}' with class '{}'", attribute, element.getTagName(), element.getAttribute("class"));
        String attrVal = element.getAttribute(attribute);
        logger.trace("Retrieved {}: '{}'", attribute, attrVal);
        return attrVal;
    }
    
    /**
     * Used to drag and drop an element.
     * 
     * @param source element
     * @param destination element
     * @return void
     */
	public static void dragAndDrop(By sourceBy, By destinationBy) {
		WebElement source = Finder.find(sourceBy);
		WebElement destination = Finder.find(destinationBy);
		Actions action = new Actions(Connection.getWebDriver());
		action.clickAndHold(source).pause(Duration.ofSeconds(2)).moveToElement(destination).release().build().perform();
	}
	
	public static void switchToFrame(By locator) {
		Connection.getWebDriver().switchTo().frame(Finder.find(locator));
	}
	
	public static void switchToDefaultContent() {
		Connection.getWebDriver().switchTo().defaultContent();
	}
	
	public static void scrollBy(int upOffset, int downOffset) {
		JavascriptExecutor js = (JavascriptExecutor) Connection.getWebDriver();
		js.executeScript("window.scrollBy("+upOffset+", "+downOffset+")");
	}
}
