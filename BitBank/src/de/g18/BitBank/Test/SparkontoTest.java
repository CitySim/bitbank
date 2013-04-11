/**
 * 
 */
package de.g18.BitBank.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import de.g18.BitBank.Sparkonto;

/**
 * @author it1-tattsv
 *
 */
public class SparkontoTest {

	Sparkonto k;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		k = new Sparkonto(1234, 34);
		k.setKontoStand(10000);
	}

	/**
	 * Test method for {@link de.g18.BitBank.Sparkonto#auszahlen(int)}.
	 */
	@Test
	public void testAuszahlen() {
		try {
			k.auszahlen(k.getKontoStand());
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
			k.auszahlen(k.getKontoStand() + 1);
			fail("Expected an exception");
		} catch (Exception e) {
			assertNotNull(e.getMessage());
		}
	}

}
