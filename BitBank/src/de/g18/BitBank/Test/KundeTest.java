package de.g18.BitBank.Test;

import de.g18.BitBank.Exception.KundenNummerUnzulaessigException;
import de.g18.BitBank.Kontotyp;
import de.g18.BitBank.Kunde;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Testklasse fuer die Kunde Klasse.
 * 
 * @author it1-korebj
 * @since jdk1.7.0_17
 */
public class KundeTest {
	private Kunde k;

	@Before
	public void setUp() throws KundenNummerUnzulaessigException {
		k = new Kunde("Karl Kunde", 00001111);
		k.anlegenKonto(Kontotyp.GIROKONTO);
	}

	@Test
	public void testKunde() {
		assertEquals("Karl Kunde", k.getName());
		assertEquals(00001111, k.getKundenNummmer());
	}

	@Test
	public void testAnlegenKonto() {
		System.out.println(k.getKontenListe());
		assertTrue(k.getKontenListe().size() == 1);
	}
}
