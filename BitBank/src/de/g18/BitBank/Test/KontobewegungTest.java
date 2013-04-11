package de.g18.BitBank.Test;

import static org.junit.Assert.*;

import java.util.Date;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.g18.BitBank.Kontobewegung;

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
		Assert.assertEquals(kb.getBetrag(), 237.68, 0);
		Assert.assertEquals(kb.getDatum(), now);
	}
}
