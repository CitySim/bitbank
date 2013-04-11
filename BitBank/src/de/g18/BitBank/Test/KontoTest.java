package de.g18.BitBank.Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.g18.BitBank.Girokonto;
import de.g18.BitBank.Konto;

public class KontoTest {
	Konto k;

	@Before
	public void setUp() throws Exception {
		k = new Girokonto(1234, 34);
	}

	@Test
	public void KontoErstellen() {
		Assert.assertEquals(k.getKontoNummer(), 123401034);
		Assert.assertEquals(k.getKontoStand(), 0, 0);
	}

	@Test
	public void auszahlen() {

		k.einzahlen(200);
		Assert.assertEquals(k.getKontoStand(), 200, 0);

		// es sollte genau ein eintrag in der liste sein
		Assert.assertEquals(k.getKontoBewegungsListe().size(), 1);
		Assert.assertEquals(k.getKontoBewegungsListe().get(0).getBetrag(), 200,
				0);

		// es können keine negativ beträge eingezahlt werden
		// TODO: Assert.That(delegate() { k.einzahlen(-100); },
		// Throws.Exception);
		// konto muss noch immer 200 haben, betrag darf sich nicht ändern
		Assert.assertEquals(k.getKontoStand(), 200, 0);
	}
}
