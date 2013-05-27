package de.g18.BitBank.Test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import de.g18.BitBank.Girokonto;
import de.g18.BitBank.Konto;
import de.g18.BitBank.Ueberweisung;
import de.g18.BitBank.Exception.BetragNegativException;
import de.g18.BitBank.Exception.KontoLeerException;

/**
 * Testklasse fuer die Ueberweisungs Klasse.
 * 
 * @author it1-korebj
 * @since jdk1.7.0_17
 */

public class UeberweisungTest {

    private Konto k1;
    private Konto k2;
    private Ueberweisung u;
    private Date now;

    @Before
    public void setUp() throws Exception {
        this.k1 = new Girokonto(1234, 34);
        this.k2 = new Girokonto(1234, 35);
        this.now = new Date();

        this.u = new Ueberweisung(this.k1, this.k2, 150, this.now);
    }

    @Test
    public void testUeberweisung() {
        assertEquals(150, this.u.getBetrag(), 0);
        assertEquals(this.now, this.u.getDatum());
        assertEquals(this.k1, this.u.getQuellKlasse());
        assertEquals(this.k2, this.u.getZielKlasse());
    }

    @Test
    public void testDurchfuehrenUeberweisung() throws KontoLeerException, BetragNegativException {
        this.k1.einzahlen(200);

        this.u.durchfuehrenUeberweisung();

        assertEquals(50, this.k1.getKontoStand(), 0);
        assertEquals(150, this.k2.getKontoStand(), 0);

        assertEquals(3, this.k1.getKontoBewegungsListe().size());
        assertEquals(200, this.k1.getKontoBewegungsListe().get(0).getBetrag(), 0); // einzahlung
        assertEquals(-150, this.k1.getKontoBewegungsListe().get(1).getBetrag(), 0); // überweisung
        assertEquals(1, this.k1.getUeberweisungsListe().size(), 1);

        assertEquals(2, this.k2.getKontoBewegungsListe().size());
        assertEquals(150, this.k2.getKontoBewegungsListe().get(0).getBetrag(), 0);
        assertEquals(1, this.k2.getUeberweisungsListe().size());
        assertEquals(this.k1.getUeberweisungsListe().get(0), this.k2.getUeberweisungsListe().get(0));
    }
}
