package com.qa.driver;

import java.awt.Toolkit;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.SystemUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.qa.exceptions.TestCodeException;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

public class Connection implements Cloneable {

	// Implementing singleton web driver
	private static WebDriver driver;

	private static final Logger logger = LogManager.getLogger(Connection.class);

	private Connection() {

	}

	public static WebDriver getWebDriver() {
		if (driver == null || driver.toString().contains("null")) {
			DriverManagerType driverType = null;
			String browser = System.getProperty("browser");
			try {
				driverType = DriverManagerType.valueOf(browser);
			} catch (IllegalArgumentException e) {
				logger.info("Could not find browser: {}", browser);
			} catch (NullPointerException e) {
				logger.info("No browser specified");
			} finally {
				if (driverType == null) {
					logger.info("Defaulting to chrome driver");
					driverType = DriverManagerType.CHROME;
				}
			}
			try {
				driver = getWebDriver(driverType);
				return driver;
			} catch (Exception e) {
				throw new TestCodeException(e);
			}
		} else {
			return driver;
		}
	}

	/**
	 * Handles downloading of WebDriver type and version
	 * 
	 * @param driverType    WDM driverType enum input
	 * @param driverVersion string in format of WDM .version() string
	 * @return WebDriver instance of given type and version
	 */

	public static WebDriver getWebDriver(DriverManagerType driverType) {

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension = new Dimension(toolkit.getScreenSize().width, toolkit.getScreenSize().height);

		switch (driverType) {

		case CHROME:

			WebDriverManager.chromedriver().setup();

			setDriverPermissions(WebDriverManager.chromedriver().getDownloadedDriverPath());

			driver = new ChromeDriver(createChromeOptions());

			break;

		case FIREFOX:

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			throw new TestCodeException(String.format("Unknown Browser %s", driverType.toString()));

		}
		driver.manage().window().setSize(dimension);
		logger.debug("Temp files will be written to: {}", System.getProperty("java.io.tmpdir"));
		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		logger.debug("Browser Version: {} {}", caps.getBrowserName(), caps.getVersion());
		return driver;
	}

	private static void setDriverPermissions(String driverPath) {
		if (!SystemUtils.IS_OS_WINDOWS) {
			try {
				Set<PosixFilePermission> perms = new HashSet<>();
				List<PosixFilePermission> driverPerms = Arrays.asList(PosixFilePermission.GROUP_EXECUTE,
						PosixFilePermission.GROUP_READ, PosixFilePermission.OTHERS_EXECUTE,
						PosixFilePermission.OTHERS_READ, PosixFilePermission.OWNER_EXECUTE,
						PosixFilePermission.OWNER_READ, PosixFilePermission.OWNER_WRITE);
				perms.addAll(driverPerms);
				Files.setPosixFilePermissions(Paths.get(driverPath), perms);
			} catch (UnsupportedOperationException e) {
				logger.warn("Driver could not be set as an executable");
			} catch (IOException e) {
				throw new TestCodeException(e);
			}

			logger.info("Using driver at:{}", driverPath);
		}
	}

	/**
	 * Creates chrome options
	 * 
	 * @return objects of ChromeOptions
	 */
	private static ChromeOptions createChromeOptions() {
		logger.debug("Creating Chrome Options");
		logger.debug("System property - webdriver.chrome.driver: {}", System.getProperty("webdriver.chrome.driver"));

		ChromeOptions chromeOptions = new ChromeOptions();

		// Set Preferences
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("password_manager_enabled", false);

		// Enable Do Not Tracking?
		if (Boolean.parseBoolean(System.getProperty("enableDNT"))) {
			logger.info("Enabling do not track feature");
			prefs.put("enable_do_not_track", true);
		}

		chromeOptions.setExperimentalOption("prefs", prefs);
		chromeOptions.addArguments("--enable-notifications");

		// Incognito?
		if (Boolean.parseBoolean(System.getProperty("privateBrowsingEnabled"))) {
			logger.info("Enabling private browsing");
			chromeOptions.addArguments("--incognito");
		}

		chromeOptions.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
		chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		chromeOptions.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);

		return chromeOptions;
	}

	public static void closeConnection() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	public void close() throws IOException {
		closeConnection();
	}
}