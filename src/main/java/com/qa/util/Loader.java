package com.qa.util;

import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.exceptions.TestCodeException;

/**
 * Helps to load resources
 * 
 * @author Jalu Ram
 *
 */
public class Loader {
  private static final Logger logger = LogManager.getLogger(Loader.class);
  private static ClassLoader classLoader = Loader.class.getClassLoader();

  public static String findAbsolutePath(String filePath) {
    logger.debug("Finding:{}", filePath);
    URL url = classLoader.getResource(filePath);
    if(url == null) {
        throw new TestCodeException(String.format("Unable to find path: %s", filePath));
    }
    
    logger.debug("Found:{}", url.getPath());
    return url.getPath();
  }
}