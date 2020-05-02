package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * Classe permettant d'exécuter du code selon le résultat de chaque test. Ici,
 * permet de logger le résultat de chaque méthode de test
 * 
 * @author jaramend
 *
 */
public class CustomListener extends TestListenerAdapter {

	private static final Logger logger = LogManager.getLogger(CustomListener.class);

	@Override
	public void onTestFailure(ITestResult tr) {
		CustomListener.logger.info("{} -- FAILED", tr.getName());
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		CustomListener.logger.info("{} -- SKIPPED", tr.getName());
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		CustomListener.logger.info("{} -- SUCCESS", tr.getName());
	}
}
