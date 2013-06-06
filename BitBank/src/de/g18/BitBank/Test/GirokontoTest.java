package de.g18.BitBank.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.g18.BitBank.Girokonto;
import de.g18.BitBank.Kontotyp;
import de.g18.BitBank.Exception.BetragNegativException;
import de.g18.BitBank.Exception.KontoLeerException;

/**
 * Testklasse fuer die Girokonto Klasse.
 * 
 * @author it1-korebj
 * @since jdk1.7.0_17
 */

public class GirokontoTest {

    private Girokonto k;

    @Before
    public final void setUp() throws Exception {
        this.k = new Girokonto(1234, 34);
        this.k.setKontoStand(10000);
        this.k.setLimit(10000);
    }

    @Test
    public final void testGirokontoErstellen() {
        assertEquals(123401034, this.k.getKontoNummer());
        assertEquals(10000, this.k.getKontoStand(), 0);
        assertEquals(Kontotyp.GIROKONTO, this.k.getKontoTyp());
    }

    @Test
    public final void testAuszahlen() throws KontoLeerException, BetragNegativException {
        this.k.auszahlen(this.k.getLimit());
        assertEquals(0, this.k.getKontoStand(), 0);
    }

    @Test(expected = KontoLeerException.class)
    public final void testUeberziehen() throws KontoLeerException, BetragNegativException {
        this.k.auszahlen(this.k.getLimit() + this.k.getKontoStand() + 1);
    }
}
