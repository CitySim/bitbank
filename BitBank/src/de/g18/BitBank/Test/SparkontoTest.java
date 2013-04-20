package de.g18.BitBank.Test;

import org.junit.Before;
import org.junit.Test;

import de.g18.BitBank.Sparkonto;
import de.g18.BitBank.Exception.BetragNegativException;
import de.g18.BitBank.Exception.KontoLeerException;

/**
 * Testklasse fuer die Sparkonto Klasse.
 * 
 * @author it1-korebj
 * @since JRE6
 */

public class SparkontoTest {
	private Sparkonto k;

	@Before
	public void setUp() throws Exception {
		k = new Sparkonto(1234, 34);
		k.setKontoStand(10000);
	}

	@Test
	public void testAuszahlen() throws BetragNegativException,
			KontoLeerException {
		k.auszahlen(k.getKontoStand());
	}

	/**
	 * Hier wird das Überziehen des Kontos getestet.
	 * 
	 * @throws BetragNegativException
	 *             Fehler bei negativen Beträgen
	 * @throws KontoLeerException
	 *             Fehler bei nicht bekannten Konten
	 */

	@Test(expected = KontoLeerException.class)
	public void testUeberziehen() throws BetragNegativException,
			KontoLeerException {
		k.auszahlen(k.getKontoStand() + 1);
	}
}
