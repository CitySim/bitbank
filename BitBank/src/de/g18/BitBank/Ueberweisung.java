package de.g18.BitBank;

import java.util.Date;

import de.g18.BitBank.Exception.BetragNegativException;
import de.g18.BitBank.Exception.KontoLeerException;

/**
 * Klasse zum uebertragen von Geld zwischen Konten.
 * 
 * @author it1-markde
 * @since jdk1.7.0_17
 */

public class Ueberweisung extends Kontobewegung {

    private final Konto quellKonto;
    private final Konto zielKonto;

    public Ueberweisung(final Konto quellKonto, final Konto zielKonto, final double betrag, final Date datum) {

        super(datum, betrag);

        this.quellKonto = quellKonto;
        this.zielKonto = zielKonto;
    }

    /**
     * Uebertraegt den betrag der ueberweisung von einem Konto zum anderen.
     * 
     * @throws BetragNegativException Fehler bei negativen Beträgen
     * @throws KontoLeerException Fehler bei nicht bekannten Konten
     */
    public final void durchfuehrenUeberweisung() throws BetragNegativException, KontoLeerException {
        this.quellKonto.auszahlen(super.getBetrag());
        this.zielKonto.einzahlen(super.getBetrag());

        this.quellKonto.getUeberweisungsListe().add(this);
        this.zielKonto.getUeberweisungsListe().add(this);
        this.quellKonto.getKontoBewegungsListe().add(this);
        this.zielKonto.getKontoBewegungsListe().add(this);
    }

    public final Konto getQuellKlasse() {
        return this.quellKonto;
    }

    public final Konto getZielKlasse() {
        return this.zielKonto;
    }

    @Override
    public final String getText() {
        return "Überweisun von " + this.getQuellKlasse().getKontoNummer() + " auf " + this.getZielKlasse().getKontoNummer();
    }
}
