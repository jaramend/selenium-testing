package tests;

import org.testng.annotations.Test;

import base.BaseTest;

/**
 * Second class of tests. Class level annotation indicates that all methods
 * belong to group2 and will only execute if the tests in group1 are SUCCESS
 * 
 * @author jaramend
 *
 */
@Test(groups = { "group2" }, dependsOnGroups = { "group1" })
public class SecondClassTest extends BaseTest {

	/**
	 * First test
	 */
	@Test(description = "Test description")
	public void testOne() {
		/**
		 * Test code
		 */
	}

	/**
	 * Second test
	 */
	@Test(description = "Test description")
	public void testTwo() {
		/**
		 * Test code
		 */
	}

	/**
	 * Third test which will only run if the testTwo is SUCCESS
	 */
	@Test(description = "Test description", dependsOnMethods = { "testTwo" })
	public void testThree() {
		/**
		 * Test code
		 */
	}
}