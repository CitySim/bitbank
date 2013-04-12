/**
 * 
 */
package de.g18.BitBank.Test;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.g18.BitBank.Kontotyp;
import de.g18.BitBank.Kunde;

/**
 * @author it1-tattsv
 * 
 */
public class KundeTest {

	Kunde k;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		k = new Kunde("Karl Kunde", 00001111);
		k.anlegenKonto(Kontotyp.GIROKONTO);
	}

	/**
	 * Test method for {@link de.g18.BitBank.Kunde#Kunde(java.lang.String, int)}
	 */
	@Test
	public void testKunde() {
		assertEquals("Karl Kunde", k.getName());
		assertEquals(00001111, k.getKundenNummmer());
	}

	/**
	 * Test method for
	 * {@link de.g18.BitBank.Kunde#anlegenKonto(de.g18.BitBank.Kontotyp)}.
	 */
	@Test
	public void testAnlegenKonto() {
		System.out.println(k.getKontenListe());
		assertTrue(k.getKontenListe().size() == 1);
	}
}
