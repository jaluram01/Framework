package com.qa.util;

import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import com.qa.driver.Connection;


/**
 * Parent class of all Page Objects
 * 
 * @author Jalu Ram
 *
 */
public abstract class APageObject {
	protected String windowHandle = null;
	protected String callersWindowHandle = null;
	protected final Logger logger = LogManager.getLogger(APageObject.class);
	
	public APageObject() {
		windowHandle = getWindowHandle();
	}
	
	public APageObject(String url) {
		logger.info("Opening url: {}", url);
		Connection.getWebDriver().get(url);
		windowHandle = getWindowHandle();
	}
	
	/**
	 * This method is used to get the title
	 * @return string of title
	 */
	public String getTitle() {
		String title = Connection.getWebDriver().getTitle();
		logger.trace("Retrieved title: '{}'", title);
		return title;
	}
	
	/**
	 * This method is used to get the current URL
	 * @return string of URL
	 */
	public String getUrl() {
		String url = Connection.getWebDriver().getCurrentUrl();
		logger.trace("Retrieved url: '{}'", url);
		return url;
	}
	
	/**
	 * This method is used to get a window handle
	 * @return string of window handle
	 */
	public String getWindowHandle() {
		windowHandle = Connection.getWebDriver().getWindowHandle();
		logger.trace("Retrieved handle: '{}'", windowHandle);
		return windowHandle;
	}
	
	/**
	 * Switches to New Window
	 */
	public void switchToNewWindow() {
		logger.info("Swiching to new window");
		WebDriver wd = Connection.getWebDriver();
		Sleeper.seconds(2, "Letting the window switch happen");
		Set<String> handles = wd.getWindowHandles();
		String[] handlesArray = handles.toArray(new String[handles.size()]);
		wd.switchTo().window(handlesArray[handles.size()-1]);
		Sleeper.seconds(2, "Letting the window switch stabilize");
		Camera.takeScreenshot("New Window State");
	}

	
	/**
	 * This is used to refresh/reload the page
	 * @return
	 */
	public APageObject reload() {
		logger.info("Reloading {}", this.getClass().getName());
		WebDriver wd = Connection.getWebDriver();
		wd.navigate().refresh();
		Sleeper.seconds(10, "Wait for 10 seconds to refresh and load the web page.");
		return this;
	}
	
    /**
     * Sets focus to the page
     * 
     * @return
     */
	public APageObject getFocus() {
		logger.info("Obtaining focus for {}", this.getClass().getSimpleName());
		WebDriver wd = Connection.getWebDriver();
		wd.switchTo().window(windowHandle);
		// add wait
		return this;
	}
	
    /**
     * Closes the current page and return to the caller page if known
     */
	public void close() {
		logger.info("Closing {}", this.getClass().getSimpleName());
		WebDriver wd = Connection.getWebDriver();
		wd.close();
		if(callersWindowHandle != null) {
			wd.switchTo().window(callersWindowHandle);
		}
	}
	
    /**
     * Re set browser size
     */
	public void setBrowserSize(int width, int height)
	{
		logger.info("Re set browser size");
		WebDriver wd = Connection.getWebDriver();
		wd.manage().window().setSize(new Dimension(width, height));
	}
}
