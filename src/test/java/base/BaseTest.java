package base;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;

import exception.NoBrowserException;

/**
 * Classe abstraite dont héritent toutes les classes de test. Permet
 * d'initialiser le webdriver en mode remote avec Selenium Grid
 * 
 * @author jaramend
 *
 */
@Listeners(ExtentITestListenerClassAdapter.class)
public abstract class BaseTest {

	protected Properties props = getProps("test.properties");
	protected static WebDriver driver;
	private String baseUrl;
	private String remoteGridUrl;
	private String browser;

	private static final Logger logger = LogManager.getLogger(BaseTest.class);

	static {
		System.setProperty("extent.reporter.avent.start", "true");
		System.setProperty("extent.reporter.html.start", "true");
		System.setProperty("extent.reporter.avent.out", "test-output/AventReport/");
		System.setProperty("extent.reporter.html.out", "test-output/HtmlReport/ExtentHtml.html");
	}

	/**
	 * Initialisation de la configuration provenant du fichier test.properties
	 */
	@BeforeSuite(alwaysRun = true)
	public void startSuite() {
		this.baseUrl = this.props.getProperty("BASE_URL");
		this.remoteGridUrl = this.props.getProperty("REMOTE_GRID");
		this.browser = this.props.getProperty("BROWSER");
		logger.info("Using application on {}", this.baseUrl);
		logger.info("Using {} browser", this.browser);
	}

	/**
	 * Initialisation et démarrage du webdriver. S'exécute avant chaque méthode de
	 * test
	 * 
	 * @throws MalformedURLException
	 * @throws NoBrowserException
	 * 
	 * @throws Exception
	 */
	@BeforeMethod(alwaysRun = true)
	public void startBrowser() throws MalformedURLException, NoBrowserException {
		try {
			BaseTest.driver = Driver.startdriver(this.remoteGridUrl, this.browser);
			BaseTest.driver.get(this.baseUrl);
		} catch (MalformedURLException e) {
			logger.error(
					"URL of remote grid or application is not correct. Please correct it on the test.properties file.");
		} catch (NoBrowserException e) {
			logger.error(
					"No browser was configured on the test.properties file. Please choose between chrome and firefox to run your tests.");
		}
	}

	/**
	 * Arrêt et destruction du webdriver. S'exécute après chaque méthode de test
	 */
	@AfterMethod(alwaysRun = true)
	public void stopBrowser() {
		BaseTest.driver = Driver.stopDriver();
	}

	private Properties getProps(String filePath) {
		Properties prop = new Properties();

		try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
			prop.load(resourceAsStream);
		} catch (IOException e) {
			logger.error("Unable to load properties file : " + filePath);
		}

		return prop;
	}
}