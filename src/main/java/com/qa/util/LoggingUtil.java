package com.qa.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;


public class LoggingUtil {
	private static final Logger logger = LogManager.getLogger(LoggingUtil.class);
	
	  /**
	   * Initializes logging level 
	   * <ol>
	   * <li>To system property "logLevel" if set</li>
	   * <li>Default value specified in log4j2.properties</li>
	   * </ol>
	   */
	  public static void initializeLoggingLevel() {
		    String logLevel = System.getProperty("logLevel");
		    if (logLevel != null && !logLevel.isEmpty()) {
		      Level level = Level.getLevel(logLevel);
		      System.out.println(String.format("Setting Rootlogger logging level to %s", level));
		      logger.info("Setting Rootlogger logging level to {}", level);
		      LoggingUtil.updateLoggingLevel(LogManager.ROOT_LOGGER_NAME, level);
		      LoggingUtil.updateLoggingLevel("com.qa.base", level);
		    }
		  }
	  
	  /**
	   * Update the logging level of the provided logger
	   * 
	   * @param loggerName
	   * @param level
	   */
	  public static void updateLoggingLevel(String loggerName, Level level) {
	    LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
	    Configuration config = ctx.getConfiguration();
	    LoggerConfig loggerConfig = config.getLoggerConfig(loggerName);
	    loggerConfig.setLevel(level);
	    ctx.updateLoggers();
	  }
}
