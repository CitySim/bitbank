package de.g18.BitBank;

import de.g18.BitBank.Exception.BetragNegativException;
import de.g18.BitBank.Exception.KontoLeerException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Konto Klasse
 * 
 * @author it1-markde
 * @see Girokonto
 * @see Sparkonto
 * @since JRE6
 */
public abstract class Konto {
	private Kontotyp kontoTyp;
	private double kontoStand;
	private long kontoNummer;
	private List<Kontobewegung> kontoBewegungsListe = new ArrayList<Kontobewegung>();
	private List<Ueberweisung> ueberweisungsListe = new ArrayList<Ueberweisung>();

	/**
	 * Erstellt ein neues Konto.
	 * 
	 * @param kontoTyp
	 *            Typ des Kontos (Sparkonto / Girokonto).
	 * @param kundenNummmer
	 *            Nummer des Kundens im Bankverwaltungstool.
	 * @param indexNummer
	 *            IndexNummer des Kontos in der Kontoliste des Kunden.
	 */
	public Konto(Kontotyp kontoTyp, long kundenNummmer, int indexNummer) {
		this.kontoTyp = kontoTyp;
		this.kontoNummer = ((((long) kundenNummmer) * 100) + this
				.getKontoTypNumber()) * 1000 + indexNummer;
	}

	public double getKontoStand() {
		return kontoStand;
	}

	public void setKontoStand(double kontoStand) {
		this.kontoStand = kontoStand;
	}

	public long getKontoNummer() {
		return kontoNummer;
	}

	public List<Kontobewegung> getKontoBewegungsListe() {
		return kontoBewegungsListe;
	}

	public List<Ueberweisung> getUeberweisungsListe() {
		return ueberweisungsListe;
	}

	public Kontotyp getKontoTyp() {
		return kontoTyp;
	}

	/**
	 * Gibt einen Int je nach Kontoart wieder.
	 * 
	 * @return 1 für Kontotyp = Girokonto,0 für Sparkonto
	 */
	public int getKontoTypNumber() {
		if (this.getKontoTyp().toString().equals("GIROKONTO")) {
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * Addiert einen Betrag auf den aktuellen Kontostand.
	 * 
	 * @param betrag
	 *            zu addierender Wert.
	 */
	public void einzahlen(double betrag) throws BetragNegativException {
		if (betrag < 0) {
			throw new BetragNegativException("Betrag darf nicht negativ sein");
		}

		kontoStand += betrag;
		kontoBewegungsListe
				.add(new Kontobewegung(new java.util.Date(), betrag));

	}

	/**
	 * Subtrahiert einen Betrag von dem aktuellen Kontostand.
	 * 
	 * @param betrag
	 *            zu subtrahierender Wert.
	 * @throws Exception
	 */
	public void auszahlen(double betrag) throws BetragNegativException,
			KontoLeerException {
		if (betrag < 0) {
			throw new BetragNegativException("Betrag darf nicht negativ sein");
		}

		kontoStand -= betrag;
		kontoBewegungsListe
				.add(new Kontobewegung(new java.util.Date(), -betrag));
	}

	/**
	 * Erstellt ein Objekt von Ueberweisung und speichert dieses in der
	 * ueberweisungsliste.
	 * 
	 * @param zielKonto
	 *            Konto auf das ueberwiesen wird.
	 * @param betrag
	 *            zu ueberweisende Summe.
	 * @param datum
	 *            aktuelles Datum.F
	 * @throws BetragNegativException
	 * @throws KontoLeerException
	 */
	public void ueberweisen(Konto zielKonto, double betrag, Date datum)
			throws BetragNegativException, KontoLeerException {
		Ueberweisung ueberweisung = new Ueberweisung(this, zielKonto, betrag,
				datum);

		ueberweisung.durchfuehrenUeberweisung();
		this.ueberweisungsListe.add(ueberweisung);
	}
}
