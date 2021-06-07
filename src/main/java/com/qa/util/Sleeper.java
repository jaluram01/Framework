/**
 * Copyright (c) Jalu Ram.
 * Confidential
 * All Rights Reserved
 */

package com.qa.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.exceptions.TestCodeException;

/**
 * Simple class to handle all sleeps </br>
 * <p>
 * <b>Note:</b>
 * I am aware of org.openqa.selenium.support.ui.Sleeper</br>
 * This wraps the InterruptExeception in a RuntimeException so we don't have to deal with a try catch block every time.
 * </p>
 * 
 * @author jalu.ram
 *
 */
public final class Sleeper {

	public enum Unit {
		MILLISECONDS(1), SECONDS(1000), MINUTES(60000);

		private int factor;

		private Unit(int factor) {
			this.factor = factor;
		}
	}

	private final static Logger logger = LogManager.getLogger(Sleeper.class);
	
	/**
	 * Do nothing for a fixed amount of time<br/>
	 * <br/>
	 * <b>Note: </b> Do not use to wait for GuiObjects
	 * @param miliseconds - duration in milliseconds
	 * @param reason - reason why you are sleeping i.e. "polling interval"
	 */
	public static void milliseconds(long miliseconds, String reason) {
		sleep((int)miliseconds, Unit.MILLISECONDS, reason, Level.TRACE);
	}
	
	/**
	 * Do nothing for a fixed amount of time <br/>
	 * <br/>
	 * <b>Note:</b> Do not use to wait for GuiObjects
	 * @param seconds - duration in seconds
	 * @param reason - reason why you are sleeping i.e. "polling interval"
	 */
	public static void seconds(int seconds, String reason) {
		sleep(seconds, Unit.SECONDS, reason, Level.TRACE);
	}
	
	/**
	 * Do nothing for a fixed amount of time<br/>
	 * <br/>
	 * <b>Note:</b> Do not use to wait for GuiObjects
	 * @param minutes - duration in minutes
	 * @param reason - reason why you are sleeping i.e. "polling interval"
	 */
	public static void minutes(int minutes, String reason) {
		sleep(minutes, Unit.MINUTES, reason, Level.TRACE);
	}
	
	/**
	 * Do nothing for a fixed amount of time<br/>
	 *<br/>
	 * @param increments - duration in number of units
	 * @param units - milliseconds, seconds, minutes
	 * @param reason - reason why you are sleeping i.e. "polling interval"
	 * @param logLevel - logging level for wait statements
	 */
	public static void sleep(int increments, Unit units, String reason, Level logLevel) {
		try {
			logger.log(logLevel, "Sleeping {} {} for {}", increments, units.name().toLowerCase(), reason);
			Thread.sleep(increments * units.factor);
		} catch (InterruptedException e) {
			throw new TestCodeException(e);
		}
	}
}
