package de.g18.BitBank.Test;

import static org.junit.Assert.fail;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import de.g18.BitBank.Girokonto;
import de.g18.BitBank.Konto;
import de.g18.BitBank.Ueberweisung;

public class UeberweisungTest {
	Konto k1 ;
	Konto k2;
	Ueberweisung u;
	Date now;
	
	@Before
	public void setUp() throws Exception {
		k1 = new Girokonto(1234, 34);
		k2 = new Girokonto(1234, 35);
		now = new Date();
		
		u = new Ueberweisung(k1, k2, 150, now);
	}

	@Test
	public void testUeberweisung() {
		Assert.assertEquals(u.getBetrag(), 150, 0);
		Assert.assertEquals(u.getDatum(), now);
		Assert.assertEquals(u.getQuellKlasse(), k1);
		Assert.assertEquals(u.getZielKlasse(), k2);
	}

	@Test
	public void testDurchfuehrenUeberweisung() throws Exception {
		k1.einzahlen(200);

		u.durchfuehrenUeberweisung();

		Assert.assertEquals(k1.getKontoStand(), 50, 0);
		Assert.assertEquals(k2.getKontoStand(), 150, 0);

		Assert.assertEquals(k1.getKontoBewegungsListe().size(), 2);
		Assert.assertEquals(k1.getKontoBewegungsListe().get(0).getBetrag(), 200); // einzahlung
		Assert.assertEquals(k1.getKontoBewegungsListe().get(1).getBetrag(), -150); // überweisung
		Assert.assertEquals(k1.getUeberweisungsListe().size(), 1);

		Assert.assertEquals(k2.getKontoBewegungsListe().size(), 1);
		Assert.assertEquals(k2.getKontoBewegungsListe().get(0).getBetrag(), 150);
		Assert.assertEquals(k2.getUeberweisungsListe().size(), 1);
		Assert.assertEquals(k2.getUeberweisungsListe().get(0), k1.getUeberweisungsListe().get(0));
	}
}
