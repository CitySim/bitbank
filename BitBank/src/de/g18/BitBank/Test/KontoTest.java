package de.g18.BitBank.Test;

import de.g18.BitBank.Girokonto;
import de.g18.BitBank.Konto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KontoTest {
	Konto k;

	@Before
	public void setUp() throws Exception {
		k = new Girokonto(1234, 34);
	}

	@Test
	public void KontoErstellen() {
		assertEquals(123401034, k.getKontoNummer());
		assertEquals(0, k.getKontoStand(), 0);
	}

	@Test
	public void auszahlen() throws Exception {
		k.einzahlen(200);
		assertEquals(100, k.getKontoStand(), 0);

		// es sollte genau ein eintrag in der liste sein
		assertEquals(1, k.getKontoBewegungsListe().size());
		assertEquals(200, k.getKontoBewegungsListe().get(0).getBetrag(),
				0);
	}

	@Test(expected = Exception.class)
	public void negativenBetragAuszahlen() throws Exception {
		// es können keine negativ beträge eingezahlt werden
		k.einzahlen(-100);

		// konto muss noch immer 200 haben, betrag darf sich nicht ändern
		// TODO: wie soll man das testen?!
		// assertEquals(k.getKontoStand(), 200, 0);
	}
}