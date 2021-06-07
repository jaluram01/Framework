package com.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.driver.Connection;

public class Camera {
	private static int screenDumpCounter = 0;
	private static boolean enabled = true;

	private static final Logger logger = LogManager.getLogger(Camera.class);

	private static String sanitize(String context) {
		return context.replaceAll("\\s|\\/", "_").replaceAll("'", "").replaceAll(":", "_");
	}

	private static String screenDumpPrefix(String context) {
		NumberFormat formatter = new DecimalFormat("####,0000");
		return "screenshot-" + formatter.format(screenDumpCounter++) + '-' + sanitize(context) + '-';
	}

	/**
	 * Takes a photo and places in to the log directory
	 * 
	 * @param context
	 * @return
	 * @throws InstantiationException
	 */
	public static String takeScreenshot(String context) {
		if (!enabled) {
			logger.debug("Camera is disabled");
			return null;
		}

		try {
			TakesScreenshot camera = (TakesScreenshot) Connection.getWebDriver();
			if (camera == null) {
				throw new InstantiationException("Unable to instantiate camera");
			}

			File srcTmpFile = camera.getScreenshotAs(OutputType.FILE);
			File destFile = createSnapshotFile(context);
			FileUtils.copyFile(srcTmpFile, destFile, true);
			logger.debug("Screen snapshot dumped into {}", destFile.getAbsolutePath());
			FileUtils.deleteQuietly(srcTmpFile);

			return destFile.getPath();

		} catch (IllegalStateException e) {
			logger.warn("Unable to get scenario | {}", e.getMessage());
		} catch (InstantiationException e) {
			logger.error("Unable to create camera | {}", e.getMessage());
		} catch (Exception e) {
			logger.error("Could not dump a screen snapshot to a file with prefix '{}'!", context, e);
		}
		return null;
	}

	public static void enable() {
		enabled = true;
	}

	public static void disable() {
		enabled = false;
	}

	private static File createSnapshotFile(String context) throws IOException {
		String buildDir = System.getProperty("maven_build_directory");
		String userDir = System.getProperty("user.dir");
		String prefix = screenDumpPrefix(context);

		File directory;

		if (buildDir != null) {
			// Running with Maven
			directory = new File(buildDir + File.separator + "log");
		} else if (userDir != null) {
			// Running Locally
			directory = new File(
					userDir + File.separator + "target" + File.separator + "log" + File.separator + "snapshots");
		} else {
			return File.createTempFile(prefix, ".png");
		}

		if (!directory.exists()) {
			logger.debug("Creating snapshot directory: '{}'", directory.getAbsolutePath());
			directory.mkdir();
		}
		return File.createTempFile(prefix, ".png", directory);
	}
}
