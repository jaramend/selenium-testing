package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * Class allowing to execute code according to the result of each test. Here,
 * allows to log the result of each test method
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
