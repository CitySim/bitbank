package de.g18.BitBank.Test;

import org.junit.Before;
import org.junit.Test;

import de.g18.BitBank.Sparkonto;
import de.g18.BitBank.Exception.BetragNegativException;
import de.g18.BitBank.Exception.KontoLeerException;

/**
 * Testklasse fuer die Sparkonto Klasse.
 * 
 * @author it1-korebj
 * @since jdk1.7.0_17
 */

public class SparkontoTest {

    private Sparkonto k;

    @Before
    public final void setUp() throws Exception {
        this.k = new Sparkonto(1234, 34);
        this.k.setKontoStand(10000);
    }

    @Test
    public final void testAuszahlen() throws BetragNegativException, KontoLeerException {
        this.k.auszahlen(this.k.getKontoStand());
    }

    /**
     * Hier wird das Überziehen des Kontos getestet.
     * 
     * @throws BetragNegativException Fehler bei negativen Beträgen
     * @throws KontoLeerException Fehler bei nicht bekannten Konten
     */

    @Test(expected = KontoLeerException.class)
    public final void testUeberziehen() throws BetragNegativException, KontoLeerException {
        this.k.auszahlen(this.k.getKontoStand() + 1);
    }
}
