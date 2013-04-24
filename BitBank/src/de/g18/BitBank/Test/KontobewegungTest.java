package de.g18.BitBank.Test;

import de.g18.BitBank.Kontobewegung;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Testklasse fuer die Kontobewegungs Klasse.
 * 
 * @author it1-korebj
 * @since JRE6
 */

public class KontobewegungTest {
	private Kontobewegung kb;
	private Date now;

	@Before
	public void setUp() throws Exception {
		now = new Date();
		kb = new Kontobewegung(now, 237.68);
	}

	@Test
	public void kontobewegungErstellen() {
		assertEquals(237.68, kb.getBetrag(), 0);
		assertEquals(now, kb.getDatum());
	}
}
