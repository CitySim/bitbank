package de.g18.BitBank.Test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import de.g18.BitBank.Girokonto;
import de.g18.BitBank.Konto;
import de.g18.BitBank.Exception.BetragNegativException;
import de.g18.BitBank.Exception.KontoLeerException;

public class KontoTest {
	private Konto k;

	@Before
	public void setUp() throws Exception {
		k = new Girokonto(1234, 34);
		((Girokonto) k).setLimit(1000);
	}

	@Test
	public void KontoErstellen() {
		assertEquals(123401034, k.getKontoNummer());
		assertEquals(0, k.getKontoStand(), 0);
	}

	@Test
	public void einzahlen() throws BetragNegativException {
		k.einzahlen(200);
		assertEquals(200, k.getKontoStand(), 0);

		// es sollte genau ein eintrag in der liste sein
		assertEquals(1, k.getKontoBewegungsListe().size());
		assertEquals(200, k.getKontoBewegungsListe().get(0).getBetrag(), 0);
	}

	@Test(expected = BetragNegativException.class)
	public void negativenBetragEinzahlen() throws BetragNegativException {
		// es können keine negativ beträge eingezahlt werden
		k.einzahlen(-100);
		// konto muss noch immer 0 haben, betrag darf sich nicht ändern
		assertEquals(200, k.getKontoStand(), 0);
	}

	@Test
	public void FehlerBeimEinzahlenAendertBetragNicht() {
		try {
			k.einzahlen(-100);
		} catch (BetragNegativException e) {
			e.printStackTrace();
		}

		// konto muss noch immer 0 haben, betrag darf sich nicht ändern
		assertEquals(0, k.getKontoStand(), 0);
	}

	@Test
	public void auszahlen() throws KontoLeerException, BetragNegativException {
		k.auszahlen(200);
		assertEquals(-200, k.getKontoStand(), 0);

		// es sollte genau ein eintrag in der liste sein
		assertEquals(1, k.getKontoBewegungsListe().size());
		assertEquals(-200, k.getKontoBewegungsListe().get(0).getBetrag(), 0);
	}

	@Test(expected = BetragNegativException.class)
	public void negativenBetragAuszahlen() throws KontoLeerException,
			BetragNegativException {
		// es können keine negativ beträge eingezahlt werden
		k.auszahlen(-100);
	}

	@Test
	public void FehlerBeimAuszahlenAendertBetragNicht() {
		try {
			k.auszahlen(-100);
		} catch (BetragNegativException e) {
			e.printStackTrace();
		} catch (KontoLeerException e) {
			e.printStackTrace();
		}

		// konto muss noch immer 0 haben, betrag darf sich nicht ändern
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

		assertEquals(2, k.getKontoBewegungsListe().size());
		assertEquals(200, k.getKontoBewegungsListe().get(0).getBetrag(), 0); // einzahlung
		assertEquals(-200, k.getKontoBewegungsListe().get(1).getBetrag(), 0); // überweisung
		assertEquals(1, k.getUeberweisungsListe().size(), 1);

		assertEquals(1, ziel.getKontoBewegungsListe().size());
		assertEquals(200, ziel.getKontoBewegungsListe().get(0).getBetrag(), 0);
		assertEquals(1, ziel.getUeberweisungsListe().size());
		assertEquals(ziel.getUeberweisungsListe().get(0), ziel
				.getUeberweisungsListe().get(0));
	}
}
