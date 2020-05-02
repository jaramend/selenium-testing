package tests;

import org.testng.annotations.Test;

import base.BaseTest;

/**
 * Seconde classe de tests. L'annotation au niveau de la classe permet
 * d'indiquer que toutes les méthodes appartiennent au group2 et ne
 * s'exécuteront que si les tests du group1 sont SUCCESS
 * 
 * @author jaramend
 *
 */
@Test(groups = { "group2" }, dependsOnGroups = { "group1" })
public class SecondClassTest extends BaseTest {

	/**
	 * Premier test
	 */
	@Test(description = "Description du test")
	public void testOne() {
		/**
		 * Test code
		 */
	}

	/**
	 * Second test
	 */
	@Test(description = "Description du test")
	public void testTwo() {
		/**
		 * Test code
		 */
	}

	/**
	 * Troisième test qui ne s'exécutera que si le testTwo est SUCCESS
	 */
	@Test(description = "Description du test", dependsOnMethods = { "testTwo" })
	public void testThree() {
		/**
		 * Test code
		 */
	}
}