package de.g18.BitBank.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import de.g18.BitBank.Kontotyp;
import de.g18.BitBank.Kunde;
import de.g18.BitBank.Exception.KundenNummerUnzulaessigException;

/**
 * Testklasse fuer die Kunde Klasse.
 * 
 * @author it1-korebj
 * @since jdk1.7.0_17
 */
public class KundeTest {

    private Kunde k;

    @Before
    public final void setUp() throws KundenNummerUnzulaessigException {
        this.k = new Kunde("Karl Kunde", 00001111);
        this.k.anlegenKonto(Kontotyp.GIROKONTO);
    }

    @Test
    public final void testKunde() {
        assertEquals("Karl Kunde", this.k.getName());
        assertEquals(00001111, this.k.getKundenNummmer());
    }

    @Test
    public final void testAnlegenKonto() {
        System.out.println(this.k.getKontenListe());
        assertTrue(this.k.getKontenListe().size() == 1);
    }
}
