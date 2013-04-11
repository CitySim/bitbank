package de.g18.BitBank.Test;

import de.g18.BitBank.Kontobewegung;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class KontobewegungTest {
	Kontobewegung kb;
	Date now;

	@Before
	public void setUp() throws Exception {
		now = new Date();
		kb = new Kontobewegung(now, 237.68);
	}

	@Test
	public void KontobewegungErstellen() {
		assertEquals(237.68, kb.getBetrag(), 0);
		assertEquals(now, kb.getDatum());
	}
}
