package de.g18.BitBank.Test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import de.g18.BitBank.Kontobewegung;

/**
 * Testklasse fuer die Kontobewegungs Klasse.
 * 
 * @author it1-korebj
 * @since jdk1.7.0_17
 */

public class KontobewegungTest {

    private Kontobewegung kb;
    private Date now;

    @Before
    public void setUp() throws Exception {
        this.now = new Date();
        this.kb = new Kontobewegung(this.now, 237.68);
    }

    @Test
    public void kontobewegungErstellen() {
        assertEquals(237.68, this.kb.getBetrag(), 0);
        assertEquals(this.now, this.kb.getDatum());
    }
}
