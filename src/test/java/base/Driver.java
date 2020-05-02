package base;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import exception.NoBrowserException;

/**
 * Webdriver management class
 * 
 * @author jaramend
 *
 */
public class Driver {

	public static WebDriver driver = null;
	private static final Logger logger = LogManager.getLogger(Driver.class);

	public static WebDriver startdriver(String grid_url, String browser)
			throws MalformedURLException, NoBrowserException {
		if (null == Driver.driver) {
			if ("chrome".equals(browser)) {
				ChromeOptions options = new ChromeOptions();
				Driver.driver = new RemoteWebDriver(new URL(grid_url), options);
			} else if ("firefox".equals(browser)) {
				FirefoxOptions options = new FirefoxOptions();
				Driver.driver = new RemoteWebDriver(new URL(grid_url), options);
			} else {
				throw new NoBrowserException("No browser configurated");
			}
		}
		Driver.logger.info("Driver : {}", driver);
		return Driver.driver;
	}

	public static WebDriver stopDriver() {
		if (null != Driver.driver) {
			Driver.driver.manage().deleteAllCookies();
			Driver.driver.quit();
			Driver.driver = null;
		}

		return Driver.driver;
	}
}
