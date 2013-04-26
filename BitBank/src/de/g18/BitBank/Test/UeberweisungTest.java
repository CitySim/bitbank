package de.g18.BitBank.Test;

import de.g18.BitBank.Exception.BetragNegativException;
import de.g18.BitBank.Exception.KontoLeerException;
import de.g18.BitBank.Girokonto;
import de.g18.BitBank.Konto;
import de.g18.BitBank.Ueberweisung;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Testklasse fuer die Ueberweisungs Klasse.
 *
 * @author it1-korebj
 * @since jdk1.7.0_17
 */

public class UeberweisungTest {
	private Konto k1;
	private Konto k2;
	private Ueberweisung u;
	private Date now;

	@Before
	public void setUp() throws Exception {
		k1 = new Girokonto(1234, 34);
		k2 = new Girokonto(1234, 35);
		now = new Date();

		u = new Ueberweisung(k1, k2, 150, now);
	}

	@Test
	public void testUeberweisung() {
		assertEquals(150, u.getBetrag(), 0);
		assertEquals(now, u.getDatum());
		assertEquals(k1, u.getQuellKlasse());
		assertEquals(k2, u.getZielKlasse());
	}

	@Test
	public void testDurchfuehrenUeberweisung() throws KontoLeerException,
			BetragNegativException {
		k1.einzahlen(200);

		u.durchfuehrenUeberweisung();

		assertEquals(50, k1.getKontoStand(), 0);
		assertEquals(150, k2.getKontoStand(), 0);

		assertEquals(3, k1.getKontoBewegungsListe().size());
		assertEquals(200, k1.getKontoBewegungsListe().get(0).getBetrag(), 0); // einzahlung
		assertEquals(-150, k1.getKontoBewegungsListe().get(1).getBetrag(), 0); // überweisung
		assertEquals(1, k1.getUeberweisungsListe().size(), 1);

		assertEquals(2, k2.getKontoBewegungsListe().size());
		assertEquals(150, k2.getKontoBewegungsListe().get(0).getBetrag(), 0);
		assertEquals(1, k2.getUeberweisungsListe().size());
		assertEquals(k1.getUeberweisungsListe().get(0), k2
				.getUeberweisungsListe().get(0));
	}
}
