package de.g18.BitBank.Test;

import de.g18.BitBank.Sparkonto;
import org.junit.Before;
import org.junit.Test;

public class SparkontoTest {
	Sparkonto k;

	@Before
	public void setUp() throws Exception {
		k = new Sparkonto(1234, 34);
		k.setKontoStand(10000);
	}

	@Test
	public void testAuszahlen() throws Exception {
		k.auszahlen(k.getKontoStand());
	}

	/**
	 * Hier wird das Überziehen des Kontos getestet
	 */
	@Test(expected = Exception.class)
	public void testÜberziehen() throws Exception {
		k.auszahlen(k.getKontoStand() + 1);
	}
}
