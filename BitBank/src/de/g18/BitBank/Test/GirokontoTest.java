package de.g18.BitBank.Test;

import de.g18.BitBank.Exception.BetragNegativException;
import de.g18.BitBank.Exception.KontoLeerException;
import de.g18.BitBank.Girokonto;
import de.g18.BitBank.Kontotyp;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GirokontoTest {
	private Girokonto k;

	@Before
	public void setUp() throws Exception {
		k = new Girokonto(1234, 34);
		k.setKontoStand(10000);
		k.setLimit(10000);
	}

	@Test
	public void testGirokontoErstellen() {
		assertEquals(123401034, k.getKontoNummer());
		assertEquals(10000, k.getKontoStand(), 0);
		assertEquals(Kontotyp.GIROKONTO, k.getKontoTyp());
	}

	@Test
	public void testAuszahlen() throws KontoLeerException, BetragNegativException {
		k.auszahlen(k.getLimit());
		assertEquals(0, k.getKontoStand(), 0);
	}

	@Test(expected = KontoLeerException.class)
	public void testUeberziehen() throws KontoLeerException, BetragNegativException {
		k.auszahlen(k.getLimit() + k.getKontoStand() + 1);
	}
}
