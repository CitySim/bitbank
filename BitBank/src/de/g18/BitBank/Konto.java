package de.g18.BitBank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.g18.BitBank.Exception.BetragNegativException;
import de.g18.BitBank.Exception.KontoLeerException;

/**
 * Konto Klasse.
 * 
 * @author it1-markde
 * @see Girokonto
 * @see Sparkonto
 * @since jdk1.7.0_17
 */
public abstract class Konto {

    private final Kontotyp kontoTyp;
    private double kontoStand;
    private final long kontoNummer;
    private final List<Kontobewegung> kontoBewegungsListe = new ArrayList<Kontobewegung>();
    private final List<Ueberweisung> ueberweisungsListe = new ArrayList<Ueberweisung>();

    /**
     * Erstellt ein neues Konto.
     * 
     * @param kontoTyp Typ des Kontos (Sparkonto / Girokonto).
     * @param kundenNummmer Nummer des Kundens im Bankverwaltungstool.
     * @param indexNummer IndexNummer des Kontos in der Kontoliste des Kunden.
     */
    Konto(final Kontotyp kontoTyp, final long kundenNummmer, final int indexNummer) {
        this.kontoTyp = kontoTyp;
        this.kontoNummer = (((kundenNummmer) * 100) + this.getKontoTypNumber()) * 1000 + indexNummer;
    }

    public final double getKontoStand() {
        return this.kontoStand;
    }

    public final void setKontoStand(final double kontoStand) {
        this.kontoStand = kontoStand;
    }

    public final long getKontoNummer() {
        return this.kontoNummer;
    }

    public final List<Kontobewegung> getKontoBewegungsListe() {
        return this.kontoBewegungsListe;
    }

    public final List<Ueberweisung> getUeberweisungsListe() {
        return this.ueberweisungsListe;
    }

    public final Kontotyp getKontoTyp() {
        return this.kontoTyp;
    }

    /**
     * Gibt einen Int je nach Kontoart wieder.
     * 
     * @return 1 für Kontotyp = Girokonto,0 für Sparkonto
     */
    public final int getKontoTypNumber() {
        if (this.getKontoTyp().toString().equals("GIROKONTO")) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Addiert einen Betrag auf den aktuellen Kontostand.
     * 
     * @param betrag zu addierender Wert.
     * @throws BetragNegativException Fehler bei negativen Beträgen
     */
    public final void einzahlen(final double betrag) throws BetragNegativException {
        if (betrag < 0) {
            throw new BetragNegativException("Betrag darf nicht negativ sein");
        }

        // Multiplizieren und Dividieren mit Faktor 1000 zur Umgehung eines Bugs
        // bei der Rechnung mit Double.
        this.kontoStand = (this.kontoStand * 1000 + (betrag * 1000)) / 1000;
        this.kontoBewegungsListe.add(new Kontobewegung(new java.util.Date(), betrag));

    }

    /**
     * Subtrahiert einen Betrag von dem aktuellen Kontostand.
     * 
     * @param betrag zu subtrahierender Wert.
     * @throws BetragNegativException Fehler bei negativen Beträgen
     * @throws KontoLeerException Fehler bei unbekannten Konten
     */
    public void auszahlen(final double betrag) throws BetragNegativException, KontoLeerException {
        if (betrag < 0) {
            throw new BetragNegativException("Betrag darf nicht negativ sein");
        }

        // Multiplizieren und Dividieren mit Faktor 1000 zur Umgehung eines Bugs
        // bei der Rechnung mit Double.
        this.kontoStand = (this.kontoStand * 1000 - (betrag * 1000)) / 1000;
        this.kontoBewegungsListe.add(new Kontobewegung(new java.util.Date(), -betrag));
    }

    /**
     * Erstellt ein Objekt von UeberweisungVornehmen und speichert dieses in der ueberweisungsliste.
     * 
     * @param zielKonto Konto auf das ueberwiesen wird.
     * @param betrag zu ueberweisende Summe.
     * @param datum aktuelles Datum.
     * @throws BetragNegativException Fehler bei negativen Beträgen
     * @throws KontoLeerException Fehler bei unbekannten Konten
     */
    public final void ueberweisen(final Konto zielKonto, final double betrag, final Date datum) throws BetragNegativException,
            KontoLeerException {
        final Ueberweisung ueberweisung = new Ueberweisung(this, zielKonto, betrag, datum);

        ueberweisung.durchfuehrenUeberweisung();
        this.ueberweisungsListe.add(ueberweisung);
    }
}
