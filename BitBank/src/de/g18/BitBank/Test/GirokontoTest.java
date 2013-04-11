/**
 * 
 */
package de.g18.BitBank.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.g18.BitBank.Girokonto;

/**
 * @author it1-korebj
 * 
 */
public class GirokontoTest {

	Girokonto k;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		k = new Girokonto(1234, 34);
		k.setKontoStand(10000);
		k.setLimit(10000);
	}

	/**
	 * Test method for {@link de.g18.BitBank.Girokonto#auszahlen(int)}.
	 */
	@Test
	public void testAuszahlen() {
		try {
			k.auszahlen(k.getLimit());
			assertEquals(0, k.getKontoStand(), 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Hier wird das Überziehen des Kontos getestet
	 */
	@Test
	public void testÜberziehen() {
		try {
			k.auszahlen(k.getLimit() + k.getKontoStand() + 1);
			fail("Expected an exception");
		} catch (Exception e) {
			assertNotNull(e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link de.g18.BitBank.Girokonto#Girokonto(de.g18.BitBank.Kontotyp, int, int)}
	 * .
	 */
	@Test
	public void testGirokonto() {
		assertEquals(123401034, k.getKontoNummer());
	}

}
