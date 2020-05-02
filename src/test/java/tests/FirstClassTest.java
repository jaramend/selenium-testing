package tests;

import org.testng.annotations.Test;

import base.BaseTest;

/**
 * Première classe de tests
 * 
 * @author jaramend
 *
 */
public class FirstClassTest extends BaseTest {

	/**
	 * Premier test
	 */
	@Test(description = "Description du test", groups = { "group1" })
	public void testOne() {
		/**
		 * Test code
		 */
	}

	/**
	 * Second test
	 */
	@Test(description = "Description du test", groups = { "group1" })
	public void testTwo() {
		/**
		 * Test code
		 */
	}

}