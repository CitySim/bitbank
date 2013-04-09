package de.g18.BitBank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Konto Klasse
 * 
 * @see Girokonto
 * @see Sparkonto
 * @author it1-markde
 * @since JRE6
 */

public class Konto {

	private Kontotyp kontoTyp;
	protected double kontoStand;
	protected long kontoNummer;
	private List<Kontobewegung> kontoBewegungsListe = new ArrayList<Kontobewegung>();
	private List<Ueberweisung> ueberweisungsListe = new ArrayList<Ueberweisung>();

	/**
	 * Erstellt ein neues Konto.
	 * 
	 * @param kontoTyp
	 *            Typ des Kontos (Sparkonto / Girokonto).
	 * @param kundenNummer
	 *            Nummer des Kundens im Bankverwaltungstool.
	 * @param indexNummer
	 *            IndexNummer des Kontos in der Kontoliste des Kunden.
	 */

	public Konto(Kontotyp kontoTyp, int kundenNummer, int indexNummer) {
		this.kontoTyp = kontoTyp;
		this.kontoNummer = ((((long) kundenNummer) * 100) + this
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

	public void einzahlen(double betrag) {
		this.kontoStand = this.kontoStand + betrag;
		this.kontoBewegungsListe.add(new Kontobewegung(new java.util.Date(),
				betrag));

	}

	/**
	 * Subtrahiert einen Betrag von dem aktuellen Kontostand.
	 * 
	 * @param betrag
	 *            zu subtrahierender Wert.
	 * @throws Exception
	 */

	public void auszahlen(double betrag) throws Exception {
		this.kontoStand = this.kontoStand - betrag;
		this.kontoBewegungsListe.add(new Kontobewegung(new java.util.Date(),
				betrag));
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
	 * @throws Exception
	 */

	public void ueberweisen(Konto zielKonto, int betrag, Date datum)
			throws Exception {
		Ueberweisung ueberweisung = new Ueberweisung(this, zielKonto, betrag,
				datum);
		ueberweisung.durchfuehrenUeberweisung();
		this.ueberweisungsListe.add(ueberweisung);
	}
}
