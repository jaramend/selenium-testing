package tests;

import org.testng.annotations.Test;

import base.BaseTest;

/**
 * First class of tests
 * 
 * @author jaramend
 *
 */
public class FirstClassTest extends BaseTest {

	/**
	 * First test
	 */
	@Test(description = "Test description", groups = { "group1" })
	public void testOne() {
		/**
		 * Test code
		 */
	}

	/**
	 * Second test
	 */
	@Test(description = "Test description", groups = { "group1" })
	public void testTwo() {
		/**
		 * Test code
		 */
	}

}