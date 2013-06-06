package de.g18.BitBank.Test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import de.g18.BitBank.Girokonto;
import de.g18.BitBank.Konto;
import de.g18.BitBank.Exception.BetragNegativException;
import de.g18.BitBank.Exception.KontoLeerException;

/**
 * Testklasse fuer die Konto Klasse.
 * 
 * @author it1-korebj
 * @since jdk1.7.0_17
 */

public class KontoTest {

    private Konto k;

    @Before
    public final void setUp() throws Exception {
        this.k = new Girokonto(1234, 34);
        ((Girokonto) this.k).setLimit(1000);
    }

    @Test
    public final void kontoErstellen() {
        assertEquals(123401034, this.k.getKontoNummer());
        assertEquals(0, this.k.getKontoStand(), 0);
    }

    @Test
    public final void einzahlen() throws BetragNegativException {
        this.k.einzahlen(200);
        assertEquals(200, this.k.getKontoStand(), 0);

        // Es sollte genau ein Eintrag in der Liste sein.
        assertEquals(1, this.k.getKontoBewegungsListe().size());
        assertEquals(200, this.k.getKontoBewegungsListe().get(0).getBetrag(), 0);
    }

    @Test(expected = BetragNegativException.class)
    public final void negativenBetragEinzahlen() throws BetragNegativException {
        // Es können keine negative Betraege eingezahlt werden.
        this.k.einzahlen(-100);
        // Konto muss noch immer 0 haben, Betrag darf sich nicht aendern.
        assertEquals(200, this.k.getKontoStand(), 0);
    }

    @Test
    public final void fehlerBeimEinzahlenAendertBetragNicht() {
        try {
            this.k.einzahlen(-100);
        } catch (final BetragNegativException e) {
            // TODO
        }

        // Konto muss noch immer 0 haben, Betrag darf sich nicht aendern.
        assertEquals(0, this.k.getKontoStand(), 0);
    }

    @Test
    public final void auszahlen() throws KontoLeerException, BetragNegativException {
        this.k.auszahlen(200);
        assertEquals(-200, this.k.getKontoStand(), 0);

        // Es sollte genau ein Eintrag in der Liste sein.
        assertEquals(1, this.k.getKontoBewegungsListe().size());
        assertEquals(-200, this.k.getKontoBewegungsListe().get(0).getBetrag(), 0);
    }

    @Test(expected = BetragNegativException.class)
    public final void negativenBetragAuszahlen() throws KontoLeerException, BetragNegativException {
        // es können keine negativ beträge eingezahlt werden
        this.k.auszahlen(-100);
    }

    @Test
    public final void fehlerBeimAuszahlenAendertBetragNicht() {
        try {
            this.k.auszahlen(-100);
        } catch (final BetragNegativException e) {
            // TODO
        } catch (final KontoLeerException e) {
            // TODO
        }

        // Konto muss noch immer 0 haben, Betrag darf sich nicht aendern.
        assertEquals(0, this.k.getKontoStand(), 0);
    }

    @Test
    public final void testDurchfuehrenUeberweisung() throws BetragNegativException, KontoLeerException {
        this.k.einzahlen(200);
        final Konto ziel = new Girokonto(1234, 35);

        this.k.ueberweisen(ziel, 200, new Date());

        assertEquals(0, this.k.getKontoStand(), 0);
        assertEquals(200, ziel.getKontoStand(), 0);

        assertEquals(3, this.k.getKontoBewegungsListe().size());
        assertEquals(200, this.k.getKontoBewegungsListe().get(0).getBetrag(), 0); // Einzahlung
        assertEquals(-200, this.k.getKontoBewegungsListe().get(1).getBetrag(), 0); // Ueberweisung
        assertEquals(1, this.k.getUeberweisungsListe().size(), 1);

        assertEquals(2, ziel.getKontoBewegungsListe().size());
        assertEquals(200, ziel.getKontoBewegungsListe().get(0).getBetrag(), 0);
        assertEquals(1, ziel.getUeberweisungsListe().size());
        assertEquals(ziel.getUeberweisungsListe().get(0), ziel.getUeberweisungsListe().get(0));
    }
}
