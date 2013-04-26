package de.g18.BitBank.Test;

import de.g18.BitBank.Exception.BetragNegativException;
import de.g18.BitBank.Exception.KontoLeerException;
import de.g18.BitBank.Girokonto;
import de.g18.BitBank.Konto;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Testklasse fuer die Konto Klasse.
 *
 * @author it1-korebj
 * @since jdk1.7.0_17
 */

public class KontoTest {
	private Konto k;

	@Before
	public void setUp() throws Exception {
		k = new Girokonto(1234, 34);
		((Girokonto) k).setLimit(1000);
	}

	@Test
	public void kontoErstellen() {
		assertEquals(123401034, k.getKontoNummer());
		assertEquals(0, k.getKontoStand(), 0);
	}

	@Test
	public void einzahlen() throws BetragNegativException {
		k.einzahlen(200);
		assertEquals(200, k.getKontoStand(), 0);

		// Es sollte genau ein Eintrag in der Liste sein.
		assertEquals(1, k.getKontoBewegungsListe().size());
		assertEquals(200, k.getKontoBewegungsListe().get(0).getBetrag(), 0);
	}

	@Test(expected = BetragNegativException.class)
	public final void negativenBetragEinzahlen() throws BetragNegativException {
		// Es können keine negative Betraege eingezahlt werden.
		k.einzahlen(-100);
		// Konto muss noch immer 0 haben, Betrag darf sich nicht aendern.
		assertEquals(200, k.getKontoStand(), 0);
	}

	@Test
	public void fehlerBeimEinzahlenAendertBetragNicht() {
		try {
			k.einzahlen(-100);
		} catch (BetragNegativException e) {
			e.printStackTrace();
		}

		// Konto muss noch immer 0 haben, Betrag darf sich nicht aendern.
		assertEquals(0, k.getKontoStand(), 0);
	}

	@Test
	public void auszahlen() throws KontoLeerException, BetragNegativException {
		k.auszahlen(200);
		assertEquals(-200, k.getKontoStand(), 0);

		// Es sollte genau ein Eintrag in der Liste sein.
		assertEquals(1, k.getKontoBewegungsListe().size());
		assertEquals(-200, k.getKontoBewegungsListe().get(0).getBetrag(), 0);
	}

	@Test(expected = BetragNegativException.class)
	public final void negativenBetragAuszahlen() throws KontoLeerException,
			BetragNegativException {
		// es können keine negativ beträge eingezahlt werden
		k.auszahlen(-100);
	}

	@Test
	public void fehlerBeimAuszahlenAendertBetragNicht() {
		try {
			k.auszahlen(-100);
		} catch (BetragNegativException e) {
			e.printStackTrace();
		} catch (KontoLeerException e) {
			e.printStackTrace();
		}

		// Konto muss noch immer 0 haben, Betrag darf sich nicht aendern.
		assertEquals(0, k.getKontoStand(), 0);
	}

	@Test
	public void testDurchfuehrenUeberweisung() throws BetragNegativException,
			KontoLeerException {
		k.einzahlen(200);
		Konto ziel = new Girokonto(1234, 35);

		k.ueberweisen(ziel, 200, new Date());

		assertEquals(0, k.getKontoStand(), 0);
		assertEquals(200, ziel.getKontoStand(), 0);

		assertEquals(3, k.getKontoBewegungsListe().size());
		assertEquals(200, k.getKontoBewegungsListe().get(0).getBetrag(), 0); // Einzahlung
		assertEquals(-200, k.getKontoBewegungsListe().get(1).getBetrag(), 0); // Ueberweisung
		assertEquals(1, k.getUeberweisungsListe().size(), 1);

		assertEquals(2, ziel.getKontoBewegungsListe().size());
		assertEquals(200, ziel.getKontoBewegungsListe().get(0).getBetrag(), 0);
		assertEquals(1, ziel.getUeberweisungsListe().size());
		assertEquals(ziel.getUeberweisungsListe().get(0), ziel
				.getUeberweisungsListe().get(0));
	}
}
